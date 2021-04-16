package com.code.deletePolicy.backend;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.code.cpabe_api.junwei.bswabe.Bswabe;
import com.code.cpabe_api.junwei.bswabe.BswabePolicy;
import com.code.utility.Connect;
import com.code.utility.Helper;
import com.code.utility.StaticElements;

public class DeletePolicy {
	public int policyId;
	public Boolean deletePolicywithId() {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "Delete from policyset where id ='"+policyId+"';";
			if((stmt.executeUpdate(query))>0) {
				String policySet = getPolicySet();
				BswabePolicy policyTree = Bswabe.parsePolicyPostfix(policySet);
				storePolicyTree(policyTree);
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			Connect.endConnection(conn);
		}
		return false;
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
