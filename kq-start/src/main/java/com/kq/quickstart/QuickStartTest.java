package com.kq.quickstart;

import com.kq.quickstart.config.AppConfig;
import com.kq.quickstart.service.AliasService;
import com.kq.quickstart.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * QuickStartTest
 *
 * @author kq
 * @date 2021/9/8 23:55
 * @since 1.0.0
 */
public class QuickStartTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = (UserService) context.getBean("userService");

//		AliasService aliasService = (AliasService) context.getBean("aliasService1");
		AliasService aliasService = (AliasService) context.getBean("getAliasService"); // 不指定beanName

		userService.message();
		aliasService.message();
	}

}
