package com.kq.staticbean.config;


import com.kq.staticbean.service.OtherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "com.kq.staticbean")
@Configuration
public class AppConfig1 {



	//重名
	@Bean({"aliasService"})
//	@Bean({"userService"})
	public static OtherService getOtherService(){
		return new OtherService();
	}

}
