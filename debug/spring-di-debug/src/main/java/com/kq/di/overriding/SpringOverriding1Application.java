package com.kq.di.overriding;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

/**
 * @author kq
 * @date 2021-09-18 17:03
 * @since 2020-0630
 */

@ComponentScan("com.kq.di.overriding")
@Configuration
public class SpringOverriding1Application {

	public static void main(String[] args) {
		// spring.main.allow-bean-definition-overriding
		// allowBeanDefinitionOverriding
		// 逻辑在  DefaultListableBeanFactory:976   registerBeanDefinition

		// ClassPathBeanDefinitionScanner.checkCandidate
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringOverriding1Application.class);


		context.registerBeanDefinition("myobject",getBeanDefinition());
		context.registerBeanDefinition("myobject",getBeanDefinition1());
		context.registerBeanDefinition("myobject",getBeanDefinition2());

//		context.setAllowBeanDefinitionOverriding(true);

		BaseMyObject userService = (BaseMyObject)context.getBean("myobject");
		userService.print();

	}

	private static BeanDefinition getBeanDefinition() {

		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.kq.di.overriding.MyObject");

		return beanDefinition;

	}

	private static BeanDefinition getBeanDefinition1() {

		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.kq.di.overriding.MyObject1");

		return beanDefinition;

	}

	private static BeanDefinition getBeanDefinition2() {

		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName("com.kq.di.overriding.MyObject2");

		return beanDefinition;

	}



}
