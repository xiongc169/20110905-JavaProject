package org.practice.redis.ch11.spring_template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Desc JedisComponent
 * @Author
 * @Date
 * @Version 1.0
 */
@Component("jedisComponent")
public class JedisComponent {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public void stringRedisTemplateSet(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String stringRedisTemplateGet(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return value;
    }

    public void redisTemplateSet(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String redisTemplateGet(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value.toString();
    }

    public void redisTemplateSet2(String key, String value) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection conn) throws DataAccessException {
                conn.set(redisTemplate.getStringSerializer().serialize(key), redisTemplate.getStringSerializer().serialize(value));
                return null;
            }
        });
    }

    public Object redisTemplateGet2(String key) {
        return redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection conn) throws DataAccessException {
                byte[] keyBytes = redisTemplate.getStringSerializer().serialize(key);
                if (conn.exists(keyBytes)) {
                    byte[] valueBytes = conn.get(keyBytes);
                    Object value = redisTemplate.getStringSerializer().deserialize(valueBytes);
                    return value;
                }
                return null;
            }
        });
    }
}
