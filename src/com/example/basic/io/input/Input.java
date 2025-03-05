package com.example.basic.io.input;

import java.util.Scanner;

public class Input {
  private static Scanner scanner = new Scanner(System.in);

  public static int inputIntSc(String text) {
    System.out.print(text);
    int value = scanner.nextInt();
    scanner.nextLine();// 개행문자 처리해주기
    return value;
  }

  public static char inputCharSc(String text) {
    System.out.print(text);
    char value = scanner.next().charAt(0);
    scanner.nextLine();// 개행문자 처리해주기
    return value;
  }

  public static String inputStringSc(String text) {
    System.out.print(text);
    String value = scanner.nextLine();
    return value;
  }

  public static Number identifyAndConvert(String text) {
    System.out.print(text);
    String value = scanner.nextLine();
    try {
      return Integer.valueOf(value);  // int로 변환
    } catch (NumberFormatException e1) {
      // 정수 변환 실패 시 실수로 변환을 시도
      try {
        return Double.valueOf(value);  // double로 변환
      } catch (NumberFormatException e2) {
        throw new IllegalArgumentException("숫자 타입이 아닙니다.");
      }
    }
  }
}
