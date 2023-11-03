package com.cs5003.bankingsystem.Bank;

public class CurrentAccount extends BankAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tradeLicenseNumber;
//	String type;

	public CurrentAccount(String name, String address, String opendate, double balance,String tradeLicenseNumber) throws Exception {
		super(name, address, opendate, balance, 5000);
		this.tradeLicenseNumber= tradeLicenseNumber;
		if(balance<5000) throw new Exception("Insufficient Balance");
//		this.type="Current Account";
	}
	
	
}
