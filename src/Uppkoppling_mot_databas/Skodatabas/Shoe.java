package Uppkoppling_mot_databas.Skodatabas;

public class Shoe {

    protected int id;
    protected String brand;
    protected String color;
    protected String size;
    protected int price;
    protected int inventory;

    public Shoe(){}

    public Shoe(int id, String brand, String color, String size, int price, int inventory) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.inventory = inventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
