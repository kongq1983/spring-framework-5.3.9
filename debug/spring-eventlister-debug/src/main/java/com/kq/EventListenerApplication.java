package com.kq;

import com.kq.event.LoginEvent;
import com.kq.event.LogouEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * EventListenerMethodProcessor
 * @author kq
 * @date 2021-09-28 10:24
 * @since 2020-0630
 */

@ComponentScan("com.kq")
@Configuration
public class EventListenerApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventListenerApplication.class);

		context.publishEvent(new LoginEvent(10L,new Date()));
		context.publishEvent(new LogouEvent(12L,new Date(),"monitor"));

	}

}
