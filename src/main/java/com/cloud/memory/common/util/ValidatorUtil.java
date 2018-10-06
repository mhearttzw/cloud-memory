package com.cloud.memory.common.util;

import com.cloud.memory.common.exceptions.ParamException;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/6 18:58
 * @description      验证工具类
 */
@Slf4j
public class ValidatorUtil {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validateObj(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> validateResult = validator.validate(t, groups);
        LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
        if (!validateResult.isEmpty()) {
            validateResult.forEach(s -> {
                errors.put(s.getPropertyPath().toString(), s.getMessage());
            });
        }
        if (MapUtils.isNotEmpty(errors)) {
            throw new ParamException(errors.toString());
        }
    }

    public static <T> void validateList(List<T> list, Class<?>... groups) {
        LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
        list.forEach(l -> {
            Set<ConstraintViolation<T>> validateResult = validator.validate(l, groups);
            if (!validateResult.isEmpty()) {
                validateResult.forEach(s -> {
                    errors.put(s.getPropertyPath().toString(), s.getMessage());
                });
            }
        });
        if (MapUtils.isNotEmpty(errors)) {
            throw new ParamException(errors.toString());
        }
    }
}
