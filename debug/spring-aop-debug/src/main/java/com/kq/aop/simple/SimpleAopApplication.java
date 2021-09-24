package com.kq.aop.simple;

import com.kq.aop.entity.Account;
import com.kq.aop.simple.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kq
 * @date 2021-09-24 10:06
 * @since 2020-0630
 */
@ComponentScan("com.kq.aop.simple")
@Configuration
@EnableAspectJAutoProxy
public class SimpleAopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleAopApplication.class);
		AccountService userService = context.getBean(AccountService.class);
		Account a = new Account();
		a.setId(1);
		a.setName("king");
		userService.addUser(a);
		a.setId(2);
		userService.updateUser(a);

	}


}
