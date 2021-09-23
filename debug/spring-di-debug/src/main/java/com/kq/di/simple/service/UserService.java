package com.kq.di.simple.service;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author kq
 * @date 2021-09-18 10:03
 * @since 2020-0630
 */

//@Service
@Component
public class UserService {

//	@Lazy
//	@Autowired //@Autowired 根据类型匹配的
//	@Resource
	@Resource(name = "userService")
//	@Resource(name = "userService1")
	private UserService userService2;


	public void message() {
		System.out.println("this="+this);
		System.out.println("this.userService="+this.userService2);
	}

}
