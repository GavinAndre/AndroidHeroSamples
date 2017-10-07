package com.gavinandre.androidherosamples.chaptertwelve.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

import com.gavinandre.androidherosamples.MainActivity;
import com.gavinandre.androidherosamples.R;


public class NotificationActivity extends AppCompatActivity {

    private int NOTIFICATION_ID_BASIC = 1;
    private int NOTIFICATION_ID_COLLAPSE = 2;
    private int NOTIFICATION_ID_HEADSUP = 3;
    private int NOTIFICATION_ID_VISIBILITY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void basicNotify(View view) {
        //使用PendingIntent来延迟执行用户点击后的Intent操作
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.baidu.com"));
        // 构造PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, 0);
        // 创建Notification对象
        Notification.Builder builder = new Notification.Builder(this);
        // 设置Notification的各种属性
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher));
        builder.setContentTitle("Basic Notifications");
        builder.setContentText("I am a basic notification");
        builder.setSubText("it is really basic");
        // 通过NotificationManager来发出Notification
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
        // 调用notify方法时，需要传进去一个ID。每个Notification都会有一个ID，
        // 这个ID就是用来区分不同的APP的Notification的。
        notificationManager.notify(NOTIFICATION_ID_BASIC,
                builder.build());
    }

    public void collapsedNotify(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.sina.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, 0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(
                getResources(), R.mipmap.ic_launcher));
        // 将一个布局指定为Notification正常状态下的视图
        RemoteViews contentView =
                new RemoteViews(getPackageName(),
                        R.layout.notification);
        contentView.setTextViewText(R.id.textView,
                "show me when collapsed");

        Notification notification = builder.build();
        notification.contentView = contentView;
        // 将另一个展开的布局指定为Notification展开时的视图
        RemoteViews expandedView =
                new RemoteViews(getPackageName(),
                        R.layout.notification_expanded);
        notification.bigContentView = expandedView;

        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID_COLLAPSE, notification);
    }

    public void headsupNotify(View view) {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Headsup Notification")
                .setContentText("I am a Headsup notification.");

        Intent push = new Intent();
        push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        push.setClass(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, push, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentText("Heads-Up Notification on Android 5.0")
                .setFullScreenIntent(pendingIntent, true);
        //通过setFullScreenIntent将一个Notification变成悬挂式Notification
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID_HEADSUP, builder.build());
    }

    public void visibilityNotify(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(
                R.id.visibility_radio_group);
        Notification.Builder builder = new Notification.Builder(this)
                .setContentTitle("Notification for Visibility Test");
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_button_public:
                builder.setVisibility(Notification.VISIBILITY_PUBLIC);
                builder.setContentText("Public");
                builder.setSmallIcon(R.mipmap.ic_public);
                break;
            case R.id.radio_button_private:
                builder.setVisibility(Notification.VISIBILITY_PRIVATE);
                builder.setContentText("Private");
                builder.setSmallIcon(R.mipmap.ic_private);
                break;
            case R.id.radio_button_secret:
                builder.setVisibility(Notification.VISIBILITY_SECRET);
                builder.setContentText("Secret");
                builder.setSmallIcon(R.mipmap.ic_secret);
                break;
        }
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        nm.notify(NOTIFICATION_ID_VISIBILITY, builder.build());
    }
}
