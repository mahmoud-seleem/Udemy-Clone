package com.example.platform;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class SignActivity extends AppCompatActivity {

    private SignOnBoardingAdapter onBoardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        setupSignOnBoardingItems();
        ViewPager2 onBoardingViewPager = findViewById(R.id.SignActivity_viewPager);
        onBoardingViewPager.setAdapter(onBoardingAdapter);

//        to be implemented
//        OrientationEventListener.onOrientationChanged()

    }

    //modified later to event listeners
    public void switchToSignUp(View view) {
    }

    public void forgotPasswordAction(View view) {
    }


    //TO DO: refactor this method into (1 list of 3 items) and fn to add
    private void setupSignOnBoardingItems() {
        List<SignOnBoardingItem> onBoardingItems = new ArrayList<>();

        SignOnBoardingItem onBoardingFirstItem = new SignOnBoardingItem();
        onBoardingFirstItem.setImg(R.drawable.accessibility_importance_img);
        onBoardingFirstItem.setTitle(getString(R.string.SignActivity_ViewPager_item1_title));
        onBoardingFirstItem.setDescription(getString(R.string.AccessibilityImportance_img_description));

        SignOnBoardingItem onBoardingSecondItem = new SignOnBoardingItem();
        onBoardingSecondItem.setImg(R.drawable.temp1);
        onBoardingSecondItem.setTitle(getString(R.string.SignActivity_ViewPager_item2_title));
        onBoardingSecondItem.setDescription(getString(R.string.AccessibilityImportance_img_description));

        SignOnBoardingItem onBoardingThirdItem = new SignOnBoardingItem();
        onBoardingThirdItem.setImg(R.drawable.temp2);
        onBoardingThirdItem.setTitle(getString(R.string.SignActivity_ViewPager_item2_title));
        onBoardingThirdItem.setDescription(getString(R.string.AccessibilityImportance_img_description));

        SignOnBoardingItem onBoardingFourthItem = new SignOnBoardingItem();
        onBoardingFourthItem.setImg(R.drawable.images);
        onBoardingFourthItem.setTitle(getString(R.string.SignActivity_ViewPager_item2_title));
        onBoardingFourthItem.setDescription(getString(R.string.AccessibilityImportance_img_description));

        onBoardingItems.add(onBoardingFirstItem);
        onBoardingItems.add(onBoardingSecondItem);
        onBoardingItems.add(onBoardingThirdItem);
        onBoardingItems.add(onBoardingFourthItem);

        onBoardingAdapter = new SignOnBoardingAdapter(onBoardingItems);
    }
}