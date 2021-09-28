package com.kq.di.lazy;

import com.kq.di.lazy.service.AccountService;
import com.kq.di.lazy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author kq
 * @date 2021-09-28 15:26
 * @since 2020-0630
 */

@ComponentScan("com.kq.di.lazy")
@Configuration
public class LazyApplication {

//	@Autowired
	private Map<String,Object> allBeans;

	public Map<String, Object> getAllBeans() {
		return allBeans;
	}

	public static void main(String[] args) {



		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyApplication.class);

		LazyApplication lazyApplication = context.getBean(LazyApplication.class);
		System.out.println(lazyApplication.getAllBeans());

//		UserService userService = context.getBean(UserService.class);
//		userService.message();

		AccountService accountService = context.getBean(AccountService.class);
		accountService.message();

		System.out.println("=========================================");
		UserService userService = context.getBean(UserService.class);
		userService.message();
		userService.message();
		System.out.println("=========================================");
		accountService.message();

	}




}
