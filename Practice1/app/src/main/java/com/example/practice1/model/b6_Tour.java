package com.example.practice1.model;

public class b6_Tour {
    private int img, imgGender;

    private String schedule, time, clock, date;

    public b6_Tour() {
    }

    public b6_Tour(int img, int imgGender, String schedule, String time, String clock, String date) {
        this.img = img;
        this.imgGender=imgGender;
        this.schedule = schedule;
        this.time = time;
        this.clock = clock;
        this.date = date;
    }

    public int getImgGender() {
        return imgGender;
    }

    public void setImgGender(int imgGender) {
        this.imgGender = imgGender;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
