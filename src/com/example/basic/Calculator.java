package com.example.basic;

import com.example.basic.io.output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Calculator {

  // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
  private List<Number> resultList = new ArrayList<>();

  // Lv2 에서는 정수값만을 받기를 원함
  private int num01;
  private int num02;
  Number result;

  // Getter 함수. List 접근 가능
  public List<Number> getResultList() {
    return this.resultList;
  }

  // Getter 함수. 기존 입력 값 가져오기
  public List<Number> getNum() {
    return List.of(num01, num02);
  }

  // Setter 함수. 입력값 바꾸기
  public void setNum(int num01, int num02) {
    this.num01 = num01;
    this.num02 = num02;
  }

  /* 기능 정의*/
  // 값을 더하는 함수
  public Number sum(){
    return this.num01 + this.num02;
  }

  // 값을 빼는 함수
  public Number subtract(){
    return this.num01 - this.num02;
  }

  // 값을 곱하는 함수
  public Number multiply(){
    return this.num01 * this.num02;
  }

  // 값을 나누는 함수
  public Number divide(){
    if (this.num02 == 0){
      throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
    }
    else {
      return (double)num01 / (double) num02;
    }
  }

  // 값 저장하는 기능
  public Number calculate(char symbol) {
    switch (symbol) {
      case '+':
        result = sum();
        break;
      case '-':
        result = subtract();
        break;
      case '/':
        result = divide();
        break;
      case '*':
        result = multiply();
        break;
      default:
        throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
    }
    resultList.add(result);
    return result;
  }

  // 값을 삭제하는 기능
  public void removeResult() {
    Output.printOutput("가장 먼저 저장된 값인 ["+resultList.get(0) + "] 을 삭제합니다. ");
    resultList.remove(0);
    Output.printOutput("현재 저장된 값: "+resultList);
  }
}

