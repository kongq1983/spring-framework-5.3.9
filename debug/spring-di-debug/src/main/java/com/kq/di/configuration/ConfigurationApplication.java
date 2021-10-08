package com.kq.di.configuration;

import com.kq.di.configuration.config.MyConfig;
import com.kq.di.configuration.config.MyConfig1;
import com.kq.di.configuration.service.AccountService;
import com.kq.di.configuration.service.TestService;
import com.kq.di.configuration.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-27 9:59
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.di.configuration")
public class ConfigurationApplication {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApplication.class, MyConfig.class, MyConfig1.class);

		UserService userService = context.getBean(UserService.class);
		AccountService accountService = context.getBean(AccountService.class);

		System.out.println(userService);
		System.out.println(accountService);

		TestService testService = context.getBean(TestService.class);
		testService.test();
		testService.test();
		testService.test();

		MyConfig myConfig = context.getBean(MyConfig.class);
		MyConfig1 myConfig1 = context.getBean(MyConfig1.class);
		ConfigurationApplication configurationApplication = context.getBean(ConfigurationApplication.class);

		System.out.println(myConfig);
		System.out.println(myConfig1);
		System.out.println(configurationApplication);
	}

}
