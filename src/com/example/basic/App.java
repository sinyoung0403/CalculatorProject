package com.example.basic;

import com.example.basic.io.input.Input;
import com.example.basic.io.output.Output;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    // 초기화.
    calculator.setNum(0,0);
    boolean exit = false;
    while (!exit) {
      Output.printStepDivider();
      // 숫자 두 개 받기
      int firstInt = Input.getIntSc("첫 번째 숫자를 입력하세요. : ");
      int secondInt = Input.getIntSc("두 번째 숫자를 입력하세요. : ");
      calculator.setNum(firstInt,secondInt);

      // 기호 입력 받기
      char symbol = Input.getCharSc("사칙연산 기호를 입력하세요. : ");

      // 연산 결과를 calculator 에서 실행하기
      Output.printOutput("입력 값: " + calculator.getNum());
      Output.printOutput("결과 값: "+calculator.calculate(symbol));
      Output.printLineDivider();

      // 값의 삭제 및 추가 여부 받기
      Output.printOutput("현재 저장되어 있는 값: " + calculator.getResultList() );
      String deleteString = Input.getStringSc("( 엔터 입력 시 스킵 | D 입력 시 가장 먼저 저장된 값 삭제)");

      // 값을 삭제하고 싶을 시 removeResult() 함수 호출
      if(deleteString.equals("D")||deleteString.equals("d")) {
        calculator.removeResult();
      }
      Output.printLineDivider();

      // exit 입력 시 탈출
      String exitString = Input.getStringSc("더 계산하시겠습니까? ( 엔터 입력 시 계속 계산 | exit 입력시 종료 )");
      exit = exitString.equalsIgnoreCase("exit");
    }
    // 종료
    Output.printStepDivider();
    System.out.println("계산완료");
  }
}
