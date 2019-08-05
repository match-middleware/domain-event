package com.github.middleware.event;

import com.github.middleware.annotation.SubscribeType;
import com.github.middleware.message.MessageType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class EventSubscriber {

    public EventHandler eventHandler;

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void start(MessageType type);

    public abstract void stop();


    public Class<?> getEventDataObjectClass(){
        EventHandler eventHandler = getEventHandler();
        Type type = eventHandler.getClass().getGenericInterfaces()[0];
        if(type instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            Type actualTypeArgument = actualTypeArguments[0];
            return (Class<?>)actualTypeArgument;
        }
        return null;
    }
}
