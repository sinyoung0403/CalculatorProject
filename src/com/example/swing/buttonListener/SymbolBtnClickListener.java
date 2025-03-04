package com.example.swing.buttonListener;

import com.example.swing.CalculatorState;
import com.example.swing.Calculators;
import com.example.swing.SwingOutput;
import com.example.swing.SwingUI;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class SymbolBtnClickListener implements ActionListener {
  // 속성 정의 뭔가 필요할까.. 음.. 일단 또 .. 똑같이 라벨을 가져와야지 ㅎㅎ?
  // 똑같이 라벨과 frame 을 정의하자.
  // 속성 정의
  private JFrame frame;
  private JLabel stateLabel;
  private JLabel presentLabel;
  CalculatorState cs;

  //생성자 정의
  public SymbolBtnClickListener(JFrame frame, JLabel stateLabel,JLabel presentLabel, CalculatorState calculatorState){
    this.frame = frame;
    this.stateLabel=stateLabel;
    this.presentLabel = presentLabel;
    this.cs = calculatorState;
  }

  // 기능 정의
  // 버튼을 사칙연산 버튼을 클릭 했을 시 버튼 동작.
  // = 버튼을 누를 시 > 만약 사칙연산 버튼이 이미 있었다면 ? > 그러면 값을 삭제해주어야지
  //                 > 만약 사칙연산 버튼이 없었다면 ? 사칙연산을 저장해둔다.
  public void actionPerformed(ActionEvent e) {
    JButton sourceButton = (JButton) e.getSource();
    String buttonText = sourceButton.getText();
    switch (buttonText){
      case "=":
        equalBtnListener();
        break;
      // 주의 해야할 부분 ! +-*/ 로 값을 넣어 뒀다는 것 !!!
      case "➕":
        System.out.println(buttonText);
        arithmeticBtnListener("+");
        break;
      case "➖":
        System.out.println(buttonText);
        arithmeticBtnListener("-");
        break;
      case "*":
        System.out.println(buttonText);
        arithmeticBtnListener("*");
        break;
      case "➗":
        System.out.println(buttonText);
        arithmeticBtnListener("/");
        break;
      default:
        SwingOutput.showErrorDialog("버튼 클릭 오류발생");
    }

  }

  public void equalBtnListener(){
    Calculators calc = new Calculators();
//    presentLabel.setText(number.toString());
//    stateLabel.setText(number.toString());

    if (cs.getCalculatorList().size() == 0) {
      String stringNumber = cs.getInputString();
      // 만약 stringNumber 가 비어있다면 에러 발생.
      if (stringNumber.isEmpty()) {
        SwingOutput.showErrorDialog("숫자를 입력하신 후에 '=' 를 눌러주세요.");
      }
      else{
        cs.addCalculatorList(Double.valueOf(stringNumber));

        System.out.println("담겨진 값" + stringNumber);
        System.out.println("저장되어 있는 값들" + cs.getCalculatorList());
      }

    }
    else { // 만약 값이 비어져있지 않다면 ? > 마지막 끝에를
      String stringNumber = cs.getInputString();
      cs.addCalculatorList(Double.valueOf(stringNumber));
      cs.clearInputNumber();
      // 이러면 연산을 수행해주어야해.
      Double num1 = (Double) cs.getCalculatorList().get(0);
      Double num2 = (Double) cs.getCalculatorList().get(2);
      String symbol = (String) cs.getCalculatorList().get(1);
      calc.setCalculate(symbol);
      calc.setNum(num1, num2);
      Double result = calc.calculate();
      System.out.println("result = " + result);
      cs.stepText = num1 +" "+ symbol + " "+ num2 + "  =";
      stateLabel.setText(cs.stepText);
      presentLabel.setText(result.toString());
      // 연산을 수행 했으면, 값을 다 빼고 !
      System.out.println("저장되어 있는 값들" + cs.getCalculatorList());
      cs.clearCalculatorList();
      cs.clearInputNumber();
      System.out.println("삭제확인" + cs.getCalculatorList());
    }

  }

  // 산술 연산 버튼 클릭 시
  public void arithmeticBtnListener(String text) {
    Calculators calc = new Calculators();
    // getCalculatorList 값이 비어져있다면 ? 추가만 해주기
    String stringNumber = cs.getInputString();
    if(stringNumber.isEmpty()){
      SwingOutput.showErrorDialog("숫자를 입력하신 후에 '+' 를 눌러주세요.");
    }
    // 값을 받았음. 일단 리스트가 비어 있을 때
    // 기호버튼을 클릭할 때마다 무조건 result?Lavel 을 고쳐주어야함.
    else if(cs.getCalculatorList().isEmpty()){
      cs.addCalculatorList(Double.valueOf(stringNumber));
      cs.addCalculatorList(text);
      cs.stepText = cs.getCalculatorList().stream().map(Object::toString).reduce("", (s1, s2) -> s1 + s2);
      cs.insertLabel(SwingUI.stateLabel,CalculatorState.stepText);
      cs.clearInputNumber();
    }
    else {
      // 만약 값이 비어져있지 않다면 ? > 마지막 끝에를
      // 여기도 똑같이.
      cs.addCalculatorList(Double.valueOf(stringNumber));
      cs.clearInputNumber();
      // 이러면 연산을 수행해주어야해.
      Double num1 = (Double) cs.getCalculatorList().get(0);
      Double num2 = (Double) cs.getCalculatorList().get(2);
      String symbol = (String) cs.getCalculatorList().get(1);
      calc.setCalculate(symbol);
      calc.setNum(num1, num2);
      Double result = calc.calculate();
      System.out.println("result = " + result);
      System.out.println("저장되어 있는 값들" + cs.getCalculatorList());
      cs.stepText = num1 +" "+ text + " "+ num2 + "  =";
      stateLabel.setText(cs.stepText);
      // 연산을 수행 했으면, 값을 다 빼고 !
      presentLabel.setText(result.toString());
      cs.clearCalculatorList();
      cs.addCalculatorList(result);
      cs.addCalculatorList(text);
      System.out.println("연산후!!**********");
      System.out.println("저장되어 있는 값들" + cs.getCalculatorList());
      cs.stepText = cs.getCalculatorList().stream().map(Object::toString).reduce("", (s1, s2) -> s1 + s2);
      cs.insertLabel(SwingUI.stateLabel,CalculatorState.stepText);
    }

  }
}
