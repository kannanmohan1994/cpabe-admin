package com.code.addCustomPolicy.backend;

import java.sql.Connection;
import java.sql.Statement;

import com.code.utility.Connect;

public class AddCustomPolicy {
	public String reqAttr;
	public String resAttr;
	public String actionAttr;
	
	public AddCustomPolicy(String reqAttr, String resAttr, String actionAttr) {
		this.reqAttr = reqAttr;
		this.resAttr = resAttr;
		this.actionAttr = actionAttr;
	}
	
	public String generatepolicy() {
		int attrCount = (reqAttr.split(" ")).length + resAttr.split(" ").length + actionAttr.split(" ").length;
		String policy = reqAttr + " " + resAttr + " " + actionAttr + " " + attrCount + "of" + attrCount;
		return insertPolicytoDatabase(policy);
	}
	
	public String insertPolicytoDatabase(String policy) {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT into POLICYSET (policy) VALUES ('"+policy+"');";
			if((stmt.executeUpdate(query))>0){
				return "Policy addition Successfull!";
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return "Couldn't add policy because of DB server issue or the policy already exists ";
	}
}
