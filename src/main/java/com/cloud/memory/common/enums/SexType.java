package com.cloud.memory.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 15:40
 * @description      性别枚举类
 */
@Getter
@AllArgsConstructor
public enum SexType implements BaseEnum<Integer> {
    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女"),;

    private Integer code;
    private String desc;

    public static class Convert extends BaseEnumConverter<SexType, Integer> {

    }
}
