package com.kq.aop.simple.service;

import com.kq.aop.entity.Account;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-24 10:02
 * @since 2020-0630
 */
@Component
public class AccountService {

	public void addUser(Account account){
		System.out.println("add用户:"+account);
	}

	public void updateUser(Account account){
		System.out.println("update用户:"+account);
	}

}
