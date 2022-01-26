package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 创建一个生成JedisPool的工厂
 */
@Configuration
public class JedisPoolFactory {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Value("${redis.password}")
    private String password;

    @Value("${redis.timeout}")
    private int timeout;

    @Value("${redis.max-active}")
    private int maxActive;

    @Value("${redis.max-idle}")
    private int maxIdle;

    @Value("${redis.min-idle}")
    private int minIdle;

    @Value("${redis.max-wait}")
    private long maxWaitMillis;


    @Bean
    public JedisPool generateJedisPoolFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWaitMillis);
        //指定第6个库
        JedisPool jedisPool = new JedisPool(poolConfig, host, port, timeout, password, 0);
        return jedisPool;
    }


}