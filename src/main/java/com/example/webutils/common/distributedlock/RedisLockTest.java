package com.example.webutils.common.distributedlock;

import com.crossoverjie.distributed.lock.redis.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2019/3/8 3:47 PM
 */
@RestController
@Slf4j
public class RedisLockTest {
	@Autowired
	private RedisLock redisLock;

	public void use(int index) {
		String key = "key";
		String request = UUID.randomUUID().toString();
		try {
			boolean locktest = redisLock.tryLock(key, request);
			if (!locktest) {
				log.info("index:{}, 线程：{}，获取分布式锁失败！", index, Thread.currentThread().getName());
				return;
			}

			//do something
			log.info("index:{}, 线程：{}，获取了分布式锁！", index, Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			log.error("try lock error:{}", e);
		} finally {
			log.info("index:{}, 线程：{}，释放了分布式锁！", index, Thread.currentThread().getName());
			redisLock.unlock(key, request);
		}

	}

	@RequestMapping("/redisLock")
	public String redisLock() {
		for (int i = 0; i < 10; i++) {
			int finalI = i;
			new Thread() {
				@Override
				public void run() {
					use(finalI);
				}
			}.start();
		}
		return "redisLock";
	}

}
