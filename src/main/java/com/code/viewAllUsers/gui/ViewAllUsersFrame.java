package com.code.viewAllUsers.gui;

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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.code.userobjects.UserDoctor;
import com.code.userobjects.UserPatient;
import com.code.utility.DatabaseFetch;
import com.code.utility.Helper;
import com.code.viewAllUsers.backend.DoctorTableModel;
import com.code.viewAllUsers.backend.PatientTableModel;
import com.code.viewAllUsers.backend.ViewAllUsers;

public class ViewAllUsersFrame extends JFrame implements ActionListener {
	String userTypeString[] = { "Doctor", "Patient" };
	ViewAllUsers viewAll = new ViewAllUsers();
	DoctorTableModel dtm = new DoctorTableModel(viewAll.doctorList);
	PatientTableModel ptm = new PatientTableModel(viewAll.patientList);
	Container container = getContentPane();
	JComboBox userTypeDropDown = new JComboBox(userTypeString);
	JTable table = new JTable();
	
	
	public ViewAllUsersFrame() {
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
		userTypeDropDown.addActionListener(this);
	}

	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 0, 5, 0);
		Helper.addCompenenttoGrid(p, userTypeDropDown, 0, 0, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, setupTable(), 0, 1, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public JScrollPane setupTable() {
		viewAll.fetchAllDoctors();
		viewAll.fetchAllPatients();
        table.setModel(dtm);
        return new JScrollPane(table);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==userTypeDropDown) {
			if(userTypeDropDown.getSelectedIndex() == 0) {
				table.setModel(dtm);
			} else {
				table.setModel(ptm);
			}
		}
	}
	
	public static void main(String[] a) {
		ViewAllUsersFrame viewAllUsers = new ViewAllUsersFrame();
	}

}
