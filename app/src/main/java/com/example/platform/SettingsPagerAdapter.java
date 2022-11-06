package com.example.platform;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SettingsPagerAdapter extends FragmentStateAdapter {

    public SettingsPagerAdapter(FragmentActivity activity){
        super(activity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new SettingsAccountFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
