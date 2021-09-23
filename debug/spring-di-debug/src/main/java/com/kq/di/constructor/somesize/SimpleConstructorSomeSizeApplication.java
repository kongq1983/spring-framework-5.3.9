package com.kq.di.constructor.somesize;

import com.kq.di.constructor.somesize.service.AccountService;
import com.kq.di.constructor.somesize.service.ChildUserService;
import com.kq.di.constructor.somesize.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-23 8:36
 * @since 2020-0630
 */
@ComponentScan("com.kq.di.constructor.somesize")
@Configuration
public class SimpleConstructorSomeSizeApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleConstructorSomeSizeApplication.class);
		// 根据类型获得，如果有多个会报错
//		UserService userService = context.getBean(UserService.class);
//		UserService userService = (UserService)context.getBean("UserService");

		// 如果UserService加了@Lazy，则根据指定的值，选择构造函数，如果没指定，其实上面已经初始化完了，下面的2个参数，其实没啥意义了
//		Object[] args1 = new Object[]{new AccountService(),new ChildUserService()};
		Object[] args1 = new Object[]{new AccountService()};
		UserService userService = (UserService)context.getBean("UserService",args1);
		userService.message();

	}

}
