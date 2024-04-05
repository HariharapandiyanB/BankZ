package com.bankz.enums;



public enum AccountType {
	CURRENT(1),
	SAVINGS(2);
	
	int accountTypeId;
	private AccountType(int accountTypeId) {
		this.accountTypeId=accountTypeId;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	
	
}
