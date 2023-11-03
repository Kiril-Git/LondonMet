package com.cs5003.bankingsystem.Bank;

public class StudentAccount extends SavingsAccount {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String  institutionName;

public StudentAccount(String name, String address, String opendate, double balance ,String  institutionName) {
	super(name, address, opendate, balance, 20000);
	min_balance=100;
	this.institutionName=institutionName;
//	this.type="Stuedent Account";
}



}
