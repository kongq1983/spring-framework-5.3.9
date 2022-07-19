package com.kq.quickstart;

import java.util.ArrayList;
import java.util.List;

/**
 * TestMemory
 *
 * @author kq
 * @date 2021/10/15 23:39
 * @since 1.0.0
 */
public class TestMemory {

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			str.add(String.valueOf(i).intern());
		}
	}

}
