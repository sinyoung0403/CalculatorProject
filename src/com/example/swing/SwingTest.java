package com.example.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SwingTest extends JFrame {
  public SwingTest() {
    // 프레임 설정
    setTitle("계산기");
    setSize(310, 540);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);

    // 패널 만들기
    JPanel panel = new JPanel();
    panel.setBounds(10, 10, 270, 100); // panel 위치와 크기 설정
    add(panel); // panel을 프레임에 추가

    JLabel label = new JLabel("초기 텍스트");
    panel.add(label); // panel에 라벨 추가

    // 버튼 배열
    String[] buttonLabels = {
            "➕", "➖", "✖", "➗",
            "7", "8", "9", "CE",
            "4", "5", "6", "C",
            "1", "2", "3", "◀",
            "X²", "0", ".", "="
    };

    int xPos = 10;
    int yPos = 150;
    for (int i = 0; i < buttonLabels.length; i++) {
      JButton button = new JButton(buttonLabels[i]);
      button.setBounds(xPos, yPos, 60, 60);
      add(button);

      xPos += 70; // 버튼 간격 조정
      if ((i + 1) % 4 == 0) { // 4개의 버튼마다 줄 바꿈
        xPos = 10;
        yPos += 70;
      }
    }

    setVisible(true); //화면에 프레임 출력
  }

  public static void main(String[] args) {
    new SwingUI(); // SwingUI 인스턴스를 생성하면서 화면 표시
  }
}
