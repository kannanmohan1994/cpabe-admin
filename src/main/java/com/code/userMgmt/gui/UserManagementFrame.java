package com.code.userMgmt.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.code.utility.Helper;

public class UserManagementFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton viewAllUsersBtn = new JButton("View All users");
	JButton addUserBtn = new JButton("Add user");
	JButton editUserBtn = new JButton("Edit user");
	JButton deleteUserBtn = new JButton("Delete user");
	
	public UserManagementFrame() {
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
		viewAllUsersBtn.addActionListener(this);
		addUserBtn.addActionListener(this);
		editUserBtn.addActionListener(this);
		deleteUserBtn.addActionListener(this);
	}
	
	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 0, 5, 0); 
		Helper.addCompenenttoGrid(p, viewAllUsersBtn, 0, 0, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, addUserBtn, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, editUserBtn, 0, 2, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, deleteUserBtn, 0, 3, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
