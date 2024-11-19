package com.redistest.RedisTestApp.ServiceTest;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service

@Slf4j
public class Service {

    @Cacheable(value = "message", key = "#id")
    public String returnMessage(int id){
        log.info("Returning Message");
        return "Hello World";
    }

    @CachePut(value = "message", key = "#id")
    public String updateMessage(int id, String message){
        log.info("Updating Message");
        return message;
    }
}
