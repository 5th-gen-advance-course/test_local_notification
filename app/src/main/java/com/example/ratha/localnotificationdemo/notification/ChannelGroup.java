package com.example.ratha.localnotificationdemo.notification;

/**
 * Created by ratha on 1/26/2018.
 */

public class ChannelGroup  {
    private String id;
    private String name;

    public ChannelGroup() {}

    public ChannelGroup(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
