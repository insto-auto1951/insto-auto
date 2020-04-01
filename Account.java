package com.test.account.domain;

import java.util.List;

public class Account {
	
	private int accountNumber;
	private String holderName;
	private String holderAddress;
	private String openDate;
	private double balance;
	private Transaction[] transaction;
	private List<Transaction> listOfTransaction;
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getHolderAddress() {
		return holderAddress;
	}

	public void setHolderAddress(String holderAddress) {
		this.holderAddress = holderAddress;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Transaction[] getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction[] transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getListOfTransaction() {
		return listOfTransaction;
	}

	public void setListOfTransaction(List<Transaction> listOfTransaction) {
		this.listOfTransaction = listOfTransaction;
	}

	public int getNumOfTransactions() {
		return numOfTransactions;
	}

	public void setNumOfTransactions(int numOfTransactions) {
		this.numOfTransactions = numOfTransactions;
	}

	public static int getNoOfAccounts() {
		return noOfAccounts;
	}

	public static void setNoOfAccounts(int noOfAccounts) {
		Account.noOfAccounts = noOfAccounts;
	}

	private int numOfTransactions;
	private  static int noOfAccounts=0;
	
	public String getAccountInfo(){
	    return "Account number: " + accountNumber + "\nCustomer Name: " + holderName + "\nHolder's Address: " + holderAddress + "\nOpen Date: " + openDate +  "\nBalance:" + balance +"\n";
	}

	public String getTransactionInfo(int n)
	{
	    String transaction = transactionsSummary[n];
	    if (transaction == null) {
	        return "No transaction exists with that number.";
	    }
	    else {
	        return transaction;
	    }
	}

	public Account(String holderName, double balance, String address, String openDate){
	    this.holderName = this.holderName;
	    this.balance = this.balance;
	    this.holderAddress = address;
	    this.openDate = openDate;
	    noOfAccounts ++;
	    accountNumber = noOfAccounts;
	   
	}

	public int getAccountNum(){
	    return accountNumber;
	}

	public int getNumberOfTransactions() {
	    return numOfTransactions;
	}
	
	public void createAccount() {
		
	}
	public void deposit(double amount){

	    if (amount<=0) {
	        System.out.println("Amount to be deposited should be positive");
	    } else {
	        balance = balance + amount;
	        transactions[numOfTransactions] = amount;
	        transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was deposited.";
	        numOfTransactions++;
	    }
	}

	public void withdraw(double amount)
	{
	    if (amount<=0){
	        System.out.println("Amount to be withdrawn should be positive");
	    }
	    else
	    {
	        if (balance < amount) {
	            System.out.println("Insufficient balance");
	        } else {
	            balance = balance - amount;
	            transactions[numOfTransactions] = amount;
	            transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was withdrawn.";
	            numOfTransactions++;
	        }
	    }
	}

}
