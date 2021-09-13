package com.kq.staticbean.config;


import com.kq.staticbean.service.AliasService;
import com.kq.staticbean.service.OtherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "com.kq.staticbean")
@Configuration
public class AppConfig {


//	@Bean // 不指定 beanName=MethodName=getAliasService
	@Bean({"aliasService", "aliasService1", "aliasService2"})
	public static AliasService getAliasService(){
		return new AliasService();
	}

//	//重名
//	@Bean({"aliasService"})
////	@Bean({"userService"})
//	public static OtherService getOtherService(){
//		return new OtherService();
//	}

}
