package com.code.login.gui;
import javax.swing.*;
import java.awt.*;

public class LoginUI {
    public static void main(String[] a){
        LoginFrame frame=new LoginFrame();
        frame.setTitle("Admin App");
        frame.setVisible(true);
        frame.setSize(new Dimension(320, 240));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
 
}