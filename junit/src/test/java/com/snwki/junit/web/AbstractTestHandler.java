package com.snwki.junit.web;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import redis.embedded.RedisServer;

import java.io.IOException;

public class AbstractTestHandler {

    private static RedisServer redisServer = null;

    @BeforeClass
    public static void beforeClass() {
        try {
            redisServer = new RedisServer(6379);
        } catch (IOException e) {
            System.out.println("redis server start failed :{}" + e.getMessage());
            return;
        }
        redisServer.start();
    }

    @AfterClass
    public static void afterClass() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}
