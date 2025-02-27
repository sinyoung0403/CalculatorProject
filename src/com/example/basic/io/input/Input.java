package com.example.basic.io.input;

import java.util.Scanner;

public class Input {
  private static Scanner scanner = new Scanner(System.in);

  public static int getIntSc(String text) {
    System.out.print(text);
    int value = scanner.nextInt();
    scanner.nextLine();// 개행문자 처리해주기
    return value;
  }

  public static char getCharSc(String text) {
    System.out.print(text);
    char value = scanner.next().charAt(0);
    scanner.nextLine();// 개행문자 처리해주기
    return value;
  }

  public static String getStringSc(String text) {
    System.out.print(text);
    String value = scanner.nextLine();
    return value;
  }

}
