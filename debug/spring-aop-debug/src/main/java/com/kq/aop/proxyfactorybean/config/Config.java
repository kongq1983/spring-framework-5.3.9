package com.kq.aop.proxyfactorybean.config;

import com.kq.aop.proxyfactorybean.service.AccountService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Config
 *
 * @author kq
 * @date 2021/10/9 22:48
 * @since 1.0.0
 */
@Component
public class Config {

	@Bean
	public MethodInterceptor aroundAdvise(){

		return new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("before...");
				Object result = invocation.proceed();
				System.out.println("after...");
				return result;
			}
		};
	}


	@Bean
	public ProxyFactoryBean userService(){
		AccountService userService = new AccountService();

		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(userService);
		proxyFactoryBean.setInterceptorNames("aroundAdvise");
		return proxyFactoryBean;
	}

}
