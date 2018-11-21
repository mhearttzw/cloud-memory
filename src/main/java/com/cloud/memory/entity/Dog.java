package com.cloud.memory.entity;

import lombok.Data;

/**
 * @author 明明如月
 * @date 2018/08/27
 */
@Data
public class Dog {
 
    private String name;
 
    private String color;
 
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
