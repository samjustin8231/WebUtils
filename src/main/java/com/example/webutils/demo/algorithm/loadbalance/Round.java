package com.example.webutils.demo.algorithm.loadbalance;

import java.util.Map;

/**
 * 类的实现描述：轮询
 *
 * @author sunyajun 2019/3/9 3:35 PM
 */
public class Round {

	static Servers servers = new Servers();
	static int index;

	/**
	 * 完全轮询
	 *
	 * @return
	 */
	public static String funRound() {
		if (index == servers.list.size()) {
			index = 0;
		}
		return servers.list.get(index++);
	}

	/**
	 * 加权轮询
	 *
	 * @return
	 */
	public static String weightRound() {
		int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
		int number = (index++) % allWeight;
		for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
			if (item.getValue() > number) {
				return item.getKey();
			}
			number -= item.getValue();
		}
		return "";
	}

	public static void main(String[] args) {
		for (Integer i = 0; i < 15; i++) {
			System.out.println(weightRound());
		}
	}
}

