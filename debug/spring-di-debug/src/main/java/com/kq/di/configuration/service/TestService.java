package com.kq.di.configuration.service;

import com.kq.di.configuration.config.MyConfig;
import com.kq.di.configuration.config.MyConfig1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-27 9:55
 * @since 2020-0630
 */
@Component
public class TestService {

	@Autowired
	private MyConfig myConfig;

	@Autowired
	private MyConfig1 myConfig1;

	public void test(){

		System.out.println(myConfig.getAccountService());
		System.out.println(myConfig1.getUserService());

	}


}
