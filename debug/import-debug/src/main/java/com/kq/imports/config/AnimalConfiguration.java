package com.kq.imports.config;

import com.kq.entity.Account;
import com.kq.imports.registrar.AnimalImportBeanDefinitionRegistrar;
import com.kq.imports.selector.AnimalSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * @author kq
 * @date 2020-10-16 16:35
 * @since 2020-0630
 */
@Configuration
@Import({AnimalSelector.class , AnimalImportBeanDefinitionRegistrar.class})
@ImportResource("xmlbean.xml")
//@Import(AnimalImportBeanDefinitionRegistrar.class)
public class AnimalConfiguration {

    @Bean
    public Account getAccount(){
        Account account = new Account();
        account.setId(1L);
        return account;
    }

}
