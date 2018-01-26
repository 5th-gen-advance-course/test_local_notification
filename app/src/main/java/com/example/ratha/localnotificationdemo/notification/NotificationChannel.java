package com.example.ratha.localnotificationdemo.notification;

import android.annotation.TargetApi;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by ratha on 1/25/2018.
 */

public class NotificationChannel {

    @TargetApi(Build.VERSION_CODES.O)
    public  static <T extends  Channel>  void createNotificationChannel(Context context, T channel ,String ... groupIds){
        android.app.NotificationChannel mChannel = new android.app.NotificationChannel(channel.getId(),channel.getName(),channel.getPriority());
        mChannel.setDescription(channel.getDesc());
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.RED);
        mChannel.enableVibration(true);
        Uri sound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        AudioAttributes att=new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                            .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                            .build();
        mChannel.setSound(sound,att);
        mChannel.setVibrationPattern(new long[]{100l, 200l, 300l, 400l, 500l, 400l, 300l, 200l, 400l});

        if(groupIds!=null){
            mChannel.setGroup(groupIds[0]);
        }

        NotificationManager mNotificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(mChannel);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static <T extends ChannelGroup> String createNotificationChannelGroup(Context context, T group){
        NotificationChannelGroup mGroup=new NotificationChannelGroup(group.getId(),group.getName());
        NotificationManager mNotificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannelGroup(mGroup);

        return group.getId();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void deleteChannel(Context context, String channelId){
        NotificationManager mNotificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.deleteNotificationChannel(channelId);
    }
}
