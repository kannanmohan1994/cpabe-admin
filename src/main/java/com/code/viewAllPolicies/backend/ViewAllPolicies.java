package com.code.viewAllPolicies.backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import com.code.userobjects.UserDoctor;
import com.code.utility.Connect;

public class ViewAllPolicies {
	public Vector<String> policy = new Vector<String>();
	public Vector<Integer> id = new Vector<Integer>();
	
	public ViewAllPolicies() {
		
	}
	
	public void fetchAllPolicies() {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM policyset;";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				id.add(rs.getInt(1));
				policy.add(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
	}
}
