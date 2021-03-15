package com.code.login.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.code.login.backend.Login;
import com.code.mainMenu.gui.MainMenuFrame;
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

	public LoginFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}

	public void initialSetup() {
		setTitle("Admin App");
        setVisible(true);
        setSize(new Dimension(320, 240));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
		container.setLayout(new BorderLayout());
	}

	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvents() {
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
			attemptLogin();
		} else {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
	}
	
	//UI and Backend interface
	public void attemptLogin() {
		String userName = userTextField.getText().trim();
		String password = passwordField.getText().trim();
		if(!userName.isEmpty() && !password.isEmpty()) {
			Login login = new Login(userName, password);
			if(login.checkLoginDetailsCorrect()) {
				MainMenuFrame frame = new MainMenuFrame();
				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			} else {
				Helper.showWarningBox(this, "Wrong credentials", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			Helper.showWarningBox(this, "Empty username or password", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] a){
        LoginFrame frame=new LoginFrame();
    }
}
