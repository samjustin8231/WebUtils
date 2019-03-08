package com.example.webutils.demo.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2019/3/7 4:12 PM
 */
@Slf4j
public class ExecutorsDemo {
	private static ExecutorService executor = Executors.newFixedThreadPool(15);
	private static ExecutorService executor1 = new ThreadPoolExecutor(10, 10,
			60L, TimeUnit.SECONDS,
			new ArrayBlockingQueue(10));

	public static void main(String[] args) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
				executor.execute(new SubThread());
			} catch (Exception e) {
				// slf4j打印日志示例
				log.info("出错了！getMessage:{}", e.getMessage());
				log.info("出错了！getStackTrace:{}", e.getStackTrace());
				log.info("出错了！e:{}", e);

			}
		}
	}
}

class SubThread implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			//do nothing
		}
	}
}

