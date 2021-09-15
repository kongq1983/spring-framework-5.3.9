package com.kq.imports.service.impl;

import com.kq.imports.service.Animal;

/**
 * @author kq
 * @date 2020-10-16 16:30
 * @since 2020-0630
 */
public class Dog implements Animal {

    @Override
    public void cry() {
        System.out.println("wang,wang,wang");

    }
}
