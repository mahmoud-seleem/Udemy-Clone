package com.example.platform;

public class Tag {
    private String TagName;
    private int TagIconResourceId;

    public Tag(String tagName) {
        TagName = tagName;
    }

    public Tag(String tagName, int tagIconResourceId) {
        TagName = tagName;
        TagIconResourceId = tagIconResourceId;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }

    public int getTagIconResourceId() {
        return TagIconResourceId;
    }

    public void setTagIconResourceId(int tagIconResourceId) {
        TagIconResourceId = tagIconResourceId;
    }
}
