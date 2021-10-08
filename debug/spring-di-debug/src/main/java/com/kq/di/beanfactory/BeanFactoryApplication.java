package com.kq.di.beanfactory;

import com.kq.di.beanfactory.bean.MyBeanDefinitionRegistryPostProcessor;
import com.kq.di.configuration.ConfigurationApplication;
import com.kq.di.configuration.config.MyConfig;
import com.kq.di.configuration.config.MyConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kq
 * @date 2021-09-27 16:42
 * @since 2020-0630
 */

//@Configuration
@ComponentScan("com.kq.di.beanfactory")
public class BeanFactoryApplication {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(); //BeanFactoryApplication.class

		MyBeanDefinitionRegistryPostProcessor myBeanDefinitionRegistryPostProcessor = new MyBeanDefinitionRegistryPostProcessor();
		context.addBeanFactoryPostProcessor(myBeanDefinitionRegistryPostProcessor);
		context.register(BeanFactoryApplication.class);
		context.refresh();

	}


}
