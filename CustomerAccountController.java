package com.test.account;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.account.domain.Account;
import com.test.account.domain.Transaction;

@RestController
public class CustomerAccountController {
	private static Map<Integer,Account> map=new HashMap();
	private static List<Account> accounts=new ArrayList();
	static {
		Account acnt1=new Account("Alok",2000.00,"bangalore","2019-02-04");
		Account acnt2=new Account("Adam",4000.00,"hyderabad","2019-03-07");
		Account acnt3=new Account("John",1000.00,"california","2019-04-06");
		Account acnt4=new Account("Marry",5000.00,"newyork","2019-05-03");
		Account acnt5=new Account("Nihar",6000.00,"mumbai","2019-06-04");
		Account acnt6=new Account("Maher",8000.00,"delhi","2019-07-04");
		accounts.add(acnt1);
		accounts.add(acnt6);
		accounts.add(acnt5);
		accounts.add(acnt4);
		accounts.add(acnt3);
		accounts.add(acnt2);
		map.put(acnt1.getAccountNum(), acnt1);
		map.put(acnt2.getAccountNum(), acnt2);
		map.put(acnt3.getAccountNum(), acnt3);
		map.put(acnt4.getAccountNum(), acnt4);
		map.put(acnt5.getAccountNum(), acnt5);
		map.put(acnt6.getAccountNum(), acnt6);
		
	}
	//Required functionality: - View account list - View account transactions 
	@RequestMapping(name = "/getaccountlist",method = RequestMethod.GET)
	public ResponseEntity<Collection<Account>> getAccountList(){
		
		Collection<Account> accountdetails=map.values();
		return new ResponseEntity<Collection<Account>>(accountdetails, HttpStatus.FOUND);
	}
	@RequestMapping(name = "/gettransactiondetails",method = RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getTransactionDetails(){
		
		//Collection<Account> accountdetails=map.values();
		Account account=map.values().iterator().next();
		List<Transaction> transaction=account.getListOfTransaction();
		//return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.FOUND);
		return new ResponseEntity<List<Transaction>>(transaction, HttpStatus.FOUND);
	}
}
