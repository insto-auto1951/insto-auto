package com.test.account;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.account.domain.Account;
import com.test.account.domain.Transaction;
@SpringBootApplication
public class CustomerAccountApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerAccountApplication.class, args);
	}

}
