package com.kq.di.simple;

import com.kq.di.simple.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-18 17:03
 * @since 2020-0630
 */

@ComponentScan("com.kq.di.simple")
@Configuration
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDiApplication.class);
		UserService userService = context.getBean(UserService.class);
		userService.message();

	}

}
