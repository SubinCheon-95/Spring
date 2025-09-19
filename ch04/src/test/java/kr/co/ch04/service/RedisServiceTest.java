package kr.co.ch04.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.AccessType;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    void setValue() {
        String key = "user1:a101:name";
        String value = "김유신";

        redisService.setValue(key, value);

    }

    @Test
    void getValue() {
    }

    @Test
    void addToListFromRight() {
    }

    @Test
    void addToListFromLeft() {
    }

    @Test
    void getFromList() {
    }

    @Test
    void getRangeFromList() {
    }

    @Test
    void addToSet() {
    }

    @Test
    void getFromSet() {
    }

    @Test
    void addToHash() {
    }

    @Test
    void getFromHash() {
    }
}