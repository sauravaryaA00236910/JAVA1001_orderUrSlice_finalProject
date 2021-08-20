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

    ArrayList<String> cartPizzaArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_pizza_list);

        Intent intent = getIntent();
        cartPizzaArrayList = intent.getStringArrayListExtra("cartPizzaArrayList_key");

        ArrayAdapter adapterPizzaCartList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cartPizzaArrayList);

        ListView pizzaCartLV = findViewById(R.id.pizzaCartLV);
        pizzaCartLV.setAdapter(adapterPizzaCartList);
    }
}