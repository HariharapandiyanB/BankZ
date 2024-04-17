package com.bankz.persistence;

import java.sql.SQLException;
import java.text.BreakIterator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.el.parser.AstPlus;

import com.bankz.pojo.Branch;

import com.bankz.pojo.Employee;
import com.bankz.utilities.InvalidInputException;
import com.bankz.utilities.UtilityTasks;


public class EmployeePersistence extends UserPersistence{
		DatabaseTasks dbTasks=new DatabaseTasks("jdbc:mysql://localhost:3306/bankZ","root","hari03@mySql");
		QueryBuilder queryBuilder=new QueryBuilder();
		
		public Employee getPersonalInfo(int userId) throws SQLException, InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
			Map<Integer, Object> resultMap=dbTasks.fetchRecords("Employee", keyMap);
			return (Employee)resultMap.get(userId);
		}
		
		public void editEmployeePersonalInfo(int userId,List<Object> recordValuesList)throws InvalidInputException,SQLException{
			List<String>fieldsList=dbTasks.fetchColumnList("User");
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0),userId);
			dbTasks.editRecords("User", fieldsList, recordValuesList, keyMap);
			
			
		}
		
		public void addAccount(List<Object> accountDetailsList) throws SQLException,InvalidInputException{
			UtilityTasks.checkNull(accountDetailsList);
			List<String> fieldList=dbTasks.fetchColumnList("Accounts");
			dbTasks.addRecords("Accounts", fieldList, accountDetailsList);
			
		}
		
		public void removeAccount(long accountNum) throws SQLException,InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("Accounts").get(0), accountNum);
			dbTasks.deleteRecords("Accounts", keyMap);
		}
		
		public void blockAccount(long accountNum) throws SQLException,InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("Accounts").get(0), accountNum);
			Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("Accounts").get(4), 1);
			dbTasks.modifyRecord("Accounts", keyMap, updateMap);
		}
		
		public void activateAccount(long accountNum) throws SQLException,InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("Accounts").get(0), accountNum);
			Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("Accounts").get(4), 0);
			dbTasks.modifyRecord("Accounts", keyMap, updateMap);
		}
		
		
		public void  addUser(List<Object> userDetailsList) throws SQLException,InvalidInputException {
			UtilityTasks.checkNull(userDetailsList);
			List<String>fieldList=dbTasks.fetchColumnList("User");
			dbTasks.addRecords("User", fieldList, userDetailsList);
		}
		
		public void  addCustomer(List<Object> customerDetailsList) throws SQLException,InvalidInputException {
			UtilityTasks.checkNull(customerDetailsList);
			List<String>fieldList=dbTasks.fetchColumnList("Customer");
			dbTasks.addRecords("Customer", fieldList, customerDetailsList);
		}
		
		public void addDeprecatedUser(List<Object> customerDetailsList) throws SQLException,InvalidInputException {
			UtilityTasks.checkNull(customerDetailsList);
			List<String> fieldList=dbTasks.fetchColumnList("Deprecated_User");
			dbTasks.addRecords("Deprecated_User", fieldList, customerDetailsList);
		}
		
		public void blockCustomer(int userId) throws SQLException,InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
			Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("User").get(7), 1);
			dbTasks.modifyRecord("User", keyMap, updateMap);
		}
		
		public void activateCustomer(int userId) throws SQLException,InvalidInputException{
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("User").get(0), userId);
			Map<String, Object> updateMap=getMap(dbTasks.fetchColumnList("User").get(7), 0);
			dbTasks.modifyRecord("User", keyMap, updateMap);
		}
		
		
		public void removeCustomer(int userId) throws SQLException,InvalidInputException {
			Map<String, Object> key=getMap(dbTasks.fetchColumnList("User").get(0), userId);
			dbTasks.deleteRecords("User", key);
			Map<String, Object> keyMap=getMap(dbTasks.fetchColumnList("Customer").get(0), userId);
			dbTasks.deleteRecords("Customer", keyMap);
		}
		
		public Branch getBranch(int branchId)throws SQLException,InvalidInputException{
			Map<String,Object>keyMap= getMap(dbTasks.fetchColumnList("Branch").get(0), branchId);
			return (Branch)dbTasks.fetchRecords("Branch", keyMap).get(branchId);
		}
		
		public Branch getBranch(String branchName) throws SQLException,InvalidInputException, ClassNotFoundException{
			UtilityTasks.checkNull(branchName);
			String query=queryBuilder.demoQuery("Branch", dbTasks.fetchColumnList("Branch").get(1),branchName);
			
			  return (Branch)(dbTasks.fetchListOfRecords("Branch",query).get(0));
						
		}
		
		public void modifyAccountCount(Branch branch)throws SQLException,InvalidInputException{
			UtilityTasks.checkNull(branch);
			Map<String, Object>keyMap=getMap(dbTasks.fetchColumnList("Branch").get(0), branch.getBranchId());
			Map<String, Object>updateMap=getMap(dbTasks.fetchColumnList("Branch").get(5), branch.getNumOfActiveAccounts());
			dbTasks.modifyRecord("Branch", keyMap, updateMap);
		}
		
		public void modifyEmployeeCount(Branch branch)throws SQLException,InvalidInputException{
			UtilityTasks.checkNull(branch);
			Map<String, Object>keyMap=getMap(dbTasks.fetchColumnList("Branch").get(0), branch.getBranchId());
			Map<String, Object>updateMap=getMap(dbTasks.fetchColumnList("Branch").get(4), branch.getNumOfActiveEmployees());
			dbTasks.modifyRecord("Branch", keyMap, updateMap);
		}
		
		
		
		
		
		
}
