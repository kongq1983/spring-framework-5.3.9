package com.kq.di.constructor.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 8:32
 * @since 2020-0630
 */

@Component
public class UserService {

	AccountService accountService;


//	@Autowired
	@Autowired(required = false)
	public UserService() {
		System.out.println("UserService:0");
	}


	@Autowired(required = false)
	public UserService(AccountService accountService){
		System.out.println("UserService:1");
		System.out.println("UserService:accountService="+accountService);
		this.accountService = accountService;
	}

	public void message(){

		if(accountService!=null){
			System.out.println("UserService.message:accountService="+accountService);
			accountService.message();
		}
		System.out.println("this is user-service");
	}

}
