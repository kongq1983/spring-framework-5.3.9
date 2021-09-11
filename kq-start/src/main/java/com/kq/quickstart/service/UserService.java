package com.kq.quickstart.service;

import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author kq
 * @date 2021/9/8 23:54
 * @since 1.0.0
 */
@Service
//@Bean(value = "")
//@Bean({"dataSource", "subsystemA-dataSource", "subsystemB-dataSource"})
public class UserService {

	public void message(){
		System.out.println("UserService Message ! ");
	}

}
