package com.www.socialx.model;

public class myrewards_model {
    private int mainimage,iv_rewards_point;
    private String title;
    private String date;
    private String time;
    private String rewardspoint;

    public myrewards_model(int mainimage, int iv_rewards_point, String title, String date, String time, String rewardspoint) {
        this.mainimage = mainimage;
        this.iv_rewards_point = iv_rewards_point;
        this.title = title;
        this.date = date;
        this.time = time;
        this.rewardspoint = rewardspoint;
    }

    public int getMainimage() {
        return mainimage;
    }

    public void setMainimage(int mainimage) {
        this.mainimage = mainimage;
    }

    public int getIv_rewards_point() {
        return iv_rewards_point;
    }

    public void setIv_rewards_point(int iv_rewards_point) {
        this.iv_rewards_point = iv_rewards_point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRewardspoint() {
        return rewardspoint;
    }

    public void setRewardspoint(String rewardspoint) {
        this.rewardspoint = rewardspoint;
    }
}
