package com.kq.di.configuration.config;

import com.kq.di.configuration.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-27 9:51
 * @since 2020-0630
 */
@Configuration(proxyBeanMethods=false)
public class MyConfig1 {

	@Bean
	public UserService getUserService(){
		UserService userService = new UserService();
		return userService;
	}


}
