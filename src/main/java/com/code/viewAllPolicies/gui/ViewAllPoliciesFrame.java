package com.code.viewAllPolicies.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.code.utility.Helper;
import com.code.viewAllPolicies.backend.ViewAllPolicies;

public class ViewAllPoliciesFrame extends JFrame implements ActionListener {
	
	String userTypeString[] = { "Doctor", "Patient" };
	ViewAllPolicies viewAll = new ViewAllPolicies();
	PolicyTableModel ptm = new PolicyTableModel(viewAll.policy, viewAll.id);
	Container container = getContentPane();
	JTable table = new JTable();
	
	
	public ViewAllPoliciesFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}

	public void initialSetup() {
		setTitle("Policy List");
		setVisible(true);
		setSize(new Dimension(320, 240));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		container.setLayout(new BorderLayout());
	}

	public void addComponentsToContainer() {
		container.add(setupTable());
		this.pack();
		setLocationRelativeTo(null);
	}

	public void addActionEvents() {
		
	}
	
	public JScrollPane setupTable() {
		viewAll.fetchAllPolicies();
        table.setModel(ptm);
        table.getColumnModel().getColumn(0).setMaxWidth(27);;
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        return new JScrollPane(table);
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String args[]) {
		new ViewAllPoliciesFrame();
	}

}
