package com.code.deletePolicy.backend;

import java.sql.Connection;
import java.sql.Statement;

import com.code.utility.Connect;

public class DeletePolicy {
	public int policyId;
	public Boolean deletePolicywithId() {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "Delete from policyset where id ='"+policyId+"';";
			return (stmt.executeUpdate(query))>0;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return false;
	}
}
