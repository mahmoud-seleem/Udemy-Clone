package com.example.platform;

public class AuthorCard {
    private int authorImageResourceId;
    private String authorName;
    private String authorBio;

    public AuthorCard() {
        this.authorImageResourceId = R.drawable.ic_launcher_background;
        this.authorBio = "author_bio";
        this.authorName = "author_name";
    }

    public AuthorCard(int authorImageResourceId, String authorName, String authorBio) {
        this.authorImageResourceId = authorImageResourceId;
        this.authorName = authorName;
        this.authorBio = authorBio;
    }

    public void setAuthorImageResourceId(int authorImageResourceId) {
        this.authorImageResourceId = authorImageResourceId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public int getAuthorImageResourceId() {
        return authorImageResourceId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorBio() {
        return authorBio;
    }
}
