package com.kq.aop.simple.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 就本文件来说findCandidateAdvisors()有3个  分别是around、before、after
 * @author kq
 * @date 2021-09-24 9:54
 * @since 2020-0630
 */
@Aspect
@Component
public class TransactionAspect {
	// 这个是: PointcutAdvisor   declaredPointCut
//	@Pointcut("execution(* com.kq.aop.simple..*.add*(..))")
	@Pointcut("execution(* com.kq.aop.simple..*.add*(..))")
	public void getAddDsPointCut() { }


//	@Before("com.kq.aop.simple.config.TransactionAspect.getAddDsPointCut()")
//	@Before("execution(* com.kq.aop.simple.service.*.add*(..))")
	@Before("getAddDsPointCut()") // Advisor   findCandidateAdvisors()
	public void before(JoinPoint joinPoint) {
		System.out.println("============================获取DataSource");
	}


//	@After("com.kq.aop.simple.config.TransactionAspect.getAddDsPointCut()")
	@After("getAddDsPointCut()") // Advisor  findCandidateAdvisors()
	public void after(JoinPoint joinPoint) {
		System.out.println("============================释放DataSource");
	}

	@Around("getAddDsPointCut()") // Advisor  findCandidateAdvisors()
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		MethodSignature joinPointObject=(MethodSignature) pjp.getSignature();
		Method method = joinPointObject.getMethod();

		String methodName = method.getName();
//        String className = pjp.getTarget().getClass().getName();
		String className = pjp.getSignature().getDeclaringType().getSimpleName();


		long startTime = System.currentTimeMillis();

		try {
			return pjp.proceed();
		} finally {
			long endTime = System.currentTimeMillis();

			long diff = (endTime-startTime);
			System.out.println("====================================around spentTime="+diff+"ms");

		}
	}

}
