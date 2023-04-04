package com.example.effectsproject;

public abstract class Product {
    public Integer id;
    public String name;
    public int price;
    Product(Integer id,String name, int price)
    {
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
