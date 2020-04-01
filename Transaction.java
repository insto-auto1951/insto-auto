package com.test.account.domain;

public class Transaction {

	private java.util.Date mDate;
    private double mAmount;
    private double mBalance;
    private String mDescription;
    
    public Transaction(char type, double amount, double balance, String description) {
        mAmount = amount;
        mBalance = balance;
        mDescription = description;
        mDate = new java.util.Date();
    }    
    public double getAmount() {
        return mAmount;
    } 
    
    public void setAmount(double amount) {
        mAmount = amount;
    }

    public double getBalance() {
        return mBalance;
    }
    
    public void setBalance(double balance) {
        mBalance = balance;
    }
    
    public String getDescription() {
        return mDescription;
    }
    
    public void setDescription(String description) {
        mDescription = description;
    }
    
    public java.util.Date getDate() {
        return mDate;
    }
	
}
