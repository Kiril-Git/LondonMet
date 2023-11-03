package com.cs5003.bankingsystem.Bank;
import java.io.Serializable;

import com.cs5003.bankingsystem.Exceptions.MaxBalance;
import com.cs5003.bankingsystem.Exceptions.MaxWithdraw;

public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
        String address;
        String opendate;
	private double balance;
	double min_balance;
	String acc_num;
	//String type;
	
	
	public BankAccount(String name, String address, String opendate, double balance, double min_balance) {
		this.name = name;
                this.address = address;
                this.opendate = opendate;
		this.balance = balance;
		this.min_balance = min_balance;
		acc_num = 10000 + (int)(Math.random()*89999) + "";
	}

	public void deposit(double amount)
	{
		balance+=amount;
	}
	
	public void withdraw(double amount) throws MaxWithdraw, MaxBalance
	{
		if((balance-amount)>=min_balance && amount<balance)
		{
			balance-=amount;
			
		}
		
		else
		{
			throw new MaxBalance("Insufficient Balance");
		}
	}
	
	public double getbalance()
	{
		return balance;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Address: " + address + ", opendate: " + opendate +  ", Id: " + acc_num + ", Balance: " + balance +"Type:"+this.getClass();
	}
}
