package com.example.myapplication.bean;

public class Gupian_Bean {
    private String gupian_name;
    private String today_price;
    private String yesterday_price;

    public Gupian_Bean(String gupian_name, String today_price, String yesterday_price) {
        this.gupian_name = gupian_name;
        this.today_price = today_price;
        this.yesterday_price = yesterday_price;
    }

    public String getGupian_name() {
        return gupian_name;
    }

    public void setGupian_name(String gupian_name) {
        this.gupian_name = gupian_name;
    }

    public String getToday_price() {
        return today_price;
    }

    public void setToday_price(String today_price) {
        this.today_price = today_price;
    }

    public String getYesterday_price() {
        return yesterday_price;
    }

    public void setYesterday_price(String yesterday_price) {
        this.yesterday_price = yesterday_price;
    }
}
