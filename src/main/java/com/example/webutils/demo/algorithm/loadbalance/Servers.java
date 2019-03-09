package com.example.webutils.demo.algorithm.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 类的实现描述：Servers
 *
 * @author sunyajun 2019/3/9 3:22 PM
 */
public class Servers {
	public List<String> list = new ArrayList<String>() {
		{
			add("192.168.1.1");
			add("192.168.1.2");
			add("192.168.1.3");
		}
	};

	public HashMap<String, Integer> map = new HashMap<String, Integer>() {
		{
			put("192.168.1.1", 2);
			put("192.168.1.2", 7);
			put("192.168.1.3", 1);
		}
	};
}

