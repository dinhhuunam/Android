package com.example.thubaiktre;

public class Nguoi {
    private int img;
    private String ngay;
    private String congviec;
    private String gioitinh;
    private String ten;

    public Nguoi(){}

    public Nguoi( String ngay, String congviec, String gioitinh, String ten) {
        this.ngay = ngay;
        this.congviec = congviec;
        this.gioitinh = gioitinh;
        this.ten = ten;
        if("nam".equalsIgnoreCase(gioitinh)){
            this.img = R.drawable.nam;
        } else this.img = R.drawable.nu;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
