package com.example.SpringAOP.dao.service;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        
        // simulate a delay
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // return a fortune
        return "Expect heavy traffic this morning";

    }

    @Override
    public String getFortune(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }
        
        return getFortune();

    }

}
