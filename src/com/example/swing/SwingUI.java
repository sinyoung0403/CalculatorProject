package com.example.swing;
import javax.swing.*;

public class SwingUI extends JFrame {
  public SwingUI(){
    // 프레임 생성
    JFrame frame = new JFrame("계산기");

    // 프레임 설정
    frame.setSize(310, 540);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    // 패널 만들기 > 패널이 있으니까 바로 생기네.
    JPanel panel = new JPanel();
    frame.add(panel);

    JLabel label = new JLabel("입력해주세요.");
    label.setBounds(10,0,300,150);
    frame.add(label);

    JButton sumBtn = new JButton("➕");
    sumBtn.setBounds(10, 150, 60, 60);
    frame.add(sumBtn);

    JButton subtractBtn = new JButton("➖");
    subtractBtn.setBounds(80, 150, 60, 60);
    frame.add(subtractBtn);

    JButton multiplyBtn = new JButton("✖");
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

    JButton expBtn = new JButton("X²");
    expBtn.setBounds(10, 430, 60, 60);
    frame.add(expBtn);

    JButton btn0 = new JButton("0");
    btn0.setBounds(80, 430, 60, 60);
    frame.add(btn0);

    JButton pointBtn = new JButton(".");
    pointBtn.setBounds(150, 430, 60, 60);
    frame.add(pointBtn);

    JButton equalBtn = new JButton("=");
    equalBtn.setBounds(220, 430, 60, 60);
    frame.add(equalBtn);


    frame.setLayout(null);
    frame.setVisible(true); //화면에 프레임 출력
  }

  public static void main(String[] args) {
    SwingUI swing = new SwingUI();
  }
}
