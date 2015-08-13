package com.soberbee.soberbeenotification;

import android.app.NotificationManager;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Parse.initialize(this, "052DKHY86dLD0F9cXNsOcDbS3Syrd3tdx6UZE6K2", "CM5Rt3zjCDyXzzSnrZ2vOHu1NfG4H1K6ID3HPrlX");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
            // If user is anonymous send user to login
            Intent intent = new Intent(MainActivity.this,
                    SignUpActivity.class);
            startActivity(intent);
            finish();
        } else {
            // If current user is NOT anonymous user
            ParseUser currentUser = ParseUser.getCurrentUser();
            if(currentUser != null) {

                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        }
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

}
