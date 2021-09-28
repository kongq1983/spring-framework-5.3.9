package com.kq.di.lazy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kq
 * @date 2021-09-18 10:03
 * @since 2020-0630
 */


//@Service
@Scope("prototype")
@Lazy
@Component
public class UserService {

	public UserService(){
		System.out.println("UserService init ");
	}

	@Autowired
	private AccountService accountService;

//	@Lazy
//	@Autowired //@Autowired 根据类型匹配的
//	@Resource
//	@Resource(name = "userService")
////	@Resource(name = "userService1")
//	private UserService userService2;


	public void message() {
		System.out.println("this="+this);
//		System.out.println("this.userService="+this.userService2);
	}

}
