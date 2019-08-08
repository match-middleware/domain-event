
package com.github.middleware.channel;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-25 14:59
 **/
public abstract class ChannelConfig {
    private static final String DEFAULT_NAMESPANCE = "DEFAULT_STREAM";
    private Properties properties;
    private String namespance;

    public ChannelConfig(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getNamespance() {
        if(namespance == null){
            namespance = DEFAULT_NAMESPANCE;
        }
        return namespance;
    }

    public void setNamespance(String namespance) {
        this.namespance = namespance;
    }
}
