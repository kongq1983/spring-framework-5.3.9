package com.kq.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kq
 * @date 2021-09-18 10:03
 * @since 2020-0630
 */

//@Service
@Component
public class UserService {

//	@Lazy
	@Autowired
	private UserService userService;


	public void message() {
		System.out.println("this="+this);
		System.out.println("this.userService="+this.userService);
	}

}
