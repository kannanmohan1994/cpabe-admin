package com.code.addCustomPolicy.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.code.addCustomPolicy.backend.AddCustomPolicy;
import com.code.login.backend.Login;
import com.code.mainMenu.gui.MainMenuFrame;
import com.code.utility.Helper;

public class AddCustomPolicyFrame extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	JLabel reqAttrLbl = new JLabel("Requestor attributes: ");
	JLabel resAttrLbl = new JLabel("Resource attributes: ");
	JLabel actionAttrLbl = new JLabel("Action attribute: ");
	JTextField reqAttrTxtField = new JTextField();
	JTextField resAttrTxtField = new JTextField();
	JTextField actionAttrTxtField = new JTextField();
	JButton confirmButton = new JButton("Add policy");

	public AddCustomPolicyFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}

	public void initialSetup() {
		setTitle("Admin App");
        setVisible(true);
        setSize(new Dimension(320, 200));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
		container.setLayout(new BorderLayout());
	}

	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvents() {
		confirmButton.addActionListener(this);
	}
	
	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(10, 10, 0, 10); 
		Helper.addCompenenttoGrid(p, reqAttrLbl, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, reqAttrTxtField, 1, 1, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, resAttrLbl, 0, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, resAttrTxtField, 1, 2, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, actionAttrLbl, 0, 3, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, actionAttrTxtField, 1, 3, 1, 1, 1, 0, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, confirmButton, 0, 4, 1, 2, 1, 0, inset, GridBagConstraints.CENTER);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirmButton) {
			attemptAddPolicy();
		} 
	}
	
	//UI and Backend interface
	public void attemptAddPolicy() {
		String reqAttr = reqAttrTxtField.getText().trim();
		String resAttr = resAttrTxtField.getText().trim();
		String actionAttr = actionAttrTxtField.getText().trim();
		if(!reqAttr.isEmpty() && !resAttr.isEmpty() && !actionAttr.isEmpty()) {
			AddCustomPolicy apFrame = new AddCustomPolicy(reqAttr, resAttr, actionAttr);
			Helper.showWarningBox(this, apFrame.generatepolicy(), JOptionPane.INFORMATION_MESSAGE);
		} else {
			Helper.showWarningBox(this, "Empty requestor/resource/action attribute", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new AddCustomPolicyFrame();
	}
}
