package com.kq.di;

import com.kq.di.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-18 17:03
 * @since 2020-0630
 */

@Configuration
public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDiApplication.class);
		UserService userService = context.getBean(UserService.class);
		userService.message();

	}

}
