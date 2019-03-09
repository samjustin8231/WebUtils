package com.example.webutils.demo.algorithm.loadbalance;

import java.util.Random;

/**
 * 类的实现描述：完全随机算法
 *
 * @author sunyajun 2019/3/9 3:22 PM
 */
public class FullRandom {
	static Random random = new Random();
	static Servers servers = new Servers();

	public static String go() {
		Integer number = random.nextInt(servers.list.size());
		return servers.list.get(number);
	}

	public static void main(String[] args) {
		for (Integer i = 0; i < 15; i++) {
			System.out.println(go());
		}
	}
}
