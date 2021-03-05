package com.code.intro.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.code.addUser.gui.AddUserFrame;
import com.code.userMgmt.gui.UserManagementFrame;
import com.code.utility.Helper;

public class IntroFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton userMgmtBtn = new JButton("User Management Portal");
	JButton policyMgmtBtn = new JButton("Policy Management Portal");

	public IntroFrame() {
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
		userMgmtBtn.addActionListener(this);
		policyMgmtBtn.addActionListener(this);
	}

	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 0, 5, 0);
		Helper.addCompenenttoGrid(p, userMgmtBtn, 0, 0, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, policyMgmtBtn, 0, 1, 1, 1, 1, 0, inset, GridBagConstraints.CENTER);
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == userMgmtBtn) {
			UserManagementFrame userMgmtFrame = new UserManagementFrame();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public static void main(String[] a) {
		IntroFrame introFrame = new IntroFrame();
	}

}
