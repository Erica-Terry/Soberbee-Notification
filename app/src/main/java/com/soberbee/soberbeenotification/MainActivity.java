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

        if(ParseUser.getCurrentUser() == null){
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            MainActivity.this.startActivity(intent);
        }
        else if(ParseAnonymousUtils.isLinked(ParseUser.getCurrentUser())) {
            // If user is anonymous send user to login
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            MainActivity.this.startActivity(intent);
        } else {
            // If current user is NOT anonymous user
            ParseUser currentUser = ParseUser.getCurrentUser();
            if(currentUser != null) {

                Intent intent = new Intent(MainActivity.this, Welcome.class);
                startActivity(intent);
            }
        }
    }


}
