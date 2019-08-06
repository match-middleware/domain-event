package com.github.middleware.event;

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
}
