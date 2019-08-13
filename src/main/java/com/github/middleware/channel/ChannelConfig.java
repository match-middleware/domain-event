
package com.github.middleware.channel;

import java.util.Properties;

/**
 * @author: zhangchao
 * @time: 2018-12-25 14:59
 **/
public abstract class ChannelConfig {
    private static final String DEFAULT_NAMESPANCE = "DEFAULT_STREAM";
    private Properties properties;
    private String applicationId;

    public ChannelConfig(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public String getApplicationId() {
        if(this.applicationId == null || "".equals(applicationId)){
            this.applicationId = DEFAULT_NAMESPANCE;
        }
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
