package com.example.tourapp;

public class Tour {
    private String lich_trinh;
    private String time;
    private String phuong_tien;

    public Tour(){

    }
    public Tour(String lich_trinh, String time, String phuong_tien) {
        this.lich_trinh = lich_trinh;
        this.time = time;
        this.phuong_tien = phuong_tien;
    }

    public String getLich_trinh() {
        return lich_trinh;
    }

    public void setLich_trinh(String lich_trinh) {
        this.lich_trinh = lich_trinh;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhuong_tien() {
        return phuong_tien;
    }

    public void setPhuong_tien(String phuong_tien) {
        this.phuong_tien = phuong_tien;
    }
}
