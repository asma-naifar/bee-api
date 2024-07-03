package com.bee.and.more.beeapi.redis;

import com.bee.and.more.beeapi.api.model.Bee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.time.Duration;
import java.util.UUID;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisHost);
        redisStandaloneConfiguration.setPort(redisPort);

        JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
        jedisClientConfiguration.connectTimeout(Duration.ofSeconds(60));// 60s connection timeout


        return new JedisConnectionFactory(redisStandaloneConfiguration,
                jedisClientConfiguration.build());
    }

    @Bean
    public RedisTemplate<UUID, Bee> redisTemplate() {
        RedisTemplate<UUID, Bee> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new GenericToStringSerializer<>(UUID.class));
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Bee.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
