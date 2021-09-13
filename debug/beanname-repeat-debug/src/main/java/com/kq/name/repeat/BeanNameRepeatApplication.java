package com.kq.name.repeat;

import com.kq.name.repeat.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kq
 * @date 2021-09-13 17:11
 * @since 2020-0630
 */
public class BeanNameRepeatApplication {

	public static void main(String[] args) {
		// scan -> scanner.scan -> doScan -> checkCandidate
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.kq.name");

		//ConfigurationClassPostProcessor BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


	}

}
