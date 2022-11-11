package com.example.platform;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SettingsPagerAdapter extends FragmentStateAdapter {

    Fragment[] fragments = new Fragment[3];
    public SettingsPagerAdapter(FragmentActivity activity){
        super(activity);
        fragments[0] = new SettingsAccountFragment();
        fragments[1] = new settingsAccessibilityFragment();
        fragments[2] = new SettingsPreferencesFragment();
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
