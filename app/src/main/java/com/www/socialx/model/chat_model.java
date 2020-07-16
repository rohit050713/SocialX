package com.www.socialx.model;

public class chat_model {
    String title,subtitle,time,number;
    int image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public chat_model(String title, String subtitle, String time, String number, int image) {
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
        this.number = number;
        this.image = image;
    }
}
