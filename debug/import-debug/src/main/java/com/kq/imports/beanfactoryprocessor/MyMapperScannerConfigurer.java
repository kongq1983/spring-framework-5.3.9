package com.kq.imports.beanfactoryprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * // @see org.mybatis.spring.annotation.MapperScannerRegistrar
 * @author kq
 * @date 2020-10-19 14:01
 * @since 2020-0630
 */
public class MyMapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware, BeanNameAware {

    private String beanName = null;

    @Override
    public void setBeanName(String name) {
        System.out.println("call setBeanName");
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("call afterPropertiesSet");
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("call postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("call postProcessBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("call setApplicationContext");
    }

    public String getBeanName(){
        return this.beanName;
    }

}
