package com.github.middleware.message;

/**
 * @Author zhangchao
 * @Date 2019/8/5 15:02
 * @Version v1.0
 */
public enum  MessageType {
    PRODUCERS_AND_CONSUMERS,//生产者和消费者
    PUBLISH_SUBSCRIBE; // 发布订阅


    public static MessageType getDefault(){return MessageType.PUBLISH_SUBSCRIBE;}
}
