package com.code.addPolicy.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class AddPolicyFrame extends JFrame implements ActionListener{
	Container container = getContentPane();
	
	public AddPolicyFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}
	
	public void initialSetup() {
		setTitle("Admin App");
		setVisible(true);
		setSize(new Dimension(320, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		container.setLayout(new BorderLayout());
	}
	
	public void addComponentsToContainer() {
		//container.add(setupPanel());
	}

	public void addActionEvents() {
		//specialDropDown.addActionListener(this);
		//showPassword.addActionListener(this);
		//confirmBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		AddPolicyFrame adp = new AddPolicyFrame();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
