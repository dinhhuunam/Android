package model;

public class CellPhone {
    private String name;
    private int img;
    private String origin;
    private double price;

    public CellPhone(String name, int img, String origin, double price) {
        this.name = name;
        this.img = img;
        this.origin = origin;
        this.price = price;
    }
    public CellPhone(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
