package com.bee.and.more.beeapi.service;

import com.bee.and.more.beeapi.api.model.Bee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeeService {

    private final RedisTemplate<UUID, Bee> redisTemplate;

    @Autowired
    public BeeService(RedisTemplate<UUID, Bee> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveBee(Bee bee) {
        redisTemplate.opsForValue().set(bee.getId(), bee);
    }

    public Bee getBeeById(UUID id) {
        return redisTemplate.opsForValue().get(id);
    }
}
