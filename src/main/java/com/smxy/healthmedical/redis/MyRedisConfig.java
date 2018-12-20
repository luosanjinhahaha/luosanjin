package com.smxy.healthmedical.redis;

import com.smxy.healthmedical.bean.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {
    /**
     * 自定义缓存模板（json）
     * @param
     * @return
     */

    @Bean
    public RedisTemplate<Object, Info> infoRedisTemplate(RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
        RedisTemplate<Object,Info> template = new RedisTemplate<Object, Info>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Info> ser = new Jackson2JsonRedisSerializer<Info>(Info.class);
        template.setDefaultSerializer(ser);
        return template;
    }

    /**
     * 自定义缓存管理器
     */
    @Bean
    @Primary //将其作为默认管理器
    public RedisCacheManager infoCacheManager(RedisTemplate<Object,Info> infoRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(infoRedisTemplate);
        //key多了一个前缀
        //使用前缀，默认会将CacheName作为key的前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
