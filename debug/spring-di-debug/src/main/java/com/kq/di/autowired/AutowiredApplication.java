package com.kq.di.autowired;

import com.kq.di.autowired.service.AccountService;
import com.kq.di.autowired.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2022-07-15 10:02
 * @since 2020-0630
 */

@ComponentScan("com.kq.di.autowired")
@Configuration
public class AutowiredApplication {


	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredApplication.class);
		UserService userService = context.getBean(UserService.class);
		userService.message();

		AccountService accountService = context.getBean(AccountService.class);
		accountService.message();

	}


}
