package com.example.swing;

import javax.swing.*;

public class SwingOutput extends JFrame {
  // 버튼 오류 발생
  public static void showErrorDialog(String text){
    JOptionPane.showMessageDialog(SwingUI.frame,text);
    System.out.println("오류발생: " + text);
  }

  // 초기화했을 때 이거 가져오자 !
  public static void showDialog(String text){
    JOptionPane.showMessageDialog(SwingUI.frame,text);
    System.out.println("안내문: " + text);
  }

}
