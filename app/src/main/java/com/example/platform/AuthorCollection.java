package com.example.platform;


import java.util.ArrayList;

public class AuthorCollection {
    private int img;
    private String title;
    private String articlesNumber;
    private ArrayList<Tag> tags = new ArrayList<>();


    public AuthorCollection(int img, String title, String articlesNumber) {
        this.img = img;
        this.title = title;
        this.articlesNumber = articlesNumber;
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
        tags.add(new Tag("Platform", R.drawable.ic_android_black_24dp));
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getArticlesNumber() {
        return articlesNumber;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticlesNumber(String articlesNumber) {
        articlesNumber = articlesNumber;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}

