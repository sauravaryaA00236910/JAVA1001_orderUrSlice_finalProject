package com.saurav.orderurslice;

import java.math.BigDecimal;

public class PizzaDetails {

    public String name;
    public String desc;
    public double price;

    public PizzaDetails(String n, String d, double p){
        name = n;
        desc = d;
        price = p;
    }

    public String toString(){
        return name + ": \n" + desc + ": $" + price;
    }
}
