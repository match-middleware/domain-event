package com.github.domainevent.channel.local;

import com.github.domainevent.event.EventPublish;
import com.github.domainevent.utils.GsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zhangchao
 * @time: 2018-12-21 11:27
 **/
public class DefaultEventPublish extends EventPublish {

    private final static Logger log = LoggerFactory.getLogger(DefaultEventPublish.class);
    DefaultEventSource defaultEventSource;
    public DefaultEventPublish(DefaultEventSource defaultEventSource, DefaultChannelProvider defaultChannelProvider) {
        super(defaultChannelProvider);
        this.defaultEventSource = defaultEventSource;
    }

    @Override
    public void publishMessage() {
        log.debug("publishMessage:{}:{}",getEventName(), GsonUtils.toJsonString(getMessageData()));
        defaultEventSource.send(getEventName(),getMessageData());
    }

}
