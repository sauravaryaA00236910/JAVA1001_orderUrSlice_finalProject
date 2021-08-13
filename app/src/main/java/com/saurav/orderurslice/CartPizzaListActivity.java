package com.saurav.orderurslice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CartPizzaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_pizza_list);

//        String pizzaType = getIntent().getStringExtra("pizzaType_key");
//        String pizzaDesc = getIntent().getStringExtra("pizzaDesc_key");

        ArrayList<CartPizzaDetails> pizzaCartList = new ArrayList<>();
        pizzaCartList.add(0, new CartPizzaDetails("pizzaType", "pizzaDesc"));


        ArrayAdapter adapterPizzaCartList = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, pizzaCartList);

        ListView pizzaCartLV = findViewById(R.id.pizzaCartLV);
        pizzaCartLV.setAdapter(adapterPizzaCartList);
    }
}