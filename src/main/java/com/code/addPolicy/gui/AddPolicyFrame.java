package com.code.addPolicy.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import com.code.addPolicy.backend.AddPolicy;
import com.code.utility.DatabaseFetch;
import com.code.utility.Helper;

public class AddPolicyFrame extends JFrame implements ActionListener{
	Container container = getContentPane();
	JButton doctoridBtn = new JButton("Select doctor id options");
	JButton doctorSpecialBtn = new JButton("Select doctor special options");
	JButton doctorWardBtn = new JButton("Select doctor ward options");
	JButton patientidBtn = new JButton("Select PHR id options");
	JButton patientSpecialBtn = new JButton("Select PHR speciality options");
	JButton patientWardBtn = new JButton("Select PHR ward options");
	JButton confirmBtn = new JButton("Generate Policy");
	ButtonGroup accessPermit = new ButtonGroup();
	JRadioButton viewPermitRadioBtn = new JRadioButton("View access");
	JRadioButton editPermitRadioBtn = new JRadioButton("Edit access");
	AddPolicy addPolicy = new AddPolicy();
	
	public AddPolicyFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
		addPolicy.populateValues();
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
		setupComponentProperties();
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(0, 0, 0, 0);
		Helper.addCompenenttoGrid(p, doctoridBtn, 0, 1, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, doctorSpecialBtn, 0, 2, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, doctorWardBtn, 0, 3, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientidBtn, 0, 4, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientSpecialBtn, 0, 5, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, patientWardBtn, 0, 6, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, viewPermitRadioBtn, 0, 7, 1, 1, 1, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, editPermitRadioBtn, 1, 7, 1, 1, 1, 1, inset, GridBagConstraints.CENTER);
		Helper.addCompenenttoGrid(p, confirmBtn, 0, 8, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public void setupComponentProperties() {
		viewPermitRadioBtn.setSelected(true);
		editPermitRadioBtn.setSelected(false);
		accessPermit.add(viewPermitRadioBtn);
		accessPermit.add(editPermitRadioBtn);
		doctoridBtn.putClientProperty("tag", 0);
		doctorSpecialBtn.putClientProperty("tag", 1);
		doctorWardBtn.putClientProperty("tag", 2);
		patientidBtn.putClientProperty("tag", 3);
		patientSpecialBtn.putClientProperty("tag", 4);
		patientWardBtn.putClientProperty("tag", 5);
		confirmBtn.putClientProperty("tag", 6);
		Color bgc = confirmBtn.getBackground();
		confirmBtn.setBackground(Color.DARK_GRAY);
		confirmBtn.setForeground(bgc);
	}
	
	public static void main(String[] args) {
		AddPolicyFrame adp = new AddPolicyFrame();
	}

	public void actionPerformed(ActionEvent e) {
		int tag = (Integer)((JButton)e.getSource()).getClientProperty("tag");
		if(tag <= 5) {
			AddPolicySelectorFrame frame = new AddPolicySelectorFrame(addPolicy.vectItemList.get(tag), 
					addPolicy.vectCheckList.get(tag));
		} else {
			if(editPermitRadioBtn.isSelected()) {
				addPolicy.actionAttributes = "a:edit";
			} else {
				addPolicy.actionAttributes = "a:view";
			}
			String policy = addPolicy.generatePolicy();
			Helper.showWarningBox(this, policy, JOptionPane.INFORMATION_MESSAGE);
		}
	} 

}
