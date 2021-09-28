package com.kq.eventlistener;

import com.kq.event.LoginEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-28 10:13
 * @since 2020-0630
 */

@Component
public class MyEventListener {


	@EventListener
	public void notifyMessage(LoginEvent loginEvent){
		System.out.println("MyEventListener 收到消息:"+loginEvent);
	}

}
