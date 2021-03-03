package com.code.login.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.code.utility.Helper;

public class LoginFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JLabel titleLabel = new JLabel("ADMIN LOGIN");
	JLabel userLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JCheckBox showPassword = new JCheckBox("Show Password");

	LoginFrame() {
		setLayoutManager();
		addComponentsToContainer();
		addActionEvent();
	}

	public void setLayoutManager() {
		container.setLayout(new BorderLayout());
	}

	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
	
	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(10, 10, 0, 10); 
		Helper.addCompenenttoGrid(p, titleLabel, 0, 0, 1, 2, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, userLabel, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, userTextField, 1, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, passwordLabel, 0, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, passwordField, 1, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, showPassword, 0, 3, 1, 2, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, loginButton, 0, 4, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, resetButton, 1, 4, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		} else if (e.getSource() == loginButton) {

		} else {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
	}
}
