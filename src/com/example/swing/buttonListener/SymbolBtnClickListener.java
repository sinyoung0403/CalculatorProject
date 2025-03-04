package com.example.swing.buttonListener;

import com.example.swing.logic.CalculatorState;
import com.example.swing.logic.Calculators;
import com.example.swing.swingui.SwingOutput;
import com.example.swing.swingui.SwingUI;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SymbolBtnClickListener implements ActionListener {

  // 속성 정의
  JLabel stateLabel;
  JLabel presentLabel;
  CalculatorState cs;

  //생성자 정의
  public SymbolBtnClickListener(JLabel stateLabel,JLabel presentLabel, CalculatorState calculatorState){
    this.stateLabel=stateLabel;
    this.presentLabel = presentLabel;
    this.cs = calculatorState;
  }

  // 기능 정의
  // 버튼을 사칙연산 버튼을 클릭 했을 시 버튼 동작.
  // 버튼을 누를 시 > = 버튼을 클릭 => equalBtnListener() 함수 동작
  //               > 사칙연산 버튼 클릭 => arithmeticBtnListener() 함수 동작
  public void actionPerformed(ActionEvent e) {
    JButton sourceButton = (JButton) e.getSource();
    String buttonText = sourceButton.getText();
    switch (buttonText){
      case "=":
        equalBtnListener();
        break;
      // 주의 해야할 부분 ! +-*/ 로 값을 넣어 뒀다는 것 !!!
      case "➕":
        arithmeticBtnListener("+");
        break;
      case "➖":
        arithmeticBtnListener("-");
        break;
      case "*":
        arithmeticBtnListener("*");
        break;
      case "➗":
        arithmeticBtnListener("/");
        break;
      default:
        SwingOutput.showErrorDialog("버튼 클릭 오류발생");
    }
  }

  public void equalBtnListener(){
    Calculators calc = new Calculators();
    String stringNumber = cs.getInputString();

    // 받아온 값이 비어있을 경우 오류 메시지 출력
    if (stringNumber.isEmpty()) {
      SwingOutput.showErrorDialog("숫자를 입력하신 후에 [ = ] 를 눌러주세요. [ = ]은 계산 결과 값을 초기화합니다.");
    }
    // input 란이 비어있지 않다면?
    else{
      // Calculator List 가 비어있는 경우 새로운 값 추가
      if (cs.getCalculatorList().isEmpty()) {
        cs.addCalculatorList(Double.valueOf(stringNumber));
        cs.stepString = stringNumber;
        stateLabel.setText(cs.getStepText());
        presentLabel.setText(cs.getInputString());
      }

      // Calculator List 에 숫자만 있을 경우
      else if (cs.getCalculatorList().size() == 1) {
        stringNumber = cs.getInputString();
        cs.setCalculatorList(Double.valueOf(stringNumber));
        cs.stepString = stringNumber;
        stateLabel.setText(cs.getStepText());
        presentLabel.setText(cs.getInputString());
      }

      // Calculator List 에 숫자와 기호가 있을 경우
      else {
        // 값을 수정했을 경우를 위하여 값을 받아와 재저장
        cs.addCalculatorList(Double.valueOf(stringNumber));
        cs.clearInputNumber();

        // 연산 수행
        Double num1 = (Double) cs.getCalculatorList().get(0);
        Double num2 = (Double) cs.getCalculatorList().get(2);
        String symbol = (String) cs.getCalculatorList().get(1);
        calc.setCalculate(symbol);
        calc.setNum(num1, num2);
        Double result = calc.calculate();

        // 결과 저장
        String setText = num1 +" "+ symbol + " "+ num2 + "  =" + result;
        cs.stepString = setText;
        cs.addSaveList(setText,result);
        stateLabel.setText(setText);
        presentLabel.setText(result.toString());

        // 연산을 수행 후 초기화
        cs.clearCalculatorList();
        cs.clearInputNumber();
        cs.addCalculatorList(result);
        cs.setInputNumber("");

        // 값이 나올 때 마다, 저장된 값들은 출력해야함.
        String textList = (String) cs.getSaveList()
                .stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
        SwingUI.myList.setText("<html>"+textList+"</html>");
      }
    }
  }

  // 산술 연산 버튼 클릭 시
  public void arithmeticBtnListener(String text) {
    Calculators calc = new Calculators();
    String stringNumber = cs.getInputString();

    // 받아온 값이 비어있을 경우 오류 메시지 출력
    if(stringNumber.isEmpty()){
      SwingOutput.showErrorDialog("숫자를 입력하신 후에 [ "+text+" ] 를 눌러주세요.");
    }

    // Calculator List 가 비어 있을 경우
    else if(cs.getCalculatorList().isEmpty()){
      cs.addCalculatorList(Double.valueOf(stringNumber));
      cs.addCalculatorList(text);
      cs.stepString = cs.getCalculatorList().stream().map(Object::toString).reduce("", (s1, s2) -> s1 + s2);
      stateLabel.setText(cs.getStepText());
      cs.clearInputNumber();
    }

    // Calculator List 에 숫자만 있을 경우
    else if(cs.getCalculatorList().size() ==1){
      stringNumber = cs.getInputString();
      cs.setCalculatorList(Double.valueOf(stringNumber));
      cs.addCalculatorList(text);
      cs.clearInputNumber();
      cs.stepString = cs.getCalculatorList().stream().map(Object::toString).reduce("", (s1, s2) -> s1 + s2);
      stateLabel.setText(cs.getStepText());
      presentLabel.setText(cs.getInputString());
    }

    // Calculator List 에 숫자와 기호가 있을 경우
    else{
      // 값을 수정했을 경우를 위하여 값을 받아와 재저장
      cs.addCalculatorList(Double.valueOf(stringNumber));
      cs.clearInputNumber();

      // 연산 수행
      Double num1 = (Double) cs.getCalculatorList().get(0);
      Double num2 = (Double) cs.getCalculatorList().get(2);
      String symbol = (String) cs.getCalculatorList().get(1);
      calc.setCalculate(symbol);
      calc.setNum(num1, num2);
      Double result = calc.calculate();


      // 값을 초기화해준 후 stepText 수정
      String setText = num1 +" "+ symbol + " "+ num2 + "  =" + result;
      presentLabel.setText(result.toString());
      cs.stepString = setText;
      cs.addSaveList(setText,result);
      stateLabel.setText(setText);
      cs.setInputNumber(result.toString());

      // 연산을 수행 했으면, 값 초기화
      cs.clearCalculatorList();
      cs.addCalculatorList(result);
      cs.addCalculatorList(text);
      cs.setInputNumber("");

      // 값이 나올 때 마다, 저장된 값들은 출력해야함.
      String textList = (String) cs.getSaveList()
              .stream().reduce("",(s1,s2) -> s1+"<br>"+s2+"<br>");
      SwingUI.myList.setText("<html>"+textList+"</html>");
    }
  }
}


