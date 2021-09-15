package com.kq.imports.registrar;

import com.kq.imports.beanfactoryprocessor.MyMapperScannerConfigurer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @date 2020-10-19 13:55
 * @author kq
 * @since 2020-0630
 */
public class AnimalImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyMapperScannerConfigurer.class);

        registry.registerBeanDefinition("animalImportBeanDefinitionRegistrar", builder.getBeanDefinition());
    }
}
