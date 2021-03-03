package com.code.login.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
		container.add(makeTitledPanel());
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	public void addCompenenttoGrid(JPanel panel, Component comp, int x, int y, int height, int width, 
			double weightx, double weighty, Insets inset, int align) {
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridheight = height;
		constraint.gridwidth = width;
		constraint.weightx = weightx;
		constraint.weighty = weighty;
		constraint.insets = inset;
		constraint.fill = align;
		panel.add(comp, constraint);
	}

	public Component makeTitledPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		addCompenenttoGrid(p, titleLabel, 0, 0, 1, 2, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.CENTER);
		addCompenenttoGrid(p, userLabel, 0, 1, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
		addCompenenttoGrid(p, userTextField, 1, 1, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
		addCompenenttoGrid(p, passwordLabel, 0, 2, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
		addCompenenttoGrid(p, passwordField, 1, 2, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
		addCompenenttoGrid(p, showPassword, 0, 3, 1, 2, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.CENTER);
		addCompenenttoGrid(p, loginButton, 0, 4, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
		addCompenenttoGrid(p, resetButton, 1, 4, 1, 1, 1, 0, new Insets(10, 10, 0, 10), GridBagConstraints.HORIZONTAL);
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
