package com.bankz.persistence;


import java.util.List;
import java.util.Map;

public class QueryBuilder {
	
	public String fetchQuery(String tablename,Map<String, Object>keyMap) 	{
		StringBuilder query=new StringBuilder();
		select(query, tablename);
		if (tablename.equals("Customer")) {
			query.append("  JOIN User ON "+tablename+".CUSTOMER_ID=User.USER_ID ");
			where(query, keyMap);
		}else if (tablename.equals("Employee")) {
			query.append("  JOIN User ON "+tablename+".EMPLOYEE_ID=User.USER_ID ");
			where(query, keyMap);
		}else if(tablename.equals("Transaction") || tablename.equals("Accounts")) {
			where(query, keyMap);
			query.deleteCharAt(query.length()-1);
			query.append(" LIMIT  ? OFFSET ? ;");
		}
		
		return query.toString();
	}
	
	public String fetchSingleRecordQuery(String tableName,Map<String, Object>keyMap) {
		StringBuilder query=new StringBuilder();
		select(query, tableName);
		where(query, keyMap);
		return query.toString();
	}
	
	
	
	public String fetchSpecificValuesQuery(String tableName,Map<String, Object>keyMap,List<String> columnList) {
		StringBuilder query=new StringBuilder();
		select(query, tableName,columnList);
		where(query, keyMap);
		return query.toString();
	}
	
	public String modifyRecordQuery(String tableName,List<String>fieldList,List<Object>recordValuesList,Map<String, Object> keyMap) {
		StringBuilder query=new StringBuilder();
		update(query, tableName, fieldList,recordValuesList);
		where(query, keyMap);
		return query.toString();
	}
	
	public String modifyQuery(String tableName,Map<String, Object> updateMap,Map<String, Object> keyMap) {
		StringBuilder query=new StringBuilder();
		update(query, tableName, updateMap);
		where(query, keyMap);
		return query.toString();
		
	}
	
	
	
	public String deleteQuery(String tableName,Map<String, Object>keyMap) {
		StringBuilder query=new StringBuilder();
		delete(query, tableName);
		where(query, keyMap);
		return query.toString();
	}
	
	
	
	
	
	
	
	
	
	
	

	public void select(StringBuilder query,String tableName) {
		
		query.append("SELECT * FROM " + tableName);

	}
	
	private void update(StringBuilder query,String tableName,List<String>fieldList,
								List<Object>recordValuesList) {

		int length=fieldList.size();
		query.append("UPDATE "+tableName+" SET ");
		for(int i=0;i<length;i++) {
			if(recordValuesList.get(i) instanceof String) {
				query.append(fieldList.get(i)+" = \'"+recordValuesList.get(i)+"\',");
			}else {
				query.append(fieldList.get(i)+" = "+recordValuesList.get(i)+",");
			}
		}query.deleteCharAt(query.length()-1);
	}
	
	@SuppressWarnings("unused")
	private String update(StringBuilder query,String tableName,Map<String, Object>updateMap) {
		updateMap.forEach((key,value)->
		{ 
			query.append(" UPDATE "+tableName+" SET "+key+" = \'"+value+"\'");
		});
		return query.toString();
	}
	
	private void select(StringBuilder query, String tableName,List<String> columnList) {
		for(String str:columnList) {
			query.append(str+",");
		}
		query.append("SELECT "+query.toString().substring(0,query.length())+" FROM "+tableName);
	}

	private void delete(StringBuilder query,String tableName) {
		query.append( "DELETE FROM " + tableName);
	}
	
	private void join(StringBuilder query,String rightTableName) {
		query.append(" JOIN "+rightTableName+" ON ");
	}

	private String alterModify(StringBuilder query,String tableName,String columnName) {
		return " ALTER TABLE "+tableName+" COLUMN "+columnName;
	}
	@SuppressWarnings("unused")
	private void where(StringBuilder query,Map<String, Object> conditionMap) {
		
		conditionMap.forEach((key,value)->
		{ 
			query.append(" WHERE "+key+" = \'"+value+"\'");
		});
		query.append(";");
		
	}
	
	
	
	
	public String demoQuery(String tableName,Object...objects ) {
		StringBuilder query=new StringBuilder();
		select(query, tableName);
		query.append(" WHERE "+objects[0]+" = \'"+objects[1]+"\';");
		return query.toString();
	}
	
	

}
