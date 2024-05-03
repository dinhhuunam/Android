package com.example.thuchanh.model;

public class Employee {
    public static String MALE="male",FEMALE="female";
    private String maNV,tenNv,gt;

    public Employee(){
    }

    public Employee(String maNV, String tenNv, String gt) {
        this.maNV = maNV;
        this.tenNv = tenNv;
        this.gt = gt;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }
}
