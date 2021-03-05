package com.code.policyMgmt.gui;

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

import com.code.addPolicy.gui.AddPolicyFrame;
import com.code.addUser.gui.AddUserFrame;
import com.code.userMgmt.gui.UserManagementFrame;
import com.code.utility.Helper;
import com.code.viewAllUsers.gui.ViewAllUsersFrame;

public class PolicyManagementFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton viewAllPolicyBtn = new JButton("View all policies");
	JButton addPolicyBtn = new JButton("Add policy");
	JButton deletePolicyBtn = new JButton("Delete policy");

	public PolicyManagementFrame() {
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
		viewAllPolicyBtn.addActionListener(this);
		addPolicyBtn.addActionListener(this);
		deletePolicyBtn.addActionListener(this);
	}

	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 0, 5, 0);
		Helper.addCompenenttoGrid(p, viewAllPolicyBtn, 0, 0, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, addPolicyBtn, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, deletePolicyBtn, 0, 3, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewAllPolicyBtn) {
			//ViewAllPoliciesFrame vu = new ViewAllPoliciesFrame();
		} else if (e.getSource() == addPolicyBtn) {
			AddPolicyFrame addPolicy = new AddPolicyFrame();
		} else {
			
		}
	}

	public static void main(String[] a) {
		PolicyManagementFrame policyMgmt = new PolicyManagementFrame();
	}
}
