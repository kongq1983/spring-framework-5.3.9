package com.kq.di.constructor.simple;

import com.kq.di.constructor.simple.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-23 8:36
 * @since 2020-0630
 */
@ComponentScan("com.kq.di.constructor.simple")
@Configuration
public class SimpleConstructorApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleConstructorApplication.class);
		UserService userService = context.getBean(UserService.class);
		userService.message();

	}

}
