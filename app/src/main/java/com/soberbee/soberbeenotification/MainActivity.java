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

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button encourageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        int mNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }

    private String getEncouragement()
    {
        Random rand  = new Random();
        int messageNum = rand.nextInt(30);

        switch (messageNum)
        {
            case 1:
                return "Your family loves you.";

            case 2:
                return "Keep working hard!";

            case 3:
                return "You are not alone.";

            default:
                return "You've got this!";

        }
    }
}
