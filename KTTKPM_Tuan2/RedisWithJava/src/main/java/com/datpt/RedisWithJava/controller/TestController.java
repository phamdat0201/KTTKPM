package com.datpt.RedisWithJava.controller;

import com.datpt.RedisWithJava.model.MessageDto;
import com.datpt.RedisWithJava.service.RedisMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    private RedisMessagingService redisMessagingService;

    @Autowired
    public TestController(RedisMessagingService redisMessagingService) {
        this.redisMessagingService = redisMessagingService;
    }

    @GetMapping("/sub/{channel}")
    public boolean subscribeChannel(@PathVariable("channel") String channel) {
        redisMessagingService.subscribe(channel);
        return true;
    }

    @GetMapping("/pub/str/{channel}/{message}")
    public boolean publishStringMessage(@PathVariable("channel") String channel,
                                        @PathVariable("message") String message) {
        redisMessagingService.publish(channel, message);
        return true;
    }

    @GetMapping("/pub/obj/{channel}/{id}/{name}")
    public boolean publishObject(@PathVariable("channel") String channel,
                                 @PathVariable("id") String id,
                                 @PathVariable("name") String name) {
        MessageDto messageDto = new MessageDto(id, name);
        redisMessagingService.publish(channel, messageDto);
        return true;
    }
}
