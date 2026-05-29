package com.hjt;

import com.github.benmanes.caffeine.cache.Cache;
import com.google.common.eventbus.AsyncEventBus;
import com.hjt.guava.listener.guavalistener;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class test {
@Resource
private Cache<String,String> caffeinebean;

@Resource
private AsyncEventBus asyncEventBus;


    @Test
    public void test1() {
        caffeinebean.put("aa","aa");
        System.out.println(caffeinebean.getIfPresent("aa"));

    }

    @Test
    public void test2() {
        asyncEventBus.register(new guavalistener());
        asyncEventBus.post("aa");
    }

    @Test
    public void test4() {
        String aa ="abc";
        String bb =aa;
        aa ="abvc";
        System.out.println(bb);
    }

}
