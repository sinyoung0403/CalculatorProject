package com.example.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Calculator {
  // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
  // 속성 정의 > 인터페이스 리스트 형태로 받는게 낫다.
  private List<Object> resultList = new ArrayList<Object>();;
  Number result;

  // Getter 함수. List 접근 가능
  public List<Object> getResultList() {
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
      System.out.println("분모는 0이 되면 안됩니다.");
      return 0;
    }
    else {
      return (double)val1 / (double) val2;
    }
  }

  // 값 저장 클래스
  public Number calculate(int firstInt, int secondInt, String symbol) {
    switch (symbol) {
      case "+":
        result = sum(firstInt, secondInt);
        break;
      case "-":
        result = subtract(firstInt, secondInt);
        break;
      case "/":
        result = divide(firstInt, secondInt);
        break;
      case "*":
        result = multiply(firstInt, secondInt);
        break;
      default:
        System.out.println("잘못입력하였습니다.");
    }
    resultList.add(result);
    return result;
  }

  // 값을 삭제하는 기능
  public void removeResult() {
    System.out.println("가장 최근에 저장된 값 ["+resultList.get(resultList.size()-1) + "] 을 삭제합니다. ");
    resultList.remove(resultList.size()-1);
    System.out.println("현재 저장된 값: "+resultList);
  }
}

