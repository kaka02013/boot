package com.lps.boot.cache;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class CacheComponent {

    @Resource
    private Cache<String, Object> caffeineCache;

    @PostConstruct
    public void init() {
        caffeineCache.put("param", 1);
        caffeineCache.put("libra", 2);
        caffeineCache.put("kaka", 3);
        caffeineCache.put("danmei", "dan");
    }
}
