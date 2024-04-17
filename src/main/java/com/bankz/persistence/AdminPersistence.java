package com.bankz.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bankz.pojo.Account;
import com.bankz.pojo.Branch;
import com.bankz.utilities.InvalidInputException;
import com.bankz.utilities.UtilityTasks;

public class AdminPersistence extends EmployeePersistence{
	public void addEmployee(List<Object> employeeDetailsList) throws SQLException,InvalidInputException{
		UtilityTasks.checkNull(employeeDetailsList);
		List<String>fieldList=dbTasks.fetchColumnList("Employee");
		dbTasks.addRecords("Employee", fieldList, employeeDetailsList);
	}
	
	public void blockEmployee(int employeeId) throws SQLException,InvalidInputException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0),employeeId );
		Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("User").get(7), 1);
		dbTasks.modifyRecord("User", keyMap, updateMap);
	}
	
	public void activateEmployee(int employeeId) throws SQLException,InvalidInputException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0),employeeId );
		Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("User").get(7), 0);
		dbTasks.modifyRecord("User", keyMap, updateMap);
	}
	
	public void removeEmployee(int userId) throws SQLException,InvalidInputException{
		Map<String, Object>keyMap=new HashMap<String, Object>();
		keyMap.put(dbTasks.fetchColumnList("User").get(0), userId);
		dbTasks.deleteRecords("User", keyMap);
	}
	
	public void addBranch(List<Object> branchDetailsList) throws SQLException,InvalidInputException{
		UtilityTasks.checkNull(branchDetailsList);
		List<String>fieldList=dbTasks.fetchColumnList("Branch");
		dbTasks.addRecords("Branch", fieldList, branchDetailsList);
	}
	
	public Map<Integer, Object> getAllBranches()throws SQLException,InvalidInputException{
		StringBuilder query=new StringBuilder();
		queryBuilder.select(query, "Branch");
		return dbTasks.fetchRecords("Branch", query.toString());
	}
	
	public void removeBranch(int branchId) throws SQLException,InvalidInputException, ClassNotFoundException{
		Map<String, Object>keyMap=new HashMap<String, Object>();
		keyMap.put(dbTasks.fetchColumnList("Branch").get(0), branchId);
		dbTasks.deleteRecords("Branch", keyMap);
		Map<String, Object> key=getMap(dbTasks.fetchColumnList("Accounts").get(5), branchId);
		Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("Accounts").get(4), 1);
		dbTasks.modifyRecord("Accounts", key, updateMap);
	}
}
