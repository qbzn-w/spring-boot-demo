package com.example.demo.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *编写工具类，这里的@Component注解不能丢，否则jedisPool为空，
 */
@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    /**
     *  得到对应键的字符串值
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        }  finally {
            returnToPool(jedis);
        }
    }
    public String set(String key,String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.set(key,value);
        }  finally {
            returnToPool(jedis);
        }
    }



    /**
     * 判断key是否存在
     */
    public <T> boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 删除
     */
    public boolean delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.del(key);
            return ret > 0;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     * 删除指定库中单值
     */
    public boolean delete(String key,int database) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.select(database);
            long ret = jedis.del(key);
            return ret > 0;
        } finally {
            returnToPool(jedis);
        }
    }

    /**
     *  删除一组数据
     */
    public boolean deletes(String[] keys) {
        boolean deletes = true;
        for (String key : keys) {
            boolean delete = delete(key);
            if (!delete) {
                deletes = false;
            }
        }
        return deletes;
    }
    /**
     * 修改数据
     */
    public boolean update(String key, String value) {
        Jedis jedis = null;
        if (jedis.exists(key)) {
            jedis.set(key, value);
            if (value.equals(jedis.get(key))) {
                System.out.println("修改数据成功");
                return true;
            } else {
                System.out.println("修改数据失败");
                return false;
            }
        } else {
            System.out.println(key + "不存在");
            System.out.println("若要新增数据请使用set()方法");
            return false;
        }
    }


    /**
     * 关闭jedis
     * @param jedis
     */
    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }





}
