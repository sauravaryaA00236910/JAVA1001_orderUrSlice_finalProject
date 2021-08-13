package com.saurav.orderurslice;

public class PizzaDetails {

    public String name;
    public String desc;

    public PizzaDetails(String n, String d){
        name = n;
        desc = d;
    }

    public String toString(){
        return name + ": \n" + desc;
    }
}
