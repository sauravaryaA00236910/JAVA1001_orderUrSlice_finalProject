package com.saurav.orderurslice;

public class PizzaSize {

    public String size;
    public float price;

    public PizzaSize(String s, float p){
        size = s;
        price = p;
    }

    public String toString(){
        return size + ": $" + price;
    }
}
