package com.example.swing.logic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorState {

  /* Fields Start */
  // 실제 계산해야 할 값인 ArrayList
  private static List<Object> calculatorList = new ArrayList<>();

  // 연산 과정을 보여주는 문자열
  public static String stepString = "";

  // 값을 받아두는 문자열
  private static String inputString = "";

  // 전체 결과 값들 저장하는 List
  private static List<Object> saveList = new ArrayList<>();

  // 결과값만 저장하는 List
  private static List<Double> saveResultList = new ArrayList<>();
  /* Fields Finish */

  /* Setter Start */
  public void addInputNumber(String number){
    inputString = inputString + number;
  }

  public void setInputNumber(String number){
    inputString = number;
  }

  public void addSaveList(String text,Double number){
    saveList.add(text);
    saveResultList.add(number);
  }

  //값을 지웠을 경우, calculatorList의 값을 바꾸어 주어야함.
  public <S> void setCalculatorList(S number){
    calculatorList.set(0, number);
  }

  // 어떤 값을 받아올 때 그 값을 리스트에 추가해줄 걸 찾는 것.
  public <S> void addCalculatorList(S number){
    calculatorList.add(number);
  }
  /* Setter Finish */

  /* Getter Start */
  public String getInputString(){
    return inputString;
  }

  public String getStepText(){
    return stepString;
  }

  public List<Object> getCalculatorList(){
    return calculatorList;
  }

  public List<Object> getSaveList(){
    return saveList;
  }
  
  public List<Double> getSaveResultList(){
    return saveResultList;
  }

  // CalculatorList 사이즈
  public int getCalculatorListSize(){
    return calculatorList.size();
  }
  /* Getter Finish */

  /* remove method Start */
  public void clearInputNumber(){
    inputString = "";
  }

  public void clearStepText(){
    stepString = "";
  }

  public void clearCalculatorList() {
    calculatorList.clear();
  }

  public void removeInputNumber(){
    inputString = inputString.substring(0, inputString.length()-1);
  }

  public void removeSaveList(int number){
    saveResultList.remove(number);
    saveList.remove(number);
  }
  /* remove method finish */

  /* Label edit */
  public void insertLabel(JLabel label, String text){
    label.setText(text);
  }
}
