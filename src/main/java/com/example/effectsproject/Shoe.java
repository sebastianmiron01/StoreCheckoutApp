package com.example.effectsproject;

import java.util.HashMap;

public class Shoe extends Product implements Sellable,Searchable{

    public HashMap<Integer,Integer> stock= new HashMap<>();

    public Shoe(int id, String name, int price) {
        super(id,name,price);
    }

    public String getStock()
    {
        String s= "";
        s=s+"40  "+stock.get(40)+"\n";
        s=s+"41  "+stock.get(41)+"\n";
        s=s+"42  "+stock.get(42)+"\n";
        s=s+"43  "+stock.get(43)+"\n";
        s=s+"44  "+stock.get(44)+"\n";
        s=s+"45  "+stock.get(45)+"\n";
        s=s+"46  "+stock.get(46)+"\n";
        return s;
    }

    public void add(Integer size, Integer i)
    {
        this.stock.put(size,i);
    }
    public Integer searchSize(Integer size)
    {
        return stock.get(size);
    }
    @Override
    public void sell(Integer size, Integer num,Employee e)
    {
        try {
            if (stock.get(size) >= num) {
                stock.put(size, stock.get(size) - num);
                if (e != null) {
                    e.setSales(e.getSales() + (price * num));
                    if (e.getSales() >= e.getTarget()) {
                        e.setSalary((int) (e.getBaseSalary() + (0.01 * e.getTarget())));
                    }
                }
                System.out.println("Product " + name + " has been sold");
                System.out.println("New stock for product " + name + " size:" + size + " is " + stock.get(size) + ".");
            } else {
                System.out.println("Insufficient stock");
            }
        }
        catch (NullPointerException exception)
        {
            System.out.println("Please enter a available shoe size");
        }
    }

    @Override
    public void search() {
        for(Integer size :stock.keySet())
        {
            System.out.println(this.name+"   "+size+"   "+stock.get(size));
        }
    }
}
