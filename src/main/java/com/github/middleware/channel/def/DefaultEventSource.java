package com.github.middleware.channel.def;

import com.github.middleware.message.MessageData;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: zhangchao
 * @time: 2018-12-21 16:11
 **/
public class DefaultEventSource {

    Set<DefaultEventListenner> defaultEventListenners = new HashSet<>();

    Queue<Msg> queue = new LinkedBlockingQueue();

    public void addDefaultEventListenner(DefaultEventListenner defaultEventListenner){
        defaultEventListenners.add(defaultEventListenner);
    }

    public void clearAll(){defaultEventListenners.clear();}

    public void send(String eventName, MessageData messageData){
        queue.add(new Msg(eventName,messageData));

    }



}

class Msg{
    private String eventName;
    private MessageData messageData;

    public Msg(String eventName, MessageData messageData) {
        this.eventName = eventName;
        this.messageData = messageData;
    }

    public String getEventName() {
        return eventName;
    }

    public MessageData getMessageData() {
        return messageData;
    }
}
