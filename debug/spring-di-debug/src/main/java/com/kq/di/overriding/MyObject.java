package com.kq.di.overriding;

import org.springframework.stereotype.Component;

/**
 * @author kq
 * @date 2022-09-30 15:29
 * @since 2020-0630
 */
//@Component(value = "myobject")
public class MyObject extends BaseMyObject{

	@Override
	public void print(){
		System.out.println("MyObject");
	}

}
