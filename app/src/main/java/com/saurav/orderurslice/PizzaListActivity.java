package com.saurav.orderurslice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;

public class PizzaListActivity extends AppCompatActivity {

    private String pizzaName;
    private String pizzaDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        ArrayList<PizzaDetails> pizzaOptions = new ArrayList<>();
        pizzaOptions.add(0, new PizzaDetails("Margherita", "Classic delight with mozzarella cheese"));
        pizzaOptions.add(1, new PizzaDetails("The Unthinkable Pizza", "Loaded with plant based protein topping along with black olives and red paprika"));
        pizzaOptions.add(2,new PizzaDetails("Pepper Barbecue Chicken", "Pepper barbecue chicken for that extra zing"));
        pizzaOptions.add(3,new PizzaDetails("Chicken Golden Delight", "Double pepper barbecue chicken, golden corn and extra cheese, true delight"));

        ArrayAdapter adapterPizzaOptions = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, pizzaOptions);

        ListView pizzaOptionsLV = findViewById(R.id.pizzaOptionsLV);
        pizzaOptionsLV.setAdapter(adapterPizzaOptions);

        pizzaOptionsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                pizzaName = pizzaOptions.get(position).name;
                pizzaDesc = pizzaOptions.get(position).desc;

                Intent n = new Intent(PizzaListActivity.this, MainActivity.class);
                n.putExtra("pizzaName_key", pizzaName);
                //startActivity(n);
                //Intent d = new Intent(PizzaListActivity.this, MainActivity.class);
                n.putExtra("pizzaDesc_key", pizzaDesc);
                startActivity(n);
            }
        });
    }
}