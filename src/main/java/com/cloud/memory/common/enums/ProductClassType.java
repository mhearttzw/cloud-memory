package com.cloud.memory.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangyanglei
 * 产品大类枚举类
 */
@Getter
@AllArgsConstructor
public enum ProductClassType implements BaseEnum<Long> {
    /**
     * 默认值
     */
    UNKNOWN(0L, "未知"),
    /**
     * 盈益
     */
    YING_YI(1L, "盈益"),
    /**
     * 汇晟
     */
    HUI_SHENG(2L, "汇晟"),;
    private Long code;
    private String desc;

}
