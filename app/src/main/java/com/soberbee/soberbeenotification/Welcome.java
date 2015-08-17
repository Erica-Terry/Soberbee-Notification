package com.soberbee.soberbeenotification;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

import java.util.Random;


public class Welcome extends AppCompatActivity implements View.OnClickListener{

    private Button encourageButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Button for encouraging notification messages
        encourageButton = (Button) findViewById(R.id.encourage_btn);
        encourageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.encourage_btn:
                encourageNotification(getEncouragement());
                break;
            default:
                //TODO add warning message here
                break;
        }
    }

    private void encourageNotification(String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification_soberbee)
                .setContentTitle("Encouragement from Soberbee")
                .setContentText(message)
                .setTicker(message)
                .setVibrate(new long[]{100, 300, 100})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));

        int mNotificationId = 1;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }

    private String getEncouragement()
    {
        String[] messages = getResources().getStringArray(R.array.enc_mess);

        Random rand  = new Random();
        int messageNum = rand.nextInt(messages.length);

        return messages[messageNum];
    }

}

