package com.example.swing.swingui;

import javax.swing.*;

public class SwingOutput extends JFrame {
  // 오류 발생 시 출력문
  public static void showErrorDialog(String text){
    JOptionPane.showMessageDialog(SwingUI.frame,text);
    System.out.println("오류발생: " + text);
  }

  // 기본 Swing 출력문
  public static void showDialog(String text){
    JOptionPane.showMessageDialog(SwingUI.frame,text);
    System.out.println("안내문: " + text);
  }

}
