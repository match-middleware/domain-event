package com.github.domainevent.event;

import com.github.domainevent.message.MessageType;

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
