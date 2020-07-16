package com.www.socialx.model;

public class community_model {
    String tv_community;
    int iv_community;

    public community_model(String tv_community, int iv_community) {
        this.tv_community = tv_community;
        this.iv_community = iv_community;
    }

    public String getTv_community() {
        return tv_community;
    }

    public void setTv_community(String tv_community) {
        this.tv_community = tv_community;
    }

    public int getIv_community() {
        return iv_community;
    }

    public void setIv_community(int iv_community) {
        this.iv_community = iv_community;
    }
}
