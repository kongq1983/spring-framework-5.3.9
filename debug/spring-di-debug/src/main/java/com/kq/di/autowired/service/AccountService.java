package com.kq.di.autowired.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2022-07-15 10:01
 * @since 2020-0630
 */

//@Component
public class AccountService {

	@Autowired
	private UserService userService;

	public void message() {
		System.out.println("userService="+userService);
	}

}
