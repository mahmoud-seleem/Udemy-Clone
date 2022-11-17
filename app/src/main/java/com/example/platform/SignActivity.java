package com.example.platform;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

//        to be implemented
//        OrientationEventListener.onOrientationChanged()

    }

    //modified later to event listeners
    public void switchToSignUp(View view) {
    }

    public void forgotPasswordAction(View view) {
    }

    SignOnBoardingAdapter onBoardingAdapter;

    private void setSignOnBoardingItems() {
        List<SignOnBoardingItem> onBoardingItems = new ArrayList<>();
        SignOnBoardingItem onBoardingItem = new SignOnBoardingItem();
        
    }
}