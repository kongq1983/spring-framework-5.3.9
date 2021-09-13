package com.kq.staticbean;

import com.kq.staticbean.config.AppConfig;
import com.kq.staticbean.service.AliasService;
import com.kq.staticbean.service.OtherService;
import com.kq.staticbean.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kq
 * @date 2021-09-13 12:08
 * @since 2020-0630
 */
public class StaticBeanApplication {

	public static void main(String[] args) {

//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kq.staticbean");

		AliasService aliasService = (AliasService) context.getBean("aliasService1");
		aliasService.message();

		UserService userService = (UserService) context.getBean("userService");
		userService.message();

//		OtherService otherService = (OtherService) context.getBean("otherService");
//		OtherService otherService = (OtherService) context.getBean("aliasService");
//		otherService.message();

	}

}
