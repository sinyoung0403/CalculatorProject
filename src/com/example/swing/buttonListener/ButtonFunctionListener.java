package com.example.swing.buttonListener;
import com.example.swing.logic.CalculatorState;
import com.example.swing.swingui.SwingOutput;
import com.example.swing.swingui.SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class ButtonFunctionListener implements ActionListener {
  JLabel stateLabel;
  JLabel presentLabel;

  public ButtonFunctionListener(JLabel stateLabel, JLabel presentLabel) {
    this.stateLabel = stateLabel;
    this.presentLabel = presentLabel;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    CalculatorState cs = new CalculatorState();
    String stringNumber = cs.getInputString();

    // e 이벤트가 JButton 일 경우
    if (e.getSource() instanceof JButton) {
      // 버튼임을 명시
      JButton sourceButton = (JButton) e.getSource();
      // Jbtn Text get
      String buttonText = sourceButton.getText();

      // 지우기 버튼
      if (buttonText.equals("◀")) {
        // 값이 비어있는데 값 지우기를 하였을 경우 오류 발생
        if(stringNumber.isEmpty()){
          SwingOutput.showErrorDialog("값을 제대로 입력해주셔야 합니다.");
        } else{// Calculator List 가 비어 있을 경우
          if (cs.getCalculatorListSize() == 0){
            cs.removeInputNumber();
            cs.insertLabel(presentLabel,cs.getInputString());
          } else {// 만약 CalculatorList 값이 있을 경우  / setCalculatorList
            cs.removeInputNumber();
            cs.insertLabel(presentLabel,cs.getInputString());
          }
        }
      } else if (buttonText.equals("C")) { // 초기화 버튼 클릭
        // 전부 다 초기화
        cs.clearInputNumber();
        cs.clearCalculatorList();
        cs.clearStepText();

        // 라벨들 가져오기
        String stepText = cs.getStepText();
        String inputText = cs.getInputString();
        cs.insertLabel(stateLabel,stepText);
        cs.insertLabel(presentLabel,inputText);
      } else if (buttonText.equals("CE")) { // CE 버튼 클릭
        // Input 값만 비우기
        cs.clearInputNumber();
        String inputText = cs.getInputString();
        cs.insertLabel(presentLabel,inputText);
      } else if (buttonText.equals("Big")) {  // 입력값 보다 큰 값 출력해주는 Big 버튼 클릭
        List<Double> saveList = cs.getSaveResultList();

        if(stringNumber.isEmpty()){
          SwingOutput.showErrorDialog("값을 입력 후 클릭해주세요.");
        } else{
            // bigListValues 가 값이 없으면?
            if (saveList.isEmpty()) {
              SwingOutput.showErrorDialog("저장 값이 없는 상태에서 누를 수 없습니다.");
            } else{
              // 현재값 보다 큰 값들을 조회 ! 이걸 스트림으로 하라했나 ? Lambda & Stream을 활용하여 구현합니다.
              // presentValue 를 받을 수 있어야함.
              Double presentValue = Double.valueOf(stringNumber);
              List<Number> bigListValues = saveList.stream()
                      .filter(n-> n > presentValue)
                      .collect(Collectors.toList());

              String bigListValuesStr = bigListValues.stream().map(String::valueOf)
                      .reduce((s1,s2) -> s1 + ", "+ s2).orElse("");
              SwingOutput.showDialog(presentValue + " 보다 큰 결과값 : [ " + bigListValuesStr+" ] ");

              String textList = (String) cs.getSaveList().stream()
                      .reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
              SwingUI.myList.setText("<html>"+textList+"</html>");
            }
        }
      } else if (buttonText.equals("Del")) {// 삭제 버튼 클릭
        List<Double> saveList = cs.getSaveResultList();

        // Input 값이 비어 있을 경우 오류 출력
        if(saveList.isEmpty()){
          SwingOutput.showErrorDialog("저장 값이 없는 상태에서 누를 수 없습니다.");
        } else{
          // 값 초기화
          cs.removeSaveList(0);
          cs.removeSaveResultList(0);

          // 저장값 재출력
          String textList = (String) cs.getSaveList()
                  .stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
          SwingUI.myList.setText("<html>"+textList+"</html>");
          SwingOutput.showDialog("가장 먼저 저장된 값이 삭제되었습니다.");
        }
      } else if (buttonText.equals("Negative")) { // 음수 버튼 클릭
        // input 값이 비어 있을 경우 오류 출력
        if(stringNumber.isEmpty()){
          SwingOutput.showErrorDialog("값을 입력해주세요.");
        } else{
          if(stringNumber.contains("-")){
            SwingOutput.showErrorDialog("이미 음수입니다.");
          } else{
            cs.setInputNumber("-"+stringNumber);
            String negativeStringNumber = cs.getInputString();
            presentLabel.setText(negativeStringNumber);
          }
        }
      }
    }
  }
}
