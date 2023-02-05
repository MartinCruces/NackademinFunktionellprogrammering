package Uppkoppling_mot_databas.Skodatabas;

import java.util.List;

public class Shoe {

    private int id;
    private String articleNr;
    private String brand;
    private String color;
    private String size;
    private int price;
    private int inventory;

    public Shoe(){}



    public Shoe(int id, String articleNr, String brand, String color, String size, int price, int inventory) {
        this.id = id;
        this.articleNr = articleNr;
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

    public String getArticleNr() {return articleNr;}

    public void setArticleNr(String articleNr) {this.articleNr = articleNr;}

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

    public void printShoes(List<Shoe> list){
        list.forEach(shoe -> System.out.println("Artikelnr:" + shoe.articleNr + " Märke:" +
                shoe.getBrand() + " Färg:" + shoe.getColor() + " Storlek:" + shoe.getSize() + " pris:" + shoe.getPrice()));
    }
    public List<Shoe> getOneShoeList(List<Shoe> shoeList, String articleNr){

        return shoeList.stream().filter(shoe -> shoe.getArticleNr().equalsIgnoreCase(articleNr)).toList();
    }
    public int getShoeID(List<Shoe> list){
        return list.stream().mapToInt(shoe -> shoe.getId()).findAny().getAsInt();
    }
}
