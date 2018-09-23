package com.cloud.memory.controller;

import com.cloud.memory.common.annotation.Log;
import com.cloud.memory.common.annotation.MeteredRemoteCall;
import com.cloud.memory.service.FeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FeignTestController {

    @Autowired
    private FeignTestService feignTestService;



    @GetMapping("/feign/test")
    public String feignTest() {

        return feignTestService.get();
    }


}
