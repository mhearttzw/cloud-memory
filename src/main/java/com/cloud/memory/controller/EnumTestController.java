package com.cloud.memory.controller;

import com.alibaba.fastjson.JSONObject;
import com.cloud.memory.common.enums.BusinessCode;
import com.cloud.memory.common.enums.ProductClassType;
import com.cloud.memory.model.EnumTestModel;
import com.cloud.memory.model.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/enum")
public class EnumTestController {

    @RequestMapping("/test")
    public JsonResult enumTest(@RequestParam("name") String name,
                               @RequestParam("enum") ProductClassType productClassType) {
        EnumTestModel enumTestModel = new EnumTestModel();
        enumTestModel.setName(name);
        enumTestModel.setProductClassType(productClassType);
        return new JsonResult(BusinessCode.SUCCESS,  JSONObject.toJSONString(enumTestModel));
    }
}
