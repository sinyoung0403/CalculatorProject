package com.example.swing.buttonListener;
import com.example.swing.logic.CalculatorState;
import com.example.swing.swingui.SwingOutput;
import com.example.swing.swingui.SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class DeleteBtnClickListener implements ActionListener {
  JLabel stateLabel;
  JLabel presentLabel;

  public DeleteBtnClickListener(JLabel stateLabel, JLabel presentLabel) {
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
        }
        // Calculator List 가 비어 있을 경우
        else{
          if (cs.getCalculatorListSize() == 0){
            cs.removeInputNumber();
            cs.insertLabel(presentLabel,cs.getInputString());
          }
          // 만약 CalculatorList 값이 있을 경우  / setCalculatorList
          else {
            cs.removeInputNumber();
            cs.insertLabel(presentLabel,cs.getInputString());
          }
        }

      }
      // 초기화 버튼 클릭
      else if (buttonText.equals("C")) {
        // 전부 다 초기화
        cs.clearInputNumber();
        cs.clearCalculatorList();
        cs.clearStepText();
        // 라벨들 가져오기
        String stepText = cs.getStepText();
        String inputText = cs.getInputString();
        cs.insertLabel(stateLabel,stepText);
        cs.insertLabel(presentLabel,inputText);
      }
      // Input 값만 비우기
      else if (buttonText.equals("CE")) {
        cs.clearInputNumber();
        String inputText = cs.getInputString();
        cs.insertLabel(presentLabel,inputText);
      }

      // Max 값을 받아와 삭제
      else if (buttonText.equals("<html>MAX<br>DEL</html>")) {
        List<Double> saveList = cs.getSaveResultList();
        Optional<Double> maxValue = cs.getSaveResultList()
                .stream()
                .reduce(Double::max);
        // maxValue 가 값이 없으면?
        if (maxValue.isEmpty()){
          SwingOutput.showErrorDialog("저장 값이 없는 상태에서 누를 수 없습니다.");
        }
        else{
          int maxIndex = IntStream.range(0, saveList.size())
                                    .reduce((i,j) -> saveList.get(i) >= saveList.get(j) ? i:j).orElse(-1);
          // 값이 없을 경우 에러 출력
          if(maxIndex == -1){
            SwingOutput.showErrorDialog("에러발생");
          }
          else{
            // Optional 이기 때문에 get 형식으로 받기
            SwingOutput.showDialog("저장된 값 중 가장 큰 값 [" + maxValue.get() + "] 이 삭제되었습니다.");
            cs.removeSaveList(maxIndex);
            // 저장값 재출력
            String textList = (String) cs.getSaveList()
                    .stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
            SwingUI.myList.setText("<html>"+textList+"</html>");
          }
        }

      }
      else if (buttonText.equals("Delete")) {
        List<Double> saveList = cs.getSaveResultList();
        if(saveList.isEmpty()){
          SwingOutput.showErrorDialog("저장 값이 없는 상태에서 누를 수 없습니다.");
        }
        else{
          cs.removeSaveList(0);
          // 저장값 재출력
          String textList = (String) cs.getSaveList()
                  .stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
          SwingUI.myList.setText("<html>"+textList+"</html>");
        }
      }

    }

  }
}
