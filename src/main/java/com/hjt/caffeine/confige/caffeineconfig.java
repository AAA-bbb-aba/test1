package com.hjt.caffeine.confige;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class caffeineconfig {
@Bean
public Cache<String,String> caffeinebean() {
    return Caffeine.newBuilder().maximumSize(1000).build();
}

}
