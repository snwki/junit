package com.snwki.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
public class JunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);
	}

	@Bean
	public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		stringRedisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
		return stringRedisTemplate;
	}
}
