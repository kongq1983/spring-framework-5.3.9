package com.kq.di.loadblance;

import com.kq.di.loadblance.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-23 18:25
 * @since 2020-0630
 */

@ComponentScan("com.kq.di.loadblance")
@Configuration
public class LoadBlanceApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoadBlanceApplication.class);
		UserService userService = context.getBean(UserService.class);
//		UserService userService = (UserService)context.getBean("userService");
		userService.message();
	}

}
