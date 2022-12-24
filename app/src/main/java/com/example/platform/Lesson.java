package com.example.platform;

public class Lesson {
    String lessonTitle;
    int lessonIcon;

    public Lesson(String lessonTitle, int lessonIcon) {
        this.lessonTitle = lessonTitle;
        this.lessonIcon = lessonIcon;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public int getLessonIcon() {
        return lessonIcon;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public void setLessonIcon(int lessonIcon) {
        this.lessonIcon = lessonIcon;
    }
}
