package com.code.addPolicy.gui;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.code.userobjects.UserDoctor;
import com.code.utility.DatabaseFetch;

public class AddPolicySelectorTableModel extends AbstractTableModel {
	public String[] columns = { "Items", "Include" };
	public Vector<String> users;
	public Vector<Boolean> checklist;
	public Vector<String> columnNames;

	public AddPolicySelectorTableModel(Vector<String> users, Vector<Boolean> checklist) {
		this.users = users;
		this.checklist = checklist;
	}

	public int getRowCount() {
		return users.size();
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int column) {
		return columns[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = "??";
		String user = users.get(rowIndex);
		Boolean checked = checklist.get(rowIndex);
		switch (columnIndex) {
		case 0:
			value = user;
			break;
		case 1:
			value = checked;
			break;
		default:
			break;
		}
		return value;
	}

	public String getUserAt(int row) {
		return users.get(row);
	}

	public Class<?> getColumnClass(int col) {
		if (col == 1) {
			return Boolean.class;
		}
		return super.getColumnClass(col);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex == 1);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		checklist.set(rowIndex, (Boolean) aValue);
	}

}