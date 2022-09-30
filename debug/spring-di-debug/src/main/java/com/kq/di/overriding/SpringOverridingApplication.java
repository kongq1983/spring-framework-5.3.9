package com.kq.di.overriding;

import org.springframework.beans.factory.config.BeanDefinition;
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
public class SpringOverridingApplication {

	public static void main(String[] args) {
		// spring.main.allow-bean-definition-overriding
		// allowBeanDefinitionOverriding
		// 逻辑在  DefaultListableBeanFactory:976   registerBeanDefinition

		// ClassPathBeanDefinitionScanner.checkCandidate
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringOverridingApplication.class);

//		context.setAllowBeanDefinitionOverriding(true);

		BaseMyObject userService = (BaseMyObject)context.getBean("myobject");
		userService.print();

	}

	// ClassPathBeanDefinitionScanner
	protected boolean isCompatible(BeanDefinition newDefinition, BeanDefinition existingDefinition) {
		return (
				!(existingDefinition instanceof ScannedGenericBeanDefinition)  // 注意!，只对第1个条件有效
					||  // explicitly registered overriding bean
					(newDefinition.getSource() != null && newDefinition.getSource().equals(existingDefinition.getSource())) // 扫描同个文件2次 scanned same file twice
					||
					newDefinition.equals(existingDefinition)  // 扫描同等class2次 (比如不同包中的class(相同包名、相同类名)) scanned equivalent class twice
				);
	} //


	public static void main1(String[] args) {

		int a = 12;
		int b = 11;

		int c = 15;
		int d = 18;

		int e = 10;
		int f = 18;

		boolean result = (!(a>b) || (c>d) ||  (e>f));

		System.out.println(result);
	}

}
