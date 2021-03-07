package com.code.deletePolicy.gui;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.code.deletePolicy.backend.DeletePolicy;
import com.code.utility.Helper;

public class DeletePolicyFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	JLabel idLabel = new JLabel("Policy Id: ");
	JTextField idField = new JTextField();
	JButton confirmBtn = new JButton("Confirm");
	public DeletePolicyFrame() {
		initialSetup();
		addComponentsToContainer();
		addActionEvents();
	}
	
	public void initialSetup() {
		setTitle("Delete Policy");
		setVisible(true);
		setSize(new Dimension(250, 125));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		container.setLayout(new BorderLayout());
	}
	
	public void addComponentsToContainer() {
		container.add(setupPanel());
	}

	public void addActionEvents() {
		confirmBtn.addActionListener(this);
	}
	
	public Component setupPanel() {
		GridBagLayout grid = new GridBagLayout();
		JPanel p = new JPanel(grid);
		Insets inset = new Insets(5, 10, 5, 10); 
		Helper.addCompenenttoGrid(p, idLabel, 0, 1, 1, 1, 1, 1, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, idField, 1, 1, 1, 1, 1, 1, inset, GridBagConstraints.HORIZONTAL);
		Helper.addCompenenttoGrid(p, confirmBtn, 0, 2, 1, 2, 2, 1, inset, GridBagConstraints.CENTER);
		return p;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==confirmBtn) {
			String result = idField.getText();
			if(!result.isBlank()) {
				DeletePolicy dp = new DeletePolicy();
				try {
					dp.policyId = Integer.valueOf(result);
					if(!dp.deletePolicywithId()) {
						Helper.showWarningBox(this, "Policy id doesn't exist!", JOptionPane.ERROR_MESSAGE);
					} else {
						Helper.showWarningBox(this, "Policy with id "+result+" deleted", JOptionPane.PLAIN_MESSAGE);
						this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
					}
				}
				catch (Exception e1) {
					Helper.showWarningBox(this, "Enter valid id!", JOptionPane.PLAIN_MESSAGE);
				}
			} else {
				Helper.showWarningBox(this, "Empty username or password", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		new DeletePolicyFrame();
	}
}
