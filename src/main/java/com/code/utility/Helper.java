package com.code.utility;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class Helper {
	public static void addCompenenttoGrid(JPanel panel, Component comp, int x, int y, int height, int width, 
			double weightx, double weighty, Insets inset, int align) {
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.gridx = x;
		constraint.gridy = y;
		constraint.gridheight = height;
		constraint.gridwidth = width;
		constraint.weightx = weightx;
		constraint.weighty = weighty;
		constraint.insets = inset;
		constraint.fill = align;
		panel.add(comp, constraint);
	}
}
