package com.example.platform;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences preferences = getSharedPreferences("sharedPreferencesFile", MODE_PRIVATE);
//        boolean isTheFirstAppRun = preferences.getBoolean("FirstAppRun", true);
//        if (isTheFirstAppRun) {
//            SharedPreferences.Editor preferencesEditor = (SharedPreferences.Editor) getSharedPreferences("sharedPreferencesFile", MODE_PRIVATE);
//            preferencesEditor.putBoolean("FirstAppRun", false).commit(); //commit()
//
//            launchSignActivity();
//            finish(); //finish first main activity //main -> sign -> main =>>> main(finish) -> sign -> main
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void launchSignActivity() {
        Intent switchToSignActivity = new Intent(MainActivity.this, SignActivity.class);
        startActivity(switchToSignActivity);
    }
}