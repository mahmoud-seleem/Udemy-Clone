package com.example.platform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

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

        EditText search = (EditText) findViewById(R.id.search_box);
        search.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);

        final MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open navigation drawer
            }
        });


    }


    public void launchSignActivity() {
        Intent switchToSignActivity = new Intent(MainActivity.this, SignActivity.class);
        startActivity(switchToSignActivity);
    }
}