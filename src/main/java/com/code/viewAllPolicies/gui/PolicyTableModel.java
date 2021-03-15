package com.code.viewAllPolicies.gui;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.code.userobjects.UserPatient;
import com.code.utility.DatabaseFetch;

public class PolicyTableModel extends AbstractTableModel {

	public Vector<String> policy;
	public Vector<Integer> id;
	Vector<String> columnNames;

	public PolicyTableModel(Vector<String> policy, Vector<Integer> id) {
		this.policy = policy;
		this.id = id;
	}

	public int getRowCount() {
		return policy.size();
	}

	public int getColumnCount() {
		columnNames = DatabaseFetch.fetchColumnNames("policyset");
		return columnNames.size();
	}
	
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = "??";
		switch (columnIndex) {
		case 0:
			value = id.get(rowIndex);
			break;
		case 1:
			value = policy.get(rowIndex);
			break;
		default:
			break;
		}
		return value;
	}

	public String getUserAt(int row) {
		return policy.get(row);
	}

}