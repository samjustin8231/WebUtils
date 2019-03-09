package com.example.webutils.demo.algorithm.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 类的实现描述：加权随机
 *
 * @author sunyajun 2019/3/9 3:27 PM
 */
public class WeightRandom {

	static Servers servers = new Servers();
	static Random random = new Random();

	/**
	 * 加权随机方法1，有缺点，如果我几台服务器权重设置的都很大，比如上千，上万，那么服务器List也有上万条数据，这不是白白占用内存吗？
	 *
	 * @return
	 */
	public static String go1() {
		List<String> ipList = new ArrayList<String>();
		for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
			for (Integer i = 0; i < item.getValue(); i++) {
				ipList.add(item.getKey());
			}
		}
		int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
		Integer number = random.nextInt(allWeight);
		return ipList.get(number);
	}

	/**
	 * 加权随机方法2，这种实现方式虽然相对第一种实现方式比较“绕”，但却是一种比较好的实现方式， 对内存没有浪费，权重大小和服务器List的Size也没有关系。
	 * @return
	 */
	public static String go2() {
		int allWeight = servers.map.values().stream().mapToInt(a -> a).sum();
		Integer number = random.nextInt(allWeight);
		for (Map.Entry<String, Integer> item : servers.map.entrySet()) {
			if (item.getValue() >= number) {
				return item.getKey();
			}
			number -= item.getValue();
		}
		return "";
	}

	public static void main(String[] args) {
		for (Integer i = 0; i < 15; i++) {
			System.out.println(go2());
		}
	}
}
