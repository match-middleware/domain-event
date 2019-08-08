package com.github.middleware.annotation;


import com.github.middleware.message.MessageType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author zhangchao
 * @Date 2019/8/5 14:43
 * @Version v1.0
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface SubscribeType {

    MessageType type();

}
