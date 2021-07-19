package com.saurav.orderurslice;

public class PizzaCrust {
    public String crust;
    public float price;

    public PizzaCrust(String s, float p){
        crust = s;
        price = p;
    }

    public String toString(){
        return crust + ": $" + price;
    }
}
