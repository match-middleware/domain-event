package com.github.domainevent.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author zhangchao
 * @Date 2019/8/5 17:49
 * @Version v1.0
 */
public class JDKTypeUtils {


    /**
     * 判断object是否为基本类型
     *
     * @param object
     * @return
     */
    public static boolean isBaseType(Object object) {
        Class className = object.getClass();
        if (className.equals(java.lang.Integer.class) ||
                className.equals(java.lang.Byte.class) ||
                className.equals(java.lang.Long.class) ||
                className.equals(java.lang.Double.class) ||
                className.equals(java.lang.Float.class) ||
                className.equals(java.lang.Character.class) ||
                className.equals(java.lang.Short.class) ||
                className.equals(java.lang.Boolean.class)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为基本类型的默认值
     *
     * @param object
     * @return
     */
    public static boolean isBaseDefaultValue(Object object) {
        Class className = object.getClass();
        String strClassName = "" + className;
        if (className.equals(java.lang.Integer.class)) {
            return (int) object == 0;
        } else if (className.equals(java.lang.Byte.class)) {
            return (byte) object == 0;
        } else if (className.equals(java.lang.Long.class)) {
            return (long) object == 0L;
        } else if (className.equals(java.lang.Double.class)) {
            return (double) object == 0.0d;
        } else if (className.equals(java.lang.Float.class)) {
            return (float) object == 0.0f;
        } else if (className.equals(java.lang.Character.class)) {
            return (char) object == '\u0000';
        } else if (className.equals(java.lang.Short.class)) {
            return (short) object == 0;
        } else if (className.equals(java.lang.Boolean.class)) {
            return (boolean) object == false;
        }
        return false;
    }

    public static Class<?> getEventDataObjectClass(Class clazz) {
        Type type = clazz.getGenericInterfaces()[0];
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            return (Class<?>) actualTypeArgument;
        }
        return null;
    }


    public static Class<?> getParentClassObjectClass(Class clazz) {
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            return (Class<?>) actualTypeArgument;
        }
        return null;
    }

}

