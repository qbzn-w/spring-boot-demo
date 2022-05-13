package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("数据正在处理....");
    }
}
