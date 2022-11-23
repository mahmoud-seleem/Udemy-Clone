package com.example.platform;

public class Author {
    private String name;
    private int img;
    private String bio;

    public Author(String name, int img, String bio) {
        this.name = name;
        this.img = img;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getBio() {
        return bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
