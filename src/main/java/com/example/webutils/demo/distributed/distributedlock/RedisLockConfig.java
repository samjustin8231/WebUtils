package com.example.webutils.demo.distributed.distributedlock;

import com.crossoverjie.distributed.lock.redis.RedisLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * 类的实现描述：TODO 类实现描述
 *
 * @author sunyajun 2019/3/8 3:44 PM
 */
@Configuration
public class RedisLockConfig {

	public static final String HOST = "127.0.0.1";
	public static final int PORT = 6379;    //redis默认端口

	@Bean
	public RedisLock build() {
		RedisLock redisLock = new RedisLock();
		Jedis jedis = new Jedis(HOST, PORT);
		// Jedis 或 JedisCluster 都可以
		redisLock.setJedis(jedis);
		return redisLock;
	}

}
