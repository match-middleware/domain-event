package com.github.middleware.message;

import com.github.middleware.utils.GsonUtils;

import java.util.UUID;

/**
 * @author: zhangchao
 * @time: 2018-12-21 10:59
 **/
public class MessageData{

    private String messageId;
    private String data;

    public MessageData() {
    }


    public static MessageData createMessageData(Object data){
        MessageData messageData = new MessageData();
        messageData.setData(GsonUtils.toJsonString(data));
        messageData.setMessageId(UUID.randomUUID().toString());
        return messageData;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
