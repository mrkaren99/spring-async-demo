package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AService {

    static AtomicInteger count = new AtomicInteger();
    @Async("aTaskExcec")
    public void printA() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String name = Thread.currentThread().getName() + count.getAndIncrement();


        System.out.println(name + " start " + LocalDateTime.now());
        for (long i = 0; i < 50000000; i++) {
            long a = i * i + new Random().nextLong();
        }
//        System.out.println(name + " end " + LocalDateTime.now());

//        System.out.println(name + " | " + count.getAndIncrement());
    }


}
