package com.example.platform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SignOnBoardingAdapter extends RecyclerView.Adapter<SignOnBoardingAdapter.SignOnBoardingViewHolder> {
    @NonNull
    @Override
    public SignOnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SignOnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.sign_activity_viewpager_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SignOnBoardingViewHolder holder, int position) {
        holder.setOnBoardingData(signOnBoardingItemsList.get(position));

    }

    @Override
    public int getItemCount() {
        return signOnBoardingItemsList.size();
    }

    private List<SignOnBoardingItem> signOnBoardingItemsList;

    public SignOnBoardingAdapter(List<SignOnBoardingItem> signOnBoardingItemsList) {
        this.signOnBoardingItemsList = signOnBoardingItemsList;
    }


    class SignOnBoardingViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageOnBoarding;
        private TextView textTitle;
        private TextView textDescription;

        public SignOnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageOnBoarding = itemView.findViewById(R.id.imageOnBoarding);
            this.textTitle = itemView.findViewById(R.id.txtTitle);
            this.textDescription = itemView.findViewById(R.id.txtDescription);
        }

        public void setOnBoardingData(SignOnBoardingItem item) {
            textTitle.setText(item.getTitle());
            textDescription.setText(item.getDescription());
            imageOnBoarding.setImageResource(item.getImg());
        }
    }
}
