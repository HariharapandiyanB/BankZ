package com.bankz.persistence;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bankz.enums.UserStatus;
import com.bankz.pojo.User;
import com.bankz.utilities.InvalidInputException;
import com.bankz.utilities.UtilityTasks;

public class UserPersistence {
	
	DatabaseTasks dbTasks=new DatabaseTasks("jdbc:mysql://localhost:3306/bankZ","root","hari03@mySql");
	public User login(int userId)throws SQLException,InvalidInputException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
		Map<Integer, Object>resultMap=dbTasks.fetchRecords("User", keyMap);
		return (User)resultMap.get(userId);
	}
	
	public User getPersonalInfo(int userId) throws SQLException, InvalidInputException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
		Map<Integer, Object> resultMap=dbTasks.fetchRecords("User", keyMap);
		return (User)resultMap.get(userId);
	}
	
	public void addLog(List<Object>logList) throws SQLException,InvalidInputException{
		UtilityTasks.checkNull(logList);
		List<String> fieldList=dbTasks.fetchColumnList("Audit_Log");
		dbTasks.addRecords("Audit_Log", fieldList, logList);
	}
	
	public void changePassword(String password,int userId) throws SQLException,InvalidInputException, NoSuchAlgorithmException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
		Map<String , Object> updateMap=getMap(dbTasks.fetchColumnList("User").get(1), password);
		dbTasks.modifyRecord("User", keyMap, updateMap);
	}
	
	public int checkStatus(int userId) throws SQLException,InvalidInputException{
		
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
		Map<Integer,Object>resultMap= dbTasks.fetchRecords("User", keyMap);
		return((User)resultMap.get(userId)).getStatus();
	}
	
	public  List<Object> getTransactionDetails(int userId,int pageNum) throws SQLException,InvalidInputException{
		Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("Transaction").get(1), userId);
		return dbTasks.fetchMultipleRecords("Transaction", keyMap,pageNum,3).get(userId);
		
	}
	
	protected Map<String, Object> getMap(String key,Object value){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put(key, value);
		return map;
	}
	
}
