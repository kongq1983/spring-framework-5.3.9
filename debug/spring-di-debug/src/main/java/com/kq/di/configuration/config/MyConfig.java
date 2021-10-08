package com.kq.di.configuration.config;

import com.kq.di.configuration.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-27 9:51
 * @since 2020-0630
 */
@Configuration
public class MyConfig {

	@Bean
	public AccountService getAccountService(){
		AccountService accountService = new AccountService();
		return accountService;
	}

}
