package com.code.mainMenu.gui;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.code.addCustomPolicy.gui.AddCustomPolicyFrame;
import com.code.addPolicy.gui.AddPolicyFrame;
import com.code.addUser.gui.AddUserFrame;
import com.code.deletePolicy.gui.DeletePolicyFrame;
import com.code.utility.Helper;
import com.code.viewAllPolicies.gui.ViewAllPoliciesFrame;
import com.code.viewAllUsers.gui.ViewAllUsersFrame;

public class MainMenuFrame extends JFrame implements ActionListener {
	
	Container container = getContentPane();
	JMenuBar menuBar = new JMenuBar();  
	JMenu userMgmtMenu = new JMenu("User Mgmt");
	JMenu policyMgmtMenu = new JMenu("Policy Mgmt");
	JMenuItem addUser = new JMenuItem("Add user");
	JMenuItem editUser = new JMenuItem("Edit user");
	JMenuItem deleteUser = new JMenuItem("Delete user");
	JMenuItem viewAllUser = new JMenuItem("View all users");
	JMenuItem addPolicy = new JMenuItem("Add policy");
	JMenuItem addCustomPolicy = new JMenuItem("Add custom policy");
	JMenuItem deletePolicy = new JMenuItem("Delete policy");
	JMenuItem viewAllPolicy = new JMenuItem("View all policies");
	
	public MainMenuFrame() {
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
		userMgmtMenu.add(addUser);
		userMgmtMenu.add(editUser);
		userMgmtMenu.add(deleteUser);
		userMgmtMenu.add(viewAllUser);
		policyMgmtMenu.add(addPolicy);
		policyMgmtMenu.add(addCustomPolicy);
		policyMgmtMenu.add(deletePolicy);
		policyMgmtMenu.add(viewAllPolicy);
		menuBar.add(userMgmtMenu);
		menuBar.add(policyMgmtMenu);
		this.setJMenuBar(menuBar);
	}

	public void addActionEvents() {
		addUser.addActionListener(this);
		editUser.addActionListener(this);
		deleteUser.addActionListener(this);
		viewAllUser.addActionListener(this);
		addPolicy.addActionListener(this);
		addCustomPolicy.addActionListener(this);
		deletePolicy.addActionListener(this);
		viewAllPolicy.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addUser) {
			AddUserFrame frame = new AddUserFrame();
		} else if(e.getSource() == editUser) {
			
		} else if(e.getSource() == deleteUser) {
			
		} else if(e.getSource() == viewAllUser) {
			ViewAllUsersFrame frame = new ViewAllUsersFrame();
		} else if(e.getSource() == addPolicy) {
			AddPolicyFrame frame = new AddPolicyFrame();
		} else if(e.getSource() == addCustomPolicy) {
			AddCustomPolicyFrame frame = new AddCustomPolicyFrame();
		} else if(e.getSource() == deletePolicy) {
			DeletePolicyFrame dpFrame = new DeletePolicyFrame();
		} else if(e.getSource() == viewAllPolicy) {
			ViewAllPoliciesFrame frame = new ViewAllPoliciesFrame();
		}
		
	}

	public static void main(String[] args) {
		MainMenuFrame mm = new MainMenuFrame();
	}
}
