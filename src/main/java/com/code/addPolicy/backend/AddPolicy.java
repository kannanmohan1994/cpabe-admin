package com.code.addPolicy.backend;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import com.code.utility.Connect;
import com.code.utility.DatabaseFetch;

public class AddPolicy {
	public Vector<Vector<String>> vectItemList = new Vector<Vector<String>>();
	public Vector<Vector<Boolean>> vectCheckList = new Vector<Vector<Boolean>>();
	public String actionAttributes = "a:view";
	int doctorAttributeCount = 3;
	String resultantPolicy = "";
	
	public void populateValues() {
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("doctor", "emailid"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "special"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "ward"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("patient", "emailid"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "special"));
		vectItemList.add(DatabaseFetch.fetchAllValuesinColumn("category", "ward"));
		for(int i=0; i<vectItemList.size(); i++) {
			Vector<Boolean> temp = new Vector<Boolean>();
			for(int j=0; j<vectItemList.get(i).size(); j++) {
				temp.add(false);
			}
			vectCheckList.add(temp);
		}
	}
	
	public String generatePolicy() {
		resultantPolicy = "";
		int policyCount = 0;
		for(int i=0; i<doctorAttributeCount; i++) {
			String simplePolicy = "";
			int attributesCountPolicy = 0;
			for(int j=0; j<vectItemList.get(i).size(); j++) {
				if((vectCheckList.get(i)).get(j)) {
					String attribute = "d:"+(vectItemList.get(i)).get(j) + " ";
					simplePolicy += attribute;
					attributesCountPolicy++;
				}
			}
			if(!simplePolicy.isBlank()) {
				simplePolicy = simplePolicy + "1of" + String.valueOf(attributesCountPolicy);
				policyCount++;
				resultantPolicy = resultantPolicy + simplePolicy + " ";
			}
		}
		for(int i=doctorAttributeCount; i<vectItemList.size(); i++) {
			String simplePolicy = "";
			int attributesCountPolicy = 0;
			for(int j=0; j<vectItemList.get(i).size(); j++) {
				if((vectCheckList.get(i)).get(j)) {
					String attribute = "phr:"+(vectItemList.get(i)).get(j) + " ";
					simplePolicy += attribute;
					attributesCountPolicy++;
				}
			}
			if(!simplePolicy.isBlank()) {
				simplePolicy = simplePolicy + "1of" + String.valueOf(attributesCountPolicy);
				policyCount++;
				resultantPolicy = resultantPolicy + simplePolicy + " ";
			}
		}
		if(resultantPolicy.isBlank()) {
			return "Empty policy. Add some attributes to make policy";
		} else {
			
			resultantPolicy = resultantPolicy + actionAttributes + " 1of1 ";
			resultantPolicy = resultantPolicy + (policyCount+1) + "of" + (policyCount+1);
			return insertPolicytoDatabase();
		}
	}
	
	public String insertPolicytoDatabase() {
		Connection conn = Connect.startConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT into POLICYSET (policy) VALUES ('"+resultantPolicy+"');";
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
