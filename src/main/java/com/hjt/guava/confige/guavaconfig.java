package com.hjt.guava.confige;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class guavaconfig {
@Bean
public AsyncEventBus asyncEventBus(){
    return new AsyncEventBus(Executors.newFixedThreadPool(5));
}
}
