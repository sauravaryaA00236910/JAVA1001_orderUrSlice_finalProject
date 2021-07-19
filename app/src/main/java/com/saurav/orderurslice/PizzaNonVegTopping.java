package com.saurav.orderurslice;

public class PizzaNonVegTopping {
    public String nonVegTopping;
    public float price;

    public PizzaNonVegTopping(String s, float p){
        nonVegTopping = s;
        price = p;
    }

    public String toString(){
        return nonVegTopping + ": $" + price;
    }
}
