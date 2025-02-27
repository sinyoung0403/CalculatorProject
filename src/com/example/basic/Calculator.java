package com.example.basic;

import com.example.basic.io.output.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Calculator {
  // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
  // 속성 정의 > 인터페이스 리스트 형태로 받는게 낫다.
  private List<Number> resultList = new ArrayList<Number>();;
  Number result;

  // Getter 함수. List 접근 가능
  public List<Number> getResultList() {
    return this.resultList;
  }

  // Setter 함수. List 에 값을 추가할 수 있음.
  public void setResultList(Number value) {
    this.resultList.add(value);
  }

  /* 기능 정의*/
  // 값을 더하는 함수
  int sum(int val1, int val2){
    return val1 + val2;
  }
  // 값을 빼는 함수
  int subtract(int val1, int val2){
    return val1 - val2;
  }
  // 값을 곱하는 함수
  int multiply(int val1, int val2){
    return val1 * val2;
  }
  // 값을 나누는 함수
  double divide(int val1, int val2){
    if (val2 == 0){
      throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
    }
    else {
      return (double)val1 / (double) val2;
    }
  }

  // 값 저장 클래스
  public Number calculate(int firstInt, int secondInt, char symbol) {
    switch (symbol) {
      case '+':
        result = sum(firstInt, secondInt);
        break;
      case '-':
        result = subtract(firstInt, secondInt);
        break;
      case '/':
        result = divide(firstInt, secondInt);
        break;
      case '*':
        result = multiply(firstInt, secondInt);
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

