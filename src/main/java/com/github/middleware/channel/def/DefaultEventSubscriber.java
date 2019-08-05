package com.github.middleware.channel.def;

import com.github.middleware.event.EventSubscriber;
import com.github.middleware.message.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * @author: zhangchao
 * @time: 2018-12-21 15:22
 **/
public class DefaultEventSubscriber extends EventSubscriber {
    private final static Logger log = LoggerFactory.getLogger(DefaultEventSubscriber.class);

    DefaultEventSource defaultEventSource ;

    private boolean running = false;

    public DefaultEventSubscriber(DefaultEventSource defaultEventSource) {
        super();
        this.defaultEventSource = defaultEventSource;
        defaultEventSource.addDefaultEventListenner(new DefaultEventListenner(this));
    }

    @Override
    public void start(MessageType type) {
        this.running = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running){
                    try {
                        Msg poll = defaultEventSource.queue.poll();
                        if(poll != null){
                            Iterator<DefaultEventListenner> iterator = defaultEventSource.defaultEventListenners.iterator();
                            while (iterator.hasNext()){
                                DefaultEventListenner next = iterator.next();
                                next.onEvent(poll.getEventName(),poll.getMessageData());
                            }
                        }
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        this.running = false;
    }
}
