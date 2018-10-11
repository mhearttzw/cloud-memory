package com.cloud.memory.common.enums;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 15:35
 * @description      基础枚举类
 */
public interface BaseEnum<Y>{
    /**
     * 存取到数据库中的值.
     *
     * @return
     */
    Y getCode();

}
