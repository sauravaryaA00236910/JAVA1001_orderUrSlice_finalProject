package com.saurav.orderurslice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartPizzaListActivity extends AppCompatActivity
        implements View.OnClickListener{

    ArrayList<String> cartPizzaArrayList = new ArrayList<>();
    Button backToHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_pizza_list);

        backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(this);

        Intent intent = getIntent();
        cartPizzaArrayList = intent.getStringArrayListExtra("cartPizzaArrayList_key");

        ArrayAdapter adapterPizzaCartList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cartPizzaArrayList);
        ListView pizzaCartLV = findViewById(R.id.pizzaCartLV);
        pizzaCartLV.setAdapter(adapterPizzaCartList);

    }

    @Override
    public void onClick(View view) {
        Intent n = new Intent(CartPizzaListActivity.this, PizzaListActivity.class);
        switch(view.getId()){
            case R.id.backToHomeBtn:
                n.putStringArrayListExtra("updateCartPizzaArrayList_key", cartPizzaArrayList);
                startActivity(n);
                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}