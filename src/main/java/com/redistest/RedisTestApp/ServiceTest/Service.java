package com.redistest.RedisTestApp.ServiceTest;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service

@Slf4j
@RequiredArgsConstructor
public class Service {
    private final ApplicationContext applicationContext;

    @Cacheable(value = "message", key = "#id")
    public String returnMessage(int id){
        log.info("Returning Message");
        return "Hello World";
    }

    public String updateMessage(int id, String message){
        log.info("Updating Message");
        Service proxy = applicationContext.getBean(Service.class);
        return proxy.updateMessageCache(id, message);
    }

    @CachePut(value = "message", key = "#id")
    public String updateMessageCache(int id, String message){
        log.info("Updating Message");
        return message;
    }
}
