package com.datpt.RedisWithJava.service;

public interface RedisMessagingService {
    Long publish(String channel, Object object);

    Long publish(String channel, String message);

    void subscribe(String... channels);
}
