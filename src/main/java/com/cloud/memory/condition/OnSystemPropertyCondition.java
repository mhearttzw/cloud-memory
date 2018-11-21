package com.cloud.memory.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/11/21 10:58
 * @description      系统属性判断
 */
public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> attributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        return false;
    }
}
