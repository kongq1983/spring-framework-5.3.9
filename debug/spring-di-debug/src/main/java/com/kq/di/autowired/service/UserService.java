package com.kq.di.autowired.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2022-07-15 10:01
 * @since 2020-0630
 */
@Lazy
@Component
public class UserService {


	public void message() {
		System.out.println("this="+this);
	}


}
