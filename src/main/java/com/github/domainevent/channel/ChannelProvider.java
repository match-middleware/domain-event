package com.github.domainevent.channel;

import com.github.domainevent.annotation.SubscribeType;
import com.github.domainevent.event.EventHandler;
import com.github.domainevent.event.EventPublish;
import com.github.domainevent.event.EventSubscriber;
import com.github.domainevent.message.MessageData;
import com.github.domainevent.message.MessageType;
import com.github.domainevent.utils.SubscribeTypeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 通道提供者
 * @author: zhangchao
 * @time: 2018-12-21 10:57
 **/
public abstract class ChannelProvider<T extends ChannelConfig> {


    private T channelConfig;

    public MessageType type;


    public ChannelProvider(T channelConfig) {
        this.channelConfig = channelConfig;
    }

    public Set<EventSubscriber> subscriberSet = new HashSet<>();

    public void sendMessage(String eventName, Object data){
        EventPublish eventPublish = createEventPublish();

        MessageData messageData = MessageData.createMessageData(data);
        this.type = messageData.getMessageType();

        eventPublish.setMessageData(messageData);
        eventPublish.setEventName(eventName);
        eventPublish.publishMessage();
    }


    public void subscriber(EventHandler eventHandler){
        EventSubscriber eventSubscriber = createEventSubscriber();
        eventSubscriber.setEventHandler(eventHandler);
        SubscribeType annotation = SubscribeTypeUtils.findSubScribeType(eventHandler.getClass());
        type = MessageType.getDefault();
        if(annotation != null){
            type = annotation.type();
        }
        eventSubscriber.start(type);
        subscriberSet.add(eventSubscriber);
    }

    public void stop(){
        subscriberSet.stream().forEach(item -> item.stop());
    }

    public abstract void init();

    public MessageType getType() {
        return type;
    }

    public abstract EventSubscriber createEventSubscriber();

    public abstract EventPublish createEventPublish();


    public T getChannelConfig() {
        return channelConfig;
    }

    public void setChannelConfig(T channelConfig) {
        this.channelConfig = channelConfig;
    }



}