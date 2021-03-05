package com.code.addUser.backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.code.userobjects.UserDoctor;
import com.code.userobjects.UserPatient;
import com.code.utility.Connect;

public class AddUser {
	public static Boolean addDoctor(UserDoctor uDoc) {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT into DOCTOR (emailid, name, special, ward, password) VALUES ('"+uDoc.emailId+
					"','"+uDoc.name+"','"+uDoc.special+"','"+uDoc.ward+"','"+uDoc.password+"');";
			return (stmt.executeUpdate(query))>0;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return false;
	}
	
	public static Boolean addPatient(UserPatient uPat) {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT into PATIENT (emailid, name, special, ward, password) VALUES ('"+uPat.emailId+
					"','"+uPat.name+"','"+uPat.special+"','"+uPat.ward+"','"+uPat.password+"');";
			return (stmt.executeUpdate(query))>0;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return false;
	}
}	
