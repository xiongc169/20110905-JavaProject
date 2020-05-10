package org.practice.springfx.book03.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Desc FirstCondition
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年8月20日
 * <p>
 * @Version 1.0
 */
public class FirstCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}
