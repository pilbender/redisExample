package org.raescott.redisexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Example of using the Redis data store.
 *
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BeanFactory beanFactory = applicationContext;
        RedisTemplate<String, String> redisOps = (RedisTemplate<String,String>) beanFactory.getBean("redisOps");
        ListOperations<String, String> listOperations = redisOps.opsForList();

        listOperations.leftPush("name", "Scott Smith");

        String value = listOperations.leftPop("name");
        logger.info("name fetched from Redis: {}", value);
    }
}
