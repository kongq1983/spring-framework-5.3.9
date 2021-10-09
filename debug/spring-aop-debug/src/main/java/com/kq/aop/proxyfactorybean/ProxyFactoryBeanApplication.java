package com.kq.aop.proxyfactorybean;

import com.kq.aop.entity.Account;
import com.kq.aop.proxyfactorybean.service.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ProxyFactoryBeanApplication
 * ProxyCreatorSupport.createAopProxy -> DefaultAopProxyFactory.createAopProxy(jdk or cglib)
 * @author kq
 * @date 2021/10/9 22:51
 * @since 1.0.0
 */

@ComponentScan("com.kq.aop.proxyfactorybean")
@Configuration
public class ProxyFactoryBeanApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProxyFactoryBeanApplication.class);
		AccountService userService = context.getBean(AccountService.class);
		userService.addUser(new Account());

	}

}
