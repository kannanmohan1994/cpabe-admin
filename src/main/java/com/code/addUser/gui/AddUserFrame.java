package com.code.addUser.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

import com.code.addUser.backend.AddUser;
import com.code.intro.gui.IntroFrame;
import com.code.login.backend.Login;
import com.code.login.gui.LoginFrame;
import com.code.userobjects.UserDoctor;
import com.code.userobjects.UserPatient;
import com.code.utility.DatabaseFetch;
import com.code.utility.Helper;

public class AddUserFrame extends JFrame implements ActionListener {
	String userTypeString[] = { "Doctor", "Patient" };
	Vector<String> specialTypeString = new Vector<String>();
	Vector<String> wardTypeString = new Vector<String>();
	Boolean isTypeDoctor = true;
	Container container = getContentPane();
	JLabel emailLabel = new JLabel("Email id: ");
	JLabel userTypeLabel = new JLabel("User Type: ");
	JLabel nameLabel = new JLabel("Name: ");
	JLabel specialLabel = new JLabel("Speciality: ");
	JLabel wardLabel = new JLabel("Ward No: ");
	JLabel passwordLabel = new JLabel("Password: ");
	JTextField emailTextField = new JTextField();
	JTextField nameTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JComboBox userTypeDropDown = new JComboBox(userTypeString);
	JComboBox specialDropDown;
	JComboBox wardDropDown;
	JCheckBox showPassword = new JCheckBox("Show Password");
	JButton confirmBtn = new JButton("Confirm");

	public AddUserFrame() {
		setupComboBox();
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}

	public void initialSetup() {
		setTitle("Add user");
		setVisible(true);
		setSize(new Dimension(320, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		container.setLayout(new BorderLayout());
	}

	public void setupComboBox() {
		specialTypeString = DatabaseFetch.fetchSpecialDetails();
		specialDropDown = new JComboBox(specialTypeString);
		wardTypeString = DatabaseFetch.fetchWardDetails(String.valueOf(specialDropDown.getSelectedItem()));
		wardDropDown = new JComboBox(wardTypeString);
	}

	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvents() {
		specialDropDown.addActionListener(this);
		showPassword.addActionListener(this);
		confirmBtn.addActionListener(this);
	}

	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(10, 10, 10, 10);
		
		Helper.addCompenenttoGrid(p, userTypeLabel, 0, 0, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, userTypeDropDown, 1, 0, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, nameLabel, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, nameTextField, 1, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, specialLabel, 0, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, specialDropDown, 1, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, wardLabel, 0, 3, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, wardDropDown, 1, 3, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, emailLabel, 0, 4, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, emailTextField, 1, 4, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, passwordLabel, 0, 5, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, passwordField, 1, 5, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, showPassword, 0, 6, 1, 2, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, confirmBtn, 0, 7, 1, 2, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == specialDropDown) {
			wardTypeString = DatabaseFetch.fetchWardDetails(String.valueOf(specialDropDown.getSelectedItem()));
			Helper.addFreshItemsComboBox(wardDropDown, wardTypeString);
		} else if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		} else if(e.getSource() == confirmBtn) {
			attemptAddUser();
		}
	}

	// UI and Backend interface
	public void attemptAddUser() {
		String email = emailTextField.getText().trim();
		String userName = nameTextField.getText().trim();
		String special = specialTypeString.get(specialDropDown.getSelectedIndex());
		String ward = wardTypeString.get(wardDropDown.getSelectedIndex());
		String password = passwordField.getText().trim();
		if (!userName.isEmpty() && !password.isEmpty()) {
			if(userTypeDropDown.getSelectedIndex() == 0) {
				UserDoctor uDoc = new UserDoctor(email, userName, special, ward, password);
				if(AddUser.addDoctor(uDoc)) {
					this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					Helper.showWarningBox(this, "Doctor added successfully", JOptionPane.PLAIN_MESSAGE);
				} else {
					Helper.showWarningBox(this, "Adding user failed!", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				UserPatient uPat = new UserPatient(email, userName, special, ward, password);
				if(AddUser.addPatient(uPat)) {
					this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					Helper.showWarningBox(this, "Patient added successfully", JOptionPane.PLAIN_MESSAGE);
				} else {
					Helper.showWarningBox(this, "Adding user failed!", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			Helper.showWarningBox(this, "Fill out all fields", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] a) {
		AddUserFrame adduser = new AddUserFrame();
	}

}