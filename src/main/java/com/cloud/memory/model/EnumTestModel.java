package com.cloud.memory.model;

import com.cloud.memory.common.enums.ProductClassType;
import lombok.Data;

@Data
public class EnumTestModel {

    private String name;
    private ProductClassType productClassType;
}
