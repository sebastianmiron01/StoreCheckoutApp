package com.example.effectsproject;

import java.util.HashMap;

public  class Shirt extends Product implements Sellable,Searchable
{
    public HashMap<String,Integer> stock=new HashMap<>();
    public static HashMap<Integer,String> sizeConverter =new HashMap<>();
    public Shirt(Integer id, String name, int price)
    {
        super(id,name,price);

    }

    public void add(String size, Integer i)
    {
        this.stock.put(size,i);
    }
    public Integer searchSize(String size)
    {
        return stock.get(size);
    }
    public void initiateConverter()
    {
        sizeConverter.put(36,"S");
        sizeConverter.put(38,"M");
        sizeConverter.put(40,"L");
        sizeConverter.put(42,"XL");
    }
    public String getStock()
    {
        String s= "";
        s=s+"S  "+stock.get("S")+"\n";
        s=s+"M  "+stock.get("M")+"\n";
        s=s+"L  "+stock.get("L")+"\n";
        s=s+"XL  "+stock.get("XL")+"\n";
        return s;
    }
    @Override
    public void sell(Integer size,Integer num,Employee e)
    {
        if(stock.get(sizeConverter.get(size))>=num)
        {
            if(e!=null) {
                e.setSales(e.getSales() + (price * num));
                if (e.getSales() >= e.getTarget()) {
                    e.setSalary((int) (e.getBaseSalary() + (0.01 * e.getTarget())));
                }
            }
            stock.put(sizeConverter.get(size),stock.get(sizeConverter.get(size))-num);
            System.out.println("Product "+name+" has been sold");
            System.out.println("New stock for product "+name+" size:"+sizeConverter.get(size)+" is "+stock.get(sizeConverter.get(size))+".");
        }
        else {
            System.out.println("Insufficient stock");
        }
    }

    @Override
    public void search()
    {
        for(String size :stock.keySet())
        {
            System.out.println(this.name+"   "+size+"   "+stock.get(size));
        }
    }
}
