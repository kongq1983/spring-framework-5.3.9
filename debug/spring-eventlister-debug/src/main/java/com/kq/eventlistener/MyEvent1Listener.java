package com.kq.eventlistener;

import com.kq.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-28 10:23
 * @since 2020-0630
 */

@Component
public class MyEvent1Listener {

	@EventListener
	public void notifyMessage(LoginEvent loginEvent){
		System.out.println("MyEvent1Listener 收到消息:"+loginEvent);
	}
}
