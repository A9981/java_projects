package com.demo.redisapp.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public JedisConnectionFactory connectionFactory(){
        RedisStandaloneConfiguration configure=new RedisStandaloneConfiguration();
        configure.setHostName("localhost");
        configure.setPort(6379);
        return new JedisConnectionFactory(configure);
    }
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(connectionFactory());
        stringRedisTemplate.setEnableTransactionSupport(true);
        return stringRedisTemplate;
    }
}
