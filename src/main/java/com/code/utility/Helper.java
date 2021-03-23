package com.code.utility;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Vector;

import javax.swing.*;

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

	public static void showWarningBox(JFrame frame, String message, int messageType) {
		JOptionPane.showMessageDialog(frame, message, "Information", messageType);
	}

	public static void addFreshItemsComboBox(JComboBox jc, Vector<String> items) {
		jc.removeAllItems();
		for (int i = 0; i < items.size(); i++) {
			jc.addItem(items.get(i));
		}
	}

	/** Write the object to a Base64 string. */
	public static String objectToString(Serializable o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		oos.close();
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}

	public static void writeStringtoFile(String path, String contents) {
		try {
			FileWriter myWriter = new FileWriter(path);
			myWriter.write(contents);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
