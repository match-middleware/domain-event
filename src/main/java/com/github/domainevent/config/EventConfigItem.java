package com.github.domainevent.config;

import com.github.domainevent.channel.ChannelProvider;
import com.github.domainevent.message.MessageType;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:05
 **/
public class EventConfigItem {

    private ChannelProvider channelProvider;
    private String eventName;
    private MessageType messageType;

    public ChannelProvider getChannelProvider() {
        return channelProvider;
    }

    public void setChannelProvider(ChannelProvider channelProvider) {
        this.channelProvider = channelProvider;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
