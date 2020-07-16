package com.www.socialx.model;

public class activities_model {
    String title,subtile,time;
    int main_img,right_img;

    public activities_model(String title, String subtile, String time, int main_img, int right_img) {
        this.title = title;
        this.subtile = subtile;
        this.time = time;
        this.main_img = main_img;
        this.right_img = right_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtile() {
        return subtile;
    }

    public void setSubtile(String subtile) {
        this.subtile = subtile;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMain_img() {
        return main_img;
    }

    public void setMain_img(int main_img) {
        this.main_img = main_img;
    }

    public int getRight_img() {
        return right_img;
    }

    public void setRight_img(int right_img) {
        this.right_img = right_img;
    }
}
