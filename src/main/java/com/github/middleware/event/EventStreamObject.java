package com.github.middleware.event;

import com.github.middleware.message.MessageType;

import java.io.Serializable;

/**
 * @Author zhangchao
 * @Date 2019/8/6 13:36
 * @Version v1.0
 */
public interface EventStreamObject extends Serializable {
    MessageType getMessageType();
}
