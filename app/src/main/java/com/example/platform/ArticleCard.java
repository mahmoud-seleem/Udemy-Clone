package com.example.platform;

import java.util.ArrayList;

public class ArticleCard {
    private int imageResourceId;
    private String articleTitle;
    private int minimumReadingTime;
    private int maxReadingTime;
    private ArrayList<Tag> tags;

    public ArticleCard() {
        this.imageResourceId = R.drawable.ic_launcher_background;
        this.articleTitle = "Platform";
        this.minimumReadingTime = 30;
        this.maxReadingTime = 60;
        this.tags = new ArrayList<>();
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));
        tags.add(new Tag("Platform",R.drawable.main_home_icon));

    }

    public ArticleCard(int imageResourceId, String articleTitle, int minimumReadingTime, int maxReadingTime, ArrayList<Tag> tags) {
        this.imageResourceId = imageResourceId;
        this.articleTitle = articleTitle;
        this.minimumReadingTime = minimumReadingTime;
        this.maxReadingTime = maxReadingTime;
        this.tags = tags;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public int getMinimumReadingTime() {
        return minimumReadingTime;
    }

    public void setMinimumReadingTime(int minimumReadingTime) {
        this.minimumReadingTime = minimumReadingTime;
    }

    public int getMaxReadingTime() {
        return maxReadingTime;
    }

    public void setMaxReadingTime(int maxReadingTime) {
        this.maxReadingTime = maxReadingTime;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
