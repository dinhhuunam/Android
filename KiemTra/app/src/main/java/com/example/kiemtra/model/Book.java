package com.example.kiemtra.model;

public class Book {
    private String tenSach,date,theLoai;

    public Book(){
    }

    public Book(String tenSach, String date, String theLoai) {
        this.tenSach = tenSach;
        this.date = date;
        this.theLoai = theLoai;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
}
