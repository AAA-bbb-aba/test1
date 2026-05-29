package com.hjt.guava.listener;

import com.google.common.eventbus.Subscribe;

public class guavalistener {
    @Subscribe
    public void listen(String event){
        System.out.println("event:"+event);
    }
}
