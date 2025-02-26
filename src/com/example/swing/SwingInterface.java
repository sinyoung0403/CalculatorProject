package com.example.swing;
import javax.swing.*;
import java.awt.*;

public class SwingInterface extends JFrame {
  public SwingInterface(){
    // 프레임 생성
    JFrame frame = new JFrame("계산기");

    // 프레임 설정
    frame.setSize(600, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    // 레이아웃 설정
    frame.getContentPane().setLayout(null);


    JButton btnNewButton1 = new JButton("1");
    btnNewButton1.setBounds(0, 200, 60, 60);
    frame.getContentPane().add(btnNewButton1);
    setVisible(true); //화면에 프레임 출력

    JButton btnNewButton2 = new JButton("2");
    btnNewButton2.setBounds(200, 200, 60, 60);
    frame.getContentPane().add(btnNewButton2);

    JButton btnNewButton3 = new JButton("3");
    btnNewButton3.setBounds(400, 200, 60, 60);
    frame.getContentPane().add(btnNewButton3);

    setVisible(true); //화면에 프레임 출력

  }

  public static void main(String[] args) {
    SwingInterface mf = new SwingInterface();

  }
}
