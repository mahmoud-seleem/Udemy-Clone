package com.example.platform;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyConstraintLayout constraintLayout = findViewById(R.id.parent_constraint);
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
                drawerLayout.openDrawer(GravityCompat.START, true);
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        final Fragment[] fragment = new Fragment[1];
        drawer.setCheckedItem(R.id.home_page);
        fragment[0] = new HomeFragment();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment[0], "HELLO");
        fragmentTransaction.commit();
        drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                drawerLayout.closeDrawer(GravityCompat.START, true);
                item.setChecked(true);
                int itemId = item.getItemId();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                switch (itemId) {
                    case R.id.home_page:
                        fragment[0] = new HomeFragment();
                        break;
                    case R.id.history_page:
                        fragment[0] = new HistoryFragment();
                        break;
                    case R.id.authors_page:
                        fragment[0] = new FollowingAuthorsFragment();
                        break;
                    case R.id.collections_page:
                        fragment[0] = new LibraryCollectionsFragment();
                        break;
                    case R.id.bookmarks_page:
                        fragment[0] = new BookMarksFragment();
                        break;
                }
                fragmentTransaction.replace(R.id.frame, fragment[0], "HELLO");
                fragmentTransaction.commit();
                return true;
            }
        });
        Button settingsButton = findViewById(R.id.drawer_settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
                //drawerLayout.closeDrawer(GravityCompat.START,true);
            }
        });
//        HomeFragment homeFragment = new HomeFragment();
//        LibraryCollectionsFragment libraryCollectionsFragment = new LibraryCollectionsFragment();
//        BookMarksFragment bookMarksFragment = new BookMarksFragment();
//        Author_profile_Fragment author_profile_fragment = new Author_profile_Fragment(constraintLayout);
//        AuthorArticlesFragment authorArticlesFragment = new AuthorArticlesFragment();
//        HistoryFragment historyFragment = new HistoryFragment();
//        FollowingAuthorsFragment followingAuthorsFragment = new FollowingAuthorsFragment();
//        AuthorsCollectionFragment authorsCollectionFragment = new AuthorsCollectionFragment();
//        CollectionArticlesFragment collectionArticlesFragment = new CollectionArticlesFragment();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.add(R.id.frame, homeFragment, "HELLO");
//        fragmentTransaction.commit();
    }

    public void launchSignActivity() {
        Intent switchToSignActivity = new Intent(MainActivity.this, SignActivity.class);
        startActivity(switchToSignActivity);
    }
}