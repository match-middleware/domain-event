package com.github.middleware;


import com.github.middleware.channel.ChannelProvider;
import com.github.middleware.config.EventConfigItem;
import com.github.middleware.config.EventConfigManager;
import com.github.middleware.event.EventHandler;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:09
 **/
public abstract class EventStream {

    private EventStream() {
    }

    public static void publish(String eventName, Object object){
        EventConfigItem eventConfigItem = EventConfigManager.get(eventName);
        ChannelProvider channelProvider = eventConfigItem.getChannelProvider();
        channelProvider.sendMessage(eventName,object);
    }

    public static void register(EventHandler handler){
        EventConfigItem eventConfigItem = EventConfigManager.get(handler.getEventName());
        ChannelProvider channelProvider = eventConfigItem.getChannelProvider();
        channelProvider.subscriber(handler);
    }

}
