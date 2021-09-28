package com.kq.di.lazy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-28 15:28
 * @since 2020-0630
 */
//@Lazy
@Component
public class AccountService {

	public AccountService(){
		System.out.println("AccountService init ");
	}

//	@Autowired
	private UserService userService;

	@Autowired
	private UserService userService1;


	@Lazy
	@Autowired
	public void setUserService(UserService userService) {
//	public void setUserService(@Lazy UserService userService) {
		this.userService = userService;
//		System.out.println("AccountService userService="+userService);
		userService.message();
	}

	public void message(){
		if(this.userService!=null) {
			userService.message();  // userService被代理了
		}
		userService1.message(); // 没代理 都是同一个
	}

	@Override
	public String toString() {
		return "AccountService{" +
				"userService=" + userService + ",this="+this+
				'}';
	}
}
