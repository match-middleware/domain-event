package com.github.domainevent.event;

import java.io.Serializable;

/**
 * @author: zhangchao
 * @time: 2018-12-20 10:11
 **/
public interface EventHandler<T extends Serializable> {

    void handler(T t);

    String getEventName();
}
