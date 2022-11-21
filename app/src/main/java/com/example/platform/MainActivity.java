package com.example.platform;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.google.android.material.appbar.MaterialToolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.appbar.MaterialToolbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyConstraintLayout constraintLayout  = findViewById(R.id.parent_constraint);
        constraintLayout.getaAllEditTexts(constraintLayout);
//        SharedPreferences preferences = getSharedPreferences("sharedPreferencesFile", MODE_PRIVATE);
//        boolean isTheFirstAppRun = preferences.getBoolean("FirstAppRun", true);
//        if (isTheFirstAppRun) {
//            SharedPreferences.Editor preferencesEditor = (SharedPreferences.Editor) getSharedPreferences("sharedPreferencesFile", MODE_PRIVATE);
//            preferencesEditor.putBoolean("FirstAppRun", false).commit(); //commit()
//
//            launchSignActivity();
//            finish(); //finish first main activity //main -> sign -> main =>>> main(finish) -> sign -> main
//        }
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView drawer = findViewById(R.id.navigation_drawer);
        EditText search = (EditText) findViewById(R.id.search_box);
        search.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, 0, 0);
        final MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START,true);
            }
        });
        drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                return true;
            }
        });
//        HomeFragment homeFragment = new HomeFragment();
        Author_profile_Fragment author_profile_fragment = new Author_profile_Fragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.frame, author_profile_fragment, "HELLO");
        fragmentTransaction.commit();
    }

    public void launchSignActivity() {
        Intent switchToSignActivity = new Intent(MainActivity.this, SignActivity.class);
        startActivity(switchToSignActivity);
    }
}