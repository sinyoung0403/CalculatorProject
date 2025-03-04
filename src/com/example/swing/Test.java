package com.example.swing;

import com.example.basic.Calculator;

public class Test {
  public static void main(String[] args) {
    Calculators calc = new Calculators();

    // 일단 계산은 num1 과 num2 에 다가 하면 되긴 함 !
    // 1. inputNumber 를 받아서 그걸 inputNumber 에 저장했다가.
    // 2. 기호가 클릭되는 순간에 전부다 calculatorList 로 전달
    // 3. calculatorList에 기호랑 같이 저장하는 거지 !
    // 4. 만약에 전달된 List 의 size가 3이 된다 ?
    //  >> 그러면 숫자1개 기호 1개 숫자 1개인거기 때문에
    //  >> 0번째 인덱스랑 2번째 인덱스를 여기 setNum 로 보내버리면 됨 !

    calc.setNum(10.0 , 10.0);
    calc.setCalculate("+");
    System.out.println("Result: " + calc.calculate());  // 출력: Result: 15.0

  }
}
