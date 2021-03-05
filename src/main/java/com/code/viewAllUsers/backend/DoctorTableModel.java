package com.code.viewAllUsers.backend;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.code.userobjects.UserDoctor;
import com.code.utility.DatabaseFetch;

public class DoctorTableModel extends AbstractTableModel {

	public Vector<UserDoctor> users;
	public Vector<String> columnNames;

	public DoctorTableModel(Vector<UserDoctor> users) {
		this.users = users;
	}

	public int getRowCount() {
		return users.size();
	}

	public int getColumnCount() {
		columnNames = DatabaseFetch.fetchColumnNames("doctor");
		return columnNames.size();
	}
	
	public String getColumnName(int column) {
		return columnNames.get(column);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = "??";
		UserDoctor user = users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			value = user.emailId;
			break;
		case 1:
			value = user.name;
			break;
		case 2:
			value = user.special;
			break;
		case 3:
			value = user.ward;
			break;
		case 4:
			value = user.password;
			break;
		default:
			break;
		}
		return value;
	}

	public UserDoctor getUserAt(int row) {
		return users.get(row);
	}

}