package com.github.domainevent.channel.local;

import com.github.domainevent.event.EventSubscriber;
import com.github.domainevent.message.MessageData;
import com.github.domainevent.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.EventListener;

/**
 * @author: zhangchao
 * @time: 2018-12-21 15:59
 **/
public class DefaultEventListenner implements EventListener {
    private final static Logger log = LoggerFactory.getLogger(DefaultEventSubscriber.class);
    private EventSubscriber eventSubscriber;

    public DefaultEventListenner(EventSubscriber eventSubscriber) {
        this.eventSubscriber = eventSubscriber;
    }


    public void onEvent(String eventName, MessageData obj){
        if(eventName.equals(eventSubscriber.getEventHandler().getEventName())){
            try {
                eventSubscriber.getEventHandler().handler(obj.getData());
            } catch (Exception e) {
                log.error("事件[{}]消费失败:{}",eventName,  GsonUtils.toJsonString(obj));
            }
        }
    }


}
