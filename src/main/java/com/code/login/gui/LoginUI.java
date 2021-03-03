package com.code.login.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginUI {
    public static void main(String[] a){
        LoginFrame frame=new LoginFrame();
        frame.setTitle("Admin App");
        frame.setVisible(true);
        frame.setBounds(new Rectangle(10,10,320,240));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
 
}