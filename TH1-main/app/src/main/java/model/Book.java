package model;

import java.util.List;

public class Book {
    private String ten;
    private String tacgia;
    private String nxb;
    private List<String> theloai;

    public Book(String ten, String tacgia, String nxb ) {
        this.ten = ten;
        this.tacgia = tacgia;
        this.nxb = nxb;
    }

    public Book() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public List<String> getTheloai() {
        return theloai;
    }

    public void setTheloai(List<String> theloai) {
        this.theloai = theloai;
    }
}
