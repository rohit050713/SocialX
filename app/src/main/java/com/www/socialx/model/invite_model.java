package com.www.socialx.model;

public class invite_model {
    public invite_model(int main_img, String title) {
        this.main_img = main_img;
        this.title = title;
    }

    private int main_img;
    private String title;

    public int getMain_img() {
        return main_img;
    }

    public void setMain_img(int main_img) {
        this.main_img = main_img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
