package com.github.domainevent.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangchao
 * @time: 2019-01-02 17:11
 **/
public class GsonUtils {

    public static String toJsonString(Object object) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyyMMddHHmmssSSS").serializeNulls().create();
        return gson.toJson(object);
    }

    public static Object toObject(String content,Class c){
        Gson gson = new GsonBuilder().disableHtmlEscaping().setLenient().setDateFormat("yyyyMMddHHmmssSSS").serializeNulls().create();
        return  gson.fromJson(content, c);
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("a","fefe fejafwe");
        map.put("date",new Date());
        System.out.println(toJsonString(map));
    }
}
