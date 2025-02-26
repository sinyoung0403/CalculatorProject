package com.example.basic;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Calculator calculator = new Calculator();
    String exitBool = " ";
    while (true) {
      // exitBool 값이 exit일 경우와 아닐 경우를 통해 분기 다르게 하기.
      if (exitBool.equals("exit")) { // exit 일 경우 반복문 나가기
        break;
      }
      else { // exit 일 경우 아래 연산 수행하기
      // 숫자 두 개 받기
      System.out.println("첫 번째 숫자를 입력하세요.");
      int firstInt = sc.nextInt();
      System.out.println("두 번째 숫자를 입력하세요.");
      int secondInt = sc.nextInt();
      // 기호를 받을 때는 공백을 제거해주었다.
      System.out.print("사칙연산 기호를 입력하세요: ");
      String symbol = sc.next().trim();

      // 연산 결과를 calculator 에서 실행하기
      System.out.println("결과 값: "+calculator.calculate(firstInt,secondInt,symbol));
      }

      // 종료값을 받아주기. exit 입력 시 탈출
      System.out.println("현재 저장되어 있는 값: " + calculator.getResultList() );
      System.out.print("더 계산하시겠습니까? (더 하고 싶을 시, 엔터 입력 | exit 입력시 종료) ");
      sc.nextLine(); // 공백 제거
      exitBool = sc.nextLine();

      // 값의 삭제 및 추가 여부 받기.
      System.out.println("저장되어 있는 최근 값을 추가 및 삭제하시겠습니까?( C 입력 시 추가 | D 입력 시 삭제) ");
      String deleteBool = sc.nextLine();
      // 값을 삭제하고 싶을 시 removeResult() 함수 호출
      if(deleteBool.equals("D")||deleteBool.equals("d")) {
        calculator.removeResult();
      }
      // 값을 추가하고 싶을 시 setResultList() 함수 호출
      else if (deleteBool.equals("C")||deleteBool.equals("c")) {
        System.out.println("추가할 값을 입력해주세요:");
        int setterInt = sc.nextInt();
        calculator.setResultList(setterInt);
      }
    }
    // 종료
    System.out.println("계산완료");
  }
}
