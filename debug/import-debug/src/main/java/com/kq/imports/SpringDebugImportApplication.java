package com.kq.imports;

import com.kq.entity.Account;
import com.kq.entity.Employee;
import com.kq.imports.beanfactoryprocessor.MyMapperScannerConfigurer;
import com.kq.imports.service.Animal;
import com.kq.imports.service.impl.Cat;
import com.kq.imports.service.impl.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 重点关注 @See org.springframework.context.annotation.ConfigurationClassParser
 * @author kq
 * @date 2020-10-16 16:53
 * @since 2020-0630
 */
@Configuration
@ComponentScan("com.kq.imports")
public class SpringDebugImportApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDebugImportApplication.class);

        Animal dog = context.getBean(Dog.class);
        Animal cat = context.getBean(Cat.class);

        dog.cry();
        cat.cry();

        MyMapperScannerConfigurer myMapperScannerConfigurer = context.getBean(MyMapperScannerConfigurer.class);
        System.out.println(myMapperScannerConfigurer.getBeanName());

        Account account = context.getBean(Account.class);
        System.out.println(account.getId());

        Employee employee = context.getBean(Employee.class);
        System.out.println(employee);

    }

}
