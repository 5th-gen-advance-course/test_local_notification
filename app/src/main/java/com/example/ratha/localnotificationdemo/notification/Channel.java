package com.example.ratha.localnotificationdemo.notification;

/**
 * Created by ratha on 1/25/2018.
 */

public class Channel {

    private String id;
    private String name;
    private int priority;
    private String desc;

    public Channel() {}

    public Channel(String id, String name, int priority, String desc) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.desc = desc;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
