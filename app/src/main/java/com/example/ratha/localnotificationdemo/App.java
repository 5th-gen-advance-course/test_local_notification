package com.example.ratha.localnotificationdemo;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.NotificationManager;
import android.os.Build;

import com.example.ratha.localnotificationdemo.notification.Channel;
import com.example.ratha.localnotificationdemo.notification.ChannelGroup;
import com.example.ratha.localnotificationdemo.notification.NotificationChannel;

/**
 * Created by ratha on 1/25/2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            //create notification channel group
            ChannelGroup channelGroup=new ChannelGroup("personally_01","Personal group");
            String  groupId = NotificationChannel.createNotificationChannelGroup(this,channelGroup);

            //create notification channel
           /* Channel channel=new Channel("personally_02","personally 01", NotificationManager.IMPORTANCE_HIGH, "for only your personal");
            com.example.ratha.localnotificationdemo.notification.NotificationChannel.createNotificationChannel(this,channel,groupId);
            */
        }
    }
}
