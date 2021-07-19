package com.saurav.orderurslice;

public class PizzaVegTopping {
    public String vegTopping;
    public float price;

    public PizzaVegTopping(String s, float p){
        vegTopping = s;
        price = p;
    }

    public String toString(){
        return vegTopping + ": $" + price;
    }
}
