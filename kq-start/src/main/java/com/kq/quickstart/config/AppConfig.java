package com.kq.quickstart.config;


import com.kq.quickstart.service.AliasService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.kq.quickstart")
public class AppConfig {


	@Bean // 不指定 beanName=MethodName=getAliasService
//	@Bean({"aliasService", "aliasService1", "aliasService2"})
	public AliasService getAliasService(){
		return new AliasService();
	}

}
