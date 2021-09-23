package com.kq.di.constructor.somesize.service;

import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 15:27
 * @since 2020-0630
 */
@Component("ParentUserService")
public class ParentUserService {

	public void message(){
		System.out.println("this is ParentUserService-user-service");
	}

}
