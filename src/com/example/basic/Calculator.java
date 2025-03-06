package com.example.basic;

import com.example.basic.io.output.Output;
import com.example.swing.swingui.SwingOutput;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Calculator<T extends Number> {
  // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
  private static List<Number> resultList = new ArrayList<>();

  // 제네릭 멤버변수 선언
  T num01;
  T num02;


  // 생성자로 멤버변수 초기화 하기
  Calculator(T num01, T num02){
    this.num01 = num01;
    this.num02 = num02;
  }

  public enum OperatorType{
    PLUS((a, b) -> a.doubleValue() + b.doubleValue()),
    MINUS((a, b) -> a.doubleValue() - b.doubleValue()),
    MULTIPLY((a, b) -> a.doubleValue() * b.doubleValue()),
    DIVIDE((a, b) -> a.doubleValue() / b.doubleValue());

    private final OperatorFunction operatorFunction;

    // 생성자
    OperatorType(OperatorFunction operatorFunction){
      this.operatorFunction = operatorFunction;
    }
    // 계산 메서드
    public Double apply(Number a, Number b){
      return this.operatorFunction.apply(a,b);
    }
  }
  // 람다식을 사용하기 위한 함수형 인터페이스
  public interface OperatorFunction{
    double apply(Number a, Number b);
  }

  // 값 저장하는 기능
  public double calculate(char symbol) {
    double result;
    switch (symbol) {
      case '+':
        result = OperatorType.PLUS.apply(num01,num02);
        break;
      case '-':
        result = OperatorType.MINUS.apply(num01,num02);
        break;
      case '/':
        if(num02.doubleValue() == 0){
          throw new ArithmeticException("두 번째 숫자가 0이면 안됩니다.");
        } else {
          result = OperatorType.DIVIDE.apply(num01,num02);
          break;
        }
      case '*':
        result = OperatorType.MULTIPLY.apply(num01,num02);
        break;
      default:
        throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
    }
    return result;
  }

  /* getter start */
  // getter 함수
  public String getResultList(){
    return resultList.stream().map(String::valueOf).reduce((s1,s2)-> s1+", "+s2).orElse("");
  }

  /* setter start*/
  // 값을 추가해주는 함수
  public void addResultList(Double value){
    resultList.add(value);
  }


  // 값을 삭제하는 기능
  public void removeResult() {
    Output.printOutput("가장 먼저 저장된 값인 ["+resultList.get(0) + "] 을 삭제합니다. ");
    resultList.remove(0);
    Output.printOutput("현재 저장된 값: "+resultList);
  }

  // scanner로 입력 받은 값보다 큰 결과 값들을 출력
  public void selectBigResultList(Integer num){
    // 값을 받을 시, 해당 값보다 큰 값들을 stream 을 통해서 filter 작업
    List<Number> bigResultList = resultList.stream()
            .filter(n-> n.doubleValue() > num.doubleValue())
            .collect(Collectors.toList());
    // 해당 리스트를 stream을 이용하여 리스트로 만들어 주기
    String bigResultListStr = bigResultList.stream().map(String::valueOf)
            .reduce((s1,s2) -> s1 + ", "+ s2).orElse("");
    Output.printOutput(num + " 보다 큰 결과값 : [ " + bigResultListStr+" ] ");
  }

}

