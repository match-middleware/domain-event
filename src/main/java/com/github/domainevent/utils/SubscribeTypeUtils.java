package com.github.domainevent.utils;

import com.github.domainevent.annotation.SubscribeType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author zhangchao
 * @Date 2019/8/8 11:13
 * @Version v1.0
 */
public abstract class SubscribeTypeUtils {

    public static SubscribeType findSubScribeType(Class clazz){
        Type genericInterface = clazz.getGenericInterfaces()[0];
        if(genericInterface instanceof ParameterizedType){
            ParameterizedType parameterizedType  = (ParameterizedType)genericInterface;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                Class typeArgument = (Class) actualTypeArgument;
                if(typeArgument.isAnnotationPresent(SubscribeType.class)){
                    return (SubscribeType)typeArgument.getAnnotation(SubscribeType.class);
                }
            }
        }
        return null;
    }
}
