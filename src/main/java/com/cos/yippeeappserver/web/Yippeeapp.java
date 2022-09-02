package com.cos.yippeeappserver.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;


public class Yippeeapp extends JFrame {

    public static JLabel jLabel;
    public static JLabel jLabel2;
    public static JLabel jLabel3;
    public static JTextField jf;
    public static JTextField jf2;
    public static JTextField jf3;

    public static JButton btn;

    public void TextFieldEx() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        jLabel = new JLabel("폰 번호");
        jf = new JTextField(20);
        jLabel2 = new JLabel("이름");
        jf2 = new JTextField(20);
        jLabel3 = new JLabel("쿠폰");
        jf3 = new JTextField(20);
        btn = new JButton();

        btn.setText("적립");
        btn.setSize(100, 50);

        c.setLayout(new FlowLayout());
        c.add(jLabel);
        c.add(jf);
        c.add(jLabel2);
        c.add(jf2);
        c.add(jLabel3);
        c.add(jf3);
        c.add(btn);
        setSize(300, 150);
        setVisible(true);
    }
}
