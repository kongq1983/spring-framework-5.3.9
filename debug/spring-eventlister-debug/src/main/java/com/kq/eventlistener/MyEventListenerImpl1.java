package com.kq.eventlistener;

import com.kq.event.LogouEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * @author kq
 * @date 2021-09-28 14:53
 * @since 2020-0630
 */

@Component
public class MyEventListenerImpl1 implements ApplicationListener<LogouEvent> {


	@Override
	public void onApplicationEvent(LogouEvent event) {
		System.out.println("MyEventListenerImpl1:"+event);
	}
}
