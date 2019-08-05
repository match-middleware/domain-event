package com.github.middleware.channel.def;

import com.github.middleware.channel.ChannelProvider;
import com.github.middleware.event.EventSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:26
 **/
public class DefaultChannelProvider extends ChannelProvider<DefaultChannelConfig> {
    private final static Logger log = LoggerFactory.getLogger(DefaultChannelProvider.class);

    private DefaultEventSource defaultEventSource = new DefaultEventSource();

    public DefaultChannelProvider() {
        this(null);
    }

    public DefaultChannelProvider(DefaultChannelConfig channelConfig) {
        super(channelConfig);
    }


    @Override
    public void init() {
            log.debug("init DefaultChannelProvider");
    }


    @Override
    public EventSubscriber createEventSubscriber() {
        return new DefaultEventSubscriber(defaultEventSource);
    }

    @Override
    public DefaultEventPublish createEventPublish() {
        return new DefaultEventPublish(defaultEventSource,this);
    }
}
