package com.example.swing.logic;

import com.example.swing.swingui.SwingOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculators<T extends Number> {
  // 속성 정의
  private T num1, num2;
  // T가 어떤 타입인지 타입이라는 변수에 정의

  // return 값 줄때 T에 맞는 type 으로 줄려고. 미리 등록을 해두는 것.
  private Class<T> type;

  // enum 으로 선언
  public enum OperatorMode {
    SUM("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");


    private final String symbol;


    OperatorMode(String symbol){
      this.symbol = symbol;
    }
    public static OperatorMode convertSymbol(String symbol){
      // OperatorMode 안에 symbol 을 가진 애가 있느냐.
      for (OperatorMode operatorMode: values()){
        if(operatorMode.symbol.equals(symbol)){
          return operatorMode;
        }
      }
      throw new IllegalArgumentException("올바른 연산 기호를 입력하세요. (+, -, *, /)");
    }
  }

  // Double 로 받지말고 T로 받자.
  public void setNum(T num1, T num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  private BigDecimal toBigDecimal(T number){
    return new BigDecimal(number.toString());
  }

  // Int 면 Integer로 반환
  private T toType(BigDecimal result){
    // 타입이 만일 null 일 경우, 기본타입으로 주기
    if (type == null) {
      type = (Class<T>) Double.class;
    }
    if(type == Integer.class){
      return type.cast(result.intValue());
    } else if (type == Double.class) {
      return type.cast(result.doubleValue());
    }
    throw new IllegalStateException("Type is not initialized");
  }



  /* 기능 정의*/
  // 제네릭으로 반환값 설정 ?  BigDecimal 숫자계의 king ? 꺽세 있으면 파라미터, 꺽세없으면 반환.
  // BigDecimal이 가장 정확한 숫자. >
  public T ArithmeticCalculator(OperatorMode mode){
    CalculatorState cs = new CalculatorState();
    BigDecimal result = null;
    switch (mode){
      case SUM:
        result = toBigDecimal(num1).add(toBigDecimal(num2));
        break;
      case SUBTRACT:
        result = toBigDecimal(num1).subtract(toBigDecimal(num2));
        break;
      case MULTIPLY:
        result = toBigDecimal(num1).multiply(toBigDecimal(num2));
        break;
      case DIVIDE:
        // 괄호안에 있는 값이랑 일치하면 0, 크면 1, 작으면 -1 0 이면
        if (toBigDecimal(num2).compareTo(BigDecimal.ZERO) == 0){
          cs.clearInputNumber();
          cs.clearStepText();
          cs.clearCalculatorList();
          SwingOutput.showErrorDialog("0은 나눌 수 없습니다.");
          throw new ArithmeticException("0은 나눌 수 없습니다.");
        }
        else{
          result = toBigDecimal(num1).divide(toBigDecimal(num2), RoundingMode.HALF_UP);
          break;
        }
    }
    return toType(result);
  }
}
