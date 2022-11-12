package com.example.platform;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        Fragment[] fragments = new Fragment[3];
        fragments[0] = new SettingsAccountFragment();
        fragments[1] = new settingsAccessibilityFragment();
        fragments[2] = new SettingsPreferencesFragment();

        FragmentStateAdapter adapter = new SettingsPagerAdapter(this, fragments);
        viewPager.setAdapter(adapter);
        String[] titles = {"Account", "Accessibility", "Preferences"};
        int[] icons = {R.drawable.settings_account_icon,
                R.drawable.settings_accessibility_icon,
                R.drawable.settings_preferences_icon};
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles[position]);
                tab.setIcon(icons[position]);
                if (position != 0) {
                    if (tab.getIcon() != null) {
                        tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.dark_gray), PorterDuff.Mode.SRC_IN);
                    }

                }

            }
        });
        mediator.attach();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue), PorterDuff.Mode.SRC_IN);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.dark_gray), PorterDuff.Mode.SRC_IN);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}