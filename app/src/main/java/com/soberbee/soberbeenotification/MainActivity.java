package com.soberbee.soberbeenotification;

import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button encourageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, "052DKHY86dLD0F9cXNsOcDbS3Syrd3tdx6UZE6K2", "CM5Rt3zjCDyXzzSnrZ2vOHu1NfG4H1K6ID3HPrlX");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        // Button for encouraging notification messages
        encourageButton = (Button) findViewById(R.id.encourage_btn);
        encourageButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    private void getLocation()
    {
    }
}
