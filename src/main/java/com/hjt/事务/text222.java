package com.hjt.事务;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class text222 {
    public static void main(String[] args) {
        String aa ="abc";
        String bb =aa;
        aa ="abvc";
        System.out.println(bb);
    }
}
