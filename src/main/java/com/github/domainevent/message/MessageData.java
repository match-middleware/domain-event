package com.github.domainevent.message;

import com.github.domainevent.annotation.SubscribeType;
import com.github.domainevent.utils.GsonUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-12-21 10:59
 **/
public class MessageData{

    private String messageId;
    private MessageType messageType;
    private Date sendTime;
    private String data;

    public MessageData() {
    }


    public static MessageData createMessageData(Object data){
        MessageData messageData = new MessageData();
        messageData.setData(GsonUtils.toJsonString(data));
        messageData.setSendTime(new Date());
        messageData.setMessageType(findMessageType(data.getClass()));
        messageData.setMessageId(UUID.randomUUID().toString());
        return messageData;
    }


    private static  MessageType findMessageType(Object data){
        MessageType messageType = MessageType.getDefault();
        SubscribeType annotation = (SubscribeType)((Class) data).getAnnotation(SubscribeType.class);
        if(annotation != null){
            return annotation.type();
        }
        return messageType;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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
