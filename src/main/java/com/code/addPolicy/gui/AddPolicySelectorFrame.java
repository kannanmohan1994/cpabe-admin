package com.code.addPolicy.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.code.utility.Helper;
import com.code.viewAllUsers.backend.ViewAllUsers;
import com.code.viewAllUsers.gui.DoctorTableModel;
import com.code.viewAllUsers.gui.PatientTableModel;

public class AddPolicySelectorFrame  extends JFrame implements ActionListener {
	Vector<String> userid;
	Vector<Boolean> checkList;
	ViewAllUsers viewAll = new ViewAllUsers();
	AddPolicySelectorTableModel model;
	Container container = getContentPane();
	JTable table = new JTable();
	
	public AddPolicySelectorFrame(Vector<String> uid, Vector<Boolean> checkList) {
		this.userid = uid;
		this.checkList = checkList;
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
		this.pack();
		setLocationRelativeTo(null);
	}

	public void addActionEvents() {
		
	}

	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 0, 5, 0);
		Helper.addCompenenttoGrid(p, setupTable(), 0, 1, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public JScrollPane setupTable() {
		viewAll.fetchAllDoctors();
		viewAll.fetchAllPatients();
        table.setModel(new AddPolicySelectorTableModel(userid, checkList));
        return new JScrollPane(table);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		Vector<String> uid = new Vector<String>();
		uid.add("abc");
		uid.add("def");
		Vector<Boolean> checkL = new Vector<Boolean>();
		checkL.add(false);
		checkL.add(true);
		AddPolicySelectorFrame frame = new AddPolicySelectorFrame(uid, checkL);

	}

}
