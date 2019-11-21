package com.github.domainevent;


import com.github.domainevent.channel.ChannelProvider;
import com.github.domainevent.config.EventConfigItem;
import com.github.domainevent.config.EventConfigManager;
import com.github.domainevent.event.EventHandler;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:09
 **/
public abstract class DomianEvent {

    private DomianEvent() {
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
