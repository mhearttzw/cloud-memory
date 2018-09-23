package com.cloud.memory.service.impl;

import com.cloud.memory.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class Java7CalculateServiceImpl implements CalculateService{

    @Override
    public Integer sum(Integer... values) {
        System.out.println("java7 实现");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java7CalculateServiceImpl();
        System.out.println(calculateService.sum(1, 2, 3, 4, 5));

    }
}
