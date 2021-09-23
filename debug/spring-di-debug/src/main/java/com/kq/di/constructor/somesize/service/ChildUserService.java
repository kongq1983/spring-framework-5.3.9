package com.kq.di.constructor.somesize.service;

import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 15:27
 * @since 2020-0630
 */
@Component("ChildUserService")
public class ChildUserService extends UserService{

	@Override
	public void message(){
		System.out.println("this is ChildUserService-user-service");
	}

}
