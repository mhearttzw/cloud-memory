package com.cloud.memory.service;

import com.cloud.memory.common.annotation.Log;
import com.cloud.memory.common.annotation.MeteredRemoteCall;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/11/21 19:41
 * @description      用款产品管理接口
 */
@FeignClient(name = "feignTestService", url = "${rest.feign.test.url}")
public interface FeignTestService {

    @RequestMapping(value = "/feign/test", method = RequestMethod.GET)
    //@MeteredRemoteCall
    //@Log
    String get();


}
