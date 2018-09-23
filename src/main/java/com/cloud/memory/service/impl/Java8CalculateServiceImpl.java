package com.cloud.memory.service.impl;

import com.cloud.memory.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Profile("pro")
@Service
public class Java8CalculateServiceImpl implements CalculateService{

    @Override
    public Integer sum(Integer... values) {
        System.out.println("java8 实现");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateServiceImpl();
        System.out.println(calculateService.sum(1, 2, 3, 4, 5));

    }
}
