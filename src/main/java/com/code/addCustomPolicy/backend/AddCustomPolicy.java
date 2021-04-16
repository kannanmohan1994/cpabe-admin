package com.code.addCustomPolicy.backend;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.code.cpabe_api.junwei.bswabe.Bswabe;
import com.code.cpabe_api.junwei.bswabe.BswabePolicy;
import com.code.utility.Connect;
import com.code.utility.Helper;
import com.code.utility.StaticElements;

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
				String policySet = getPolicySet();
				BswabePolicy policyTree = Bswabe.parsePolicyPostfix(policySet);
				storePolicyTree(policyTree);
				return "Policy addition Successfull!";
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return "Couldn't add policy because of DB server issue or the policy already exists ";
	}
	
	public String getPolicySet() {
		String policySet = "";
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM policyset;";
			ResultSet rs = stmt.executeQuery(query);
			int count = 0;
			while (rs.next()) {
				policySet += rs.getString(2) + " ";
				count++;
			}
			policySet += "1of" + count;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return policySet;
	}
	
	public void storePolicyTree(BswabePolicy bp) {
		String serialized = "";
		try {
			serialized = Helper.objectToString(bp);
			File myFile = new File(StaticElements.policytree);
			myFile.createNewFile();
			Helper.writeStringtoFile(StaticElements.policytree, serialized);
		}
		catch(Exception e) {
			System.out.println("Error occured while serialization");
		}
	}
}
