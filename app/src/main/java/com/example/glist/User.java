package com.example.glist;

public class User {
    private String itemName;
    private String quantity;
    private String price;

    public User(String eItem, String eQuan, String ePrice){
        itemName = eItem;
        quantity = eQuan;
        price = ePrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }
}
