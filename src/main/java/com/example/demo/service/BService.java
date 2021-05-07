package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BService {

    static AtomicInteger count = new AtomicInteger();

    @Async("bTaskExcec")
    public void printB() {

        String name = Thread.currentThread().getName() + count.getAndIncrement();


        System.out.println(name + " start " + LocalDateTime.now());
        for (long i = 0; i < 5000000; i++) {
            long a = i * i + new Random().nextLong();
        }
    }

}
