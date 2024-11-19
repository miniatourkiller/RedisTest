package com.redistest.RedisTestApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.redistest.RedisTestApp.ServiceTest.Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final Service service;
    
    @GetMapping("get-message/{messageId}")
    public String getMessage(@PathVariable int messageId){
        return service.returnMessage(messageId);
    }

    @GetMapping("update-message/{messageId}/{message}")
    public String updateMessage(@PathVariable int messageId, @PathVariable String message){
        return service.updateMessage(messageId, message);
    }
}
