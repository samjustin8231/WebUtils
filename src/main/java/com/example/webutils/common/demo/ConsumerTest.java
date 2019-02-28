package com.example.webutils.common.demo;

import java.util.function.Consumer;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2019/2/27 6:23 PM
 */
public class ConsumerTest {
	public static void main(String[] args) {
		Consumer consumer = x -> System.out.println(x);
		consumer.accept(1);
	}
}
