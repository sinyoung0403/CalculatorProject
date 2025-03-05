package com.example.swing.swingui;
import com.example.swing.buttonListener.ButtonFunctionListener;
import com.example.swing.logic.CalculatorState;
import com.example.swing.buttonListener.InputBtnClickListener;
import com.example.swing.buttonListener.SymbolBtnClickListener;

import javax.swing.*;
import java.awt.*;


public class SwingUI extends JFrame {
  public static JFrame frame;
  public static JLabel stateLabel;
  public static JLabel myList;

  public SwingUI(){
    CalculatorState calculatorState = new CalculatorState();

    // 프레임 생성
    frame = new JFrame("계산기");

    // 프레임 설정
    frame.setSize(460, 540);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    // 패널 만들기
    JPanel panel = new JPanel();
    frame.add(panel);

    // 라벨 선언
    stateLabel = new JLabel("계산과정");
    stateLabel.setBounds(10,0,300,50);
    frame.add(stateLabel);

    JLabel presentLabel = new JLabel("계산을 입력해주세요.");
    presentLabel.setBounds(10,60,300,60);
    frame.add(presentLabel);

    // 저장된 List 선언
    JLabel myListLabel= new JLabel("저장된 값");
    myListLabel.setBounds(310,0,80,30);
    frame.add(myListLabel);

    // 값을 표시하기
    myList= new JLabel("");
    myList.setBounds(300,10,120,450);
    frame.add(myList);

    JButton delBtn = new JButton("Del");
    delBtn.setBounds(370, 430, 60, 60);
    frame.add(delBtn);

    JButton viewBtn = new JButton("Big");
    viewBtn.setBounds(300, 430, 60, 60);
    frame.add(viewBtn);

    // 주의 해야할 부분 ! 실제 DataState 에는 +-*/ 로 값을 넣어 뒀다는 것 !!!
    JButton sumBtn = new JButton("➕");
    sumBtn.setBounds(10, 150, 60, 60);
    frame.add(sumBtn);

    JButton subtractBtn = new JButton("➖");
    subtractBtn.setBounds(80, 150, 60, 60);
    frame.add(subtractBtn);

    JButton multiplyBtn = new JButton("*");
    multiplyBtn.setBounds(150, 150, 60, 60);
    frame.add(multiplyBtn);

    JButton divideBtn = new JButton("➗");
    divideBtn.setBounds(220, 150, 60, 60);
    frame.add(divideBtn);

    JButton btn7 = new JButton("7");
    btn7.setBounds(10, 220, 60, 60);
    frame.add(btn7);

    JButton btn8 = new JButton("8");
    btn8.setBounds(80, 220, 60, 60);
    frame.add(btn8);

    JButton btn9 = new JButton("9");
    btn9.setBounds(150, 220, 60, 60);
    frame.add(btn9);

    JButton ceBtn = new JButton("CE");
    ceBtn.setBounds(220, 220, 60, 60);
    frame.add(ceBtn);

    JButton btn4 = new JButton("4");
    btn4.setBounds(10, 290, 60, 60);
    frame.add(btn4);

    JButton btn5 = new JButton("5");
    btn5.setBounds(80, 290, 60, 60);
    frame.add(btn5);

    JButton btn6 = new JButton("6");
    btn6.setBounds(150, 290, 60, 60);
    frame.add(btn6);

    JButton cBtn = new JButton("C");
    cBtn.setBounds(220, 290, 60, 60);
    frame.add(cBtn);

    JButton btn1 = new JButton("1");
    btn1.setBounds(10, 360, 60, 60);
    frame.add(btn1);


    JButton btn2 = new JButton("2");
    btn2.setBounds(80, 360, 60, 60);
    frame.add(btn2);

    JButton btn3 = new JButton("3");
    btn3.setBounds(150, 360, 60, 60);
    frame.add(btn3);

    JButton backBtn = new JButton("◀");
    backBtn.setBounds(220, 360, 60, 60);
    frame.add(backBtn);

    JButton negativeBtn = new JButton("Negative");
    negativeBtn.setMargin(new Insets(0, 0, 0, 0));
    negativeBtn.setFont(negativeBtn.getFont().deriveFont(10.0f));
    negativeBtn.setBounds(10, 430, 60, 60);
    frame.add(negativeBtn);

    JButton btn0 = new JButton("0");
    btn0.setBounds(80, 430, 60, 60);
    frame.add(btn0);

    JButton pointBtn = new JButton(".");
    pointBtn.setBounds(150, 430, 60, 60);
    frame.add(pointBtn);

    JButton equalBtn = new JButton("=");
    equalBtn.setBounds(220, 430, 60, 60);
    frame.add(equalBtn);

    // 숫자 버튼에 Click Listener 적용
    InputBtnClickListener inputBtnClickListener = new InputBtnClickListener(frame,presentLabel);
    btn1.addActionListener(inputBtnClickListener);
    btn2.addActionListener(inputBtnClickListener);
    btn3.addActionListener(inputBtnClickListener);
    btn4.addActionListener(inputBtnClickListener);
    btn5.addActionListener(inputBtnClickListener);
    btn6.addActionListener(inputBtnClickListener);
    btn7.addActionListener(inputBtnClickListener);
    btn8.addActionListener(inputBtnClickListener);
    btn9.addActionListener(inputBtnClickListener);
    btn0.addActionListener(inputBtnClickListener);
    pointBtn.addActionListener(inputBtnClickListener);

    // 연산 버튼에 Click Listener 적용
    SymbolBtnClickListener symbolBtnClickListener = new SymbolBtnClickListener(stateLabel, presentLabel, calculatorState);
    equalBtn.addActionListener(symbolBtnClickListener);
    sumBtn.addActionListener(symbolBtnClickListener);
    subtractBtn.addActionListener(symbolBtnClickListener);
    multiplyBtn.addActionListener(symbolBtnClickListener);
    divideBtn.addActionListener(symbolBtnClickListener);

    // 값을 지우는 버튼들은 deleteBtnClickListener 적용
    ButtonFunctionListener deleteBtnClickListener = new ButtonFunctionListener(stateLabel,presentLabel);
    backBtn.addActionListener(deleteBtnClickListener);
    ceBtn.addActionListener(deleteBtnClickListener);
    cBtn.addActionListener(deleteBtnClickListener);
    viewBtn.addActionListener(deleteBtnClickListener);
    delBtn.addActionListener(deleteBtnClickListener);
    negativeBtn.addActionListener(deleteBtnClickListener);

    frame.setLayout(null);
    frame.setVisible(true); //화면에 프레임 출력
  }
}
