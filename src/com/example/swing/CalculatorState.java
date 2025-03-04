package com.example.swing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculatorState {
  // 계산 기능만 저장해둘거고, 여기다가 내생각에는 값들 저장을 해야해
  // 실제계산해야할 값인 ArrayList, 근데 이게 만약에 값이 순서대로 쌓이죠.
  private static List<Object> calculatorList = new ArrayList<>();

  // 연산 과정을 보여주는 Text
  public static String stepText  = "";


  // 값을 받아두는 상자
  private static String inputNumber = "";

  // 연산기호를 저장해주는 아이도 필요하겠죠. 얘는 리스트로 해야할까.. 값이 없으면 그러면 연산을 수행하면 안돼.
  // 근데 값이 있으면 ? 결과값도 주고 Symbol 에 남아있는 값을 지워주고, 새로운 연산기호로 채워주는 거지.
  private static List<String> symbolList = new ArrayList<>();



  // Setter. 값을 추가해주는 기능
  public void addInputNumber(String number){
    inputNumber= inputNumber + number;
  }


  public void addSymbolList(String number){
    symbolList.add(number);
  }

  // 어떤 값을 받아올 때 그 값을 리스트에 추가해줄 걸 찾는 것.
  public <S> void addCalculatorList(S number){
    calculatorList.add(number);
  }

  // Getter. 값을 찾아주는 기능
  public String getInputString(){
    return inputNumber;
  }

  public List<Object> getCalculatorList(){
    return calculatorList;
  }

  public List<String> getSymbolList(){
    return symbolList;
  }


  // symbol list 사이즈
  public int getSymbolListSize(){
    return symbolList.size();
  }

  // symbol list 사이즈
  public int getCalculatorListSize(){
    return calculatorList.size();
  }


  // 리스트 지워주는 기능
  public void clearSymbolList(){
    symbolList.clear();
  }

  public void clearInputNumber(){
    inputNumber = "";
  }
  public void clearCalculatorList() {
    calculatorList.clear();
  }
  // Label 추가
  public void insertLabel(JLabel label, String text){
    label.setText(text);
  }

}
