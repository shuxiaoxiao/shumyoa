package com.shupro.oa.utils.redis;

import java.util.Deque;
import java.util.List;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;

/**
 * redis工具类-redisson
 *
 * @ClassName: RedissonUtil
 * @author	shuheng
 */
public class RedissonUtil {

    private static Config config = new Config();

    static {
		config.useSingleServer().setConnectionPoolSize(1000).setTimeout(1000*60)
			.setAddress("127.0.0.1:6379");//不链式编写进去便于注释
//			.setAddress("172.16.1.143:6380").setPassword("1qaz2wsx");//测试环境
    }
    private static RedissonClient redissonClient = Redisson.create(config);

	/**
	 * 实例化 RedissonClient对象
	 * @return
	 */
	public static  RedissonClient getInstance() {
		return redissonClient;
	}

	/**
	 * 获得redis list <br>
	 * 增加，删除的操作使用List原生的操作即可
	 * @param key
	 * @return
	 */
	public static List<Object> getList(String key) {
		List<Object> list = getInstance().getList(key);
//		System.out.println("获得redis list："+list);
		return list;
	}
	
	/**
	 * 获取双端队列
	 * @param key
	 * @return
	 */
	public static Deque<Object> getDeque(String key){
		Deque<Object> deque = getInstance().getDeque(key);
		return deque;
	}
	
	/**
	 * 关闭连接
	 * @param
	 */
	public static void shoudown() {
		if (getInstance() != null) {
            getInstance().shutdown();
		}
	}

}

