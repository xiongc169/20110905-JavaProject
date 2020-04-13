package org.practice.redis.ch11.spring_template;

import org.springframework.beans.factory.annotation.Autowired;
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
    private StringRedisTemplate template;

    public void setString(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String getString(String key) {
        String value = template.opsForValue().get(key);
        return value;
    }
}
