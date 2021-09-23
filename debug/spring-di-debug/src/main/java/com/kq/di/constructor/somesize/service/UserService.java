package com.kq.di.constructor.somesize.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 8:32
 * @since 2020-0630
 */

@Component("UserService")
public class UserService extends ParentUserService{

	AccountService accountService;


//	@Autowired
	@Autowired(required = false)
	public UserService() { // 子类会调用父类的构造函数
		System.out.println("UserService:0");
	}


	@Autowired(required = false)
	public UserService(AccountService accountService){
		System.out.println("UserService:1");
		System.out.println("UserService:accountService="+accountService);
		this.accountService = accountService;
	}

	@Autowired(required = false)
	public UserService(AccountService accountService,ParentUserService parentUserService){
		System.out.println("parentUserService:2");
		this.accountService = accountService;
	}

	@Autowired(required = false)
	public UserService(ChildUserService childUserService,AccountService accountService){
		System.out.println("childUserService:4");
		this.accountService = accountService;
	}


	@Autowired(required = false)
	public UserService(AccountService accountService, ChildUserService childUserService){
		System.out.println("childUserService:3");
		this.accountService = accountService;
	}


	@Override
	public void message(){

		if(accountService!=null){
			System.out.println("UserService.message:accountService="+accountService);
			accountService.message();
		}
		System.out.println("this is user-service");
	}


}
