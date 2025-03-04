package com.example.swing.logic;

import com.example.swing.swingui.SwingOutput;

public class Calculators {

  // enum 으로 선언
  public enum operatorMode {
    normal, sum, subtract, multiply, divide
  }
  // 속성 정의
  private Double num1, num2;

  // 0 으로 초기화 해두기.
  public Calculators(){
    num1 = 0.0;
    num2 = 0.0;
  }

  public void setNum(Double num1, Double num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  // 이게 값을 설정하지 않았을 때 nomal 로 해두면 초기상태가 된다네.
  private operatorMode mode = operatorMode.normal;

  /* 기능 정의*/
  public double calculate(){
    switch (mode){
      case sum:
        return num1 + num2;
      case subtract:
        return num1 - num2;
      case multiply:
        return num1 * num2;
      case divide:
        if (num2 == 0){
          SwingOutput.showErrorDialog("0은 나눌 수 없습니다.");
          throw new ArithmeticException("0은 나눌 수 없습니다.");
        }
        else{
          return num1/ num2;
        }
      case normal:
        return num2;
      default:
        return 0;
    }
  }


  // 기호에 달리 연산 수행
  public void setCalculate(String symbol) {
    switch (symbol) {
      case "+":
        mode = operatorMode.sum;
        break;
      case "-":
        mode = operatorMode.subtract;
        break;
      case "/":
        mode = operatorMode.divide;
        break;
      case "*":
        mode = operatorMode.multiply;
        break;
      default:
        throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
    }
  }
}
