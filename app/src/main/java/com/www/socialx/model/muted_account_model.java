package com.www.socialx.model;

public class muted_account_model {
    String title,btn_title;
    int main_image;

    public muted_account_model(String title, String btn_title, int main_image) {
        this.title = title;
        this.btn_title = btn_title;
        this.main_image = main_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBtn_title() {
        return btn_title;
    }

    public void setBtn_title(String btn_title) {
        this.btn_title = btn_title;
    }

    public int getMain_image() {
        return main_image;
    }

    public void setMain_image(int main_image) {
        this.main_image = main_image;
    }
}
