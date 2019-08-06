package com.github.middleware.message;

import com.github.middleware.annotation.SubscribeType;
import com.github.middleware.event.EventStreamObject;
import com.github.middleware.utils.GsonUtils;

import java.lang.reflect.Type;
import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-12-21 10:59
 **/
public class MessageData{

    private String messageId;
    private MessageType messageType;
    private String data;

    public MessageData() {
    }


    public static MessageData createMessageData(Object data){
        MessageData messageData = new MessageData();
        messageData.setData(GsonUtils.toJsonString(data));
        messageData.setMessageType(findMessageType(data.getClass()));
        messageData.setMessageId(UUID.randomUUID().toString());
        return messageData;
    }


    private static  MessageType findMessageType(Object data){
        MessageType messageType = MessageType.P2M;
        SubscribeType annotation = data.getClass().getAnnotation(SubscribeType.class);
        if(annotation != null){
            return annotation.type();
        }
        Type[] types = data.getClass().getInterfaces();
        for (Type type : types) {
            if(type.getTypeName().equals(EventStreamObject.class.getTypeName())){
                return ((EventStreamObject)data).getMessageType();
            }
        }
        return messageType;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
