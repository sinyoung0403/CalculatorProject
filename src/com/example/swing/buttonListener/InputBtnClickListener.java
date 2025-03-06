package com.example.swing.buttonListener;

import com.example.swing.logic.CalculatorState;
import com.example.swing.swingui.SwingOutput;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputBtnClickListener implements ActionListener {
  // 속성 정의
  private JFrame frame;
  private JLabel label;

  public InputBtnClickListener(JFrame frame, JLabel label) {
    this.frame = frame;
    this.label = label;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    CalculatorState calculatorState = new CalculatorState();
    // 버튼일 경우만 처리
    if (e.getSource() instanceof JButton) {
      // e 이벤트를 Jbtton 으로 캐스팅
      JButton sourceButton = (JButton) e.getSource();
      String buttonText = sourceButton.getText();
      if(buttonText.equals("1")){
        calculatorState.addInputNumber("1");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("2")){
        calculatorState.addInputNumber("2");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("3")){
        calculatorState.addInputNumber("3");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("4")){
        calculatorState.addInputNumber("4");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("5")){
        calculatorState.addInputNumber("5");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("6")){
        calculatorState.addInputNumber("6");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("7")){
        calculatorState.addInputNumber("7");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("8")){
        calculatorState.addInputNumber("8");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("9")){
        calculatorState.addInputNumber("9");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals("0")){
        calculatorState.addInputNumber("0");
        String text=calculatorState.getInputString();
        calculatorState.insertLabel(label,text);
      } else if(buttonText.equals(".")){
        String text=calculatorState.getInputString();
        if (text.contains(".")){
          SwingOutput.showErrorDialog("소수점은 한번만 입력 가능합니다.");
        }
        else{
          calculatorState.addInputNumber(".");
          text=calculatorState.getInputString();
          calculatorState.insertLabel(label,text);
        }

      }
    }
  }
}
