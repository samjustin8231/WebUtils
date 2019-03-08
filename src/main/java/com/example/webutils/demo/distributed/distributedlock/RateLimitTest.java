package com.example.webutils.demo.distributed.distributedlock;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 类的实现描述：Guava限流demo
 * 适用于单体应用，分布式应用得用redis来实现。
 *
 * @author sunyajun 2019/3/8 3:30 PM
 */
public class RateLimitTest {
	public static void main(String[] args) {
		testNoRateLimiter();
		testWithRateLimiter();
	}

	public static void testNoRateLimiter() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			System.out.println("call execute.." + i);

		}
		Long end = System.currentTimeMillis();

		System.out.println(end - start);

	}

	public static void testWithRateLimiter() {
		Long start = System.currentTimeMillis();
		RateLimiter limiter = RateLimiter.create(10.0); // 每秒不超过10个任务被提交
		for (int i = 0; i < 10; i++) {
			limiter.acquire(); // 请求RateLimiter, 超过permits会被阻塞
			System.out.println("call execute.." + i);

		}
		Long end = System.currentTimeMillis();

		System.out.println(end - start);

	}


}
