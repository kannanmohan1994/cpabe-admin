package com.code.addPolicy.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import com.code.utility.DatabaseFetch;
import com.code.utility.Helper;

public class AddPolicyFrame extends JFrame implements ActionListener{
	Container container = getContentPane();
	JButton doctoridBtn = new JButton("Select doctor id options");
	JButton doctorSpecialBtn = new JButton("Select doctor special options");
	JButton doctorWardBtn = new JButton("Select doctor ward options");
	JButton patientidBtn = new JButton("Select patient id options");
	JButton patientSpecialBtn = new JButton("Select patient special options");
	JButton patientWardBtn = new JButton("Select patient ward options");
	JButton confirmBtn = new JButton("Generate Policy");
	Vector<Vector<String>> vectItemList = new Vector<Vector<String>>();
	Vector<Vector<Boolean>> vectCheckList = new Vector<Vector<Boolean>>();;
	
	public AddPolicyFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
		populateAllCheckLists();
	}
	
	public void initialSetup() {
		setTitle("Add Policy");
		setVisible(true);
		setSize(new Dimension(320, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		container.setLayout(new BorderLayout());
	}
	
	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvents() {
		doctoridBtn.addActionListener(this);
		doctorSpecialBtn.addActionListener(this);
		doctorWardBtn.addActionListener(this);
		patientidBtn.addActionListener(this);
		patientSpecialBtn.addActionListener(this);
		patientWardBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
	}
	
	public Component setupPanel() {
		Color bgc = confirmBtn.getBackground();
		confirmBtn.setBackground(Color.DARK_GRAY);
		confirmBtn.setForeground(bgc);
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(0, 0, 0, 0);
		Helper.addCompenenttoGrid(p, doctoridBtn, 0, 1, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, doctorSpecialBtn, 0, 2, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, doctorWardBtn, 0, 3, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientidBtn, 0, 4, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientSpecialBtn, 0, 5, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientWardBtn, 0, 6, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, confirmBtn, 0, 7, 1, 1, 2, 1, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public void populateAllCheckLists() {
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("doctor", "emailid"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "special"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "ward"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("patient", "emailid"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "special"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "ward"));
		for(int i=0; i<vectItemList.size(); i++) {
			Vector<Boolean> temp = new Vector<Boolean>();
			for(int j=0; j<vectItemList.get(i).size(); j++) {
				temp.add(false);
			}
			vectCheckList.add(temp);
		}
	}
	
	public static void main(String[] args) {
		AddPolicyFrame adp = new AddPolicyFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == doctoridBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(0), vectCheckList.get(0));
		} else if(e.getSource() == doctorSpecialBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(1), vectCheckList.get(1));
		} else if(e.getSource() == doctorWardBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(2), vectCheckList.get(2));
		} else if(e.getSource() == patientidBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(3), vectCheckList.get(3));
		} else if(e.getSource() == patientSpecialBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(4), vectCheckList.get(4));
		} else if(e.getSource() == patientWardBtn) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(vectItemList.get(5), vectCheckList.get(5));
		} else {
			//Generate policy
		}
	} 

}
