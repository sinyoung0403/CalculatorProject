package com.example.calculator;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String exitBool = " ";
    while (true) {
      // 1. 숫자 두 개 받기
      System.out.println("첫 번째 숫자를 입력하세요.");
      int firstInt = sc.nextInt();
      System.out.println("두 번째 숫자를 입력하세요.");
      int secondInt = sc.nextInt();
      // 2. 기호를 받을 때는 공백을 제거해주었다.
      System.out.print("사칙연산 기호를 입력하세요: ");
      String symbol = sc.next().trim();

      // 3. exitBool 값이 exit일 경우와 아닐 경우를 통해 분기 다르게 하기.
      if(exitBool.equals("exit")){
        break;
      }
      else{
        switch (symbol) {
          case "+" :
            System.out.println(firstInt+secondInt);
            break;
          case "-" :
            System.out.println(firstInt-secondInt);
            break;
          case "/" :
            if(secondInt ==0){ // 분모가 0일 경우 break
              System.out.println("나눗셈 연산에서는 분모(두번째 정수)에 0이 입력될 수 없습니다");
              break;
            }
            else{
              // 나눗셈의 경우 형변환하여 나눗셈 해주기 / 실수가 나오게.
              double a = firstInt;
              double b= secondInt;
              System.out.println(a/b);
              break;
            }
          case "*" :
            System.out.println(firstInt*secondInt);
            break;
          default:
            System.out.println("잘못입력하였습니다.");
        }
      }
      // 4. 종료값을 받아주기. exit 입력 시 탈출
      System.out.print("더 계산하시겠습니까? (더 하고 싶을 시, 엔터 입력 | exit 입력시 종료) ");
      sc.nextLine();
      exitBool = sc.nextLine();
    }
    // 5. 종료를 알리기
    System.out.println("종료되었습니다.");
  }
}
