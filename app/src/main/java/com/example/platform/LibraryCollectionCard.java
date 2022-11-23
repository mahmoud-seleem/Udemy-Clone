package com.example.platform;

public class LibraryCollectionCard {
    private int imageResourceId;
    private String title;
    private String description;

    public LibraryCollectionCard() {
        this.imageResourceId = R.drawable.ic_launcher_background;
        this.title = "title";
        this.description = "30 articles";
    }

    public LibraryCollectionCard(int imageResourceId, String title, String description) {
        this.imageResourceId = imageResourceId;
        this.title = title;
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
