package com.example.multithread.demo.day01;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        System.out.println(i.addAndGet(2));
    }
}
