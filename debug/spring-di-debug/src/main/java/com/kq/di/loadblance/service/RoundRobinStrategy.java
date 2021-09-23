package com.kq.di.loadblance.service;

import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2021-09-23 18:23
 * @since 2020-0630
 */
@Component
@RoundRobin
public class RoundRobinStrategy implements LoadBalance {

	@Override
	public String select() {
		return "RoundRobinStrategy";
	}
}