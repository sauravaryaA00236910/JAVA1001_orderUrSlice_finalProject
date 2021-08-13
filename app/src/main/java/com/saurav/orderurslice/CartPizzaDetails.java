package com.saurav.orderurslice;

public class CartPizzaDetails {
    public String name;
    public String desc;

    public CartPizzaDetails(String n, String d){
        name = n;
        desc = d;
    }

    public String toString(){
        return name + ": \n" + desc;
    }
}
