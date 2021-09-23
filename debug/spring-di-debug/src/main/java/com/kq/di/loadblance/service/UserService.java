package com.kq.di.loadblance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 18:24
 * @since 2020-0630
 */
@Component
public class UserService  {

	@Autowired
	@RoundRobin
//	@Random
//	@Qualifier("random")
	private LoadBalance loadBalance;

	public void message() {
		System.out.println(loadBalance);
	}

}