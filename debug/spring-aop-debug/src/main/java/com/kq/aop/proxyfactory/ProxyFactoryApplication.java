package com.kq.aop.proxyfactory;

import com.kq.aop.entity.Account;
import com.kq.aop.proxyfactory.service.AccountService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * ProxyFactoryApplication
 *
 * @author kq
 * @date 2021/10/8 21:05
 * @since 1.0.0
 */
public class ProxyFactoryApplication {

	public static void main(String[] args) {

		AccountService accountService = new AccountService();

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(accountService);
		proxyFactory.addAdvice(new MethodBeforeAdvice(){
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("===========before  args:"+args +" target="+target);
			}
		});

		proxyFactory.addAdvice(new AfterReturningAdvice() {
			@Override
			public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
				System.out.println("============afterReturning  args:"+args +" target="+target);
			}
		});

		AccountService proxy = (AccountService) proxyFactory.getProxy();
		proxy.addUser(new Account());


	}

}
