package com.saurav.orderurslice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PizzaListActivity extends AppCompatActivity
        implements View.OnClickListener {

    private String pizzaName = "Custom Made";
    private String pizzaDesc = "Details";
    private double pizzaPrice;
    private String pizzaSelected;
    Button addToCartHomeBtn;
    Button customPizzaHomeBtn;
    Button viewCartBtn;
    ArrayList<String> cartPizzaArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_list);

        addToCartHomeBtn = findViewById(R.id.addToCartHomeBtn);
        addToCartHomeBtn.setOnClickListener(this);
        customPizzaHomeBtn = findViewById(R.id.customPizzaHomeBtn);
        customPizzaHomeBtn.setOnClickListener(this);
        viewCartBtn = findViewById(R.id.viewCartBtn);
        viewCartBtn.setOnClickListener(this);

        ArrayList<PizzaDetails> pizzaOptions = new ArrayList<>();
        pizzaOptions.add(0, new PizzaDetails("Margherita", "Classic delight with mozzarella cheese", 2));
        pizzaOptions.add(1, new PizzaDetails("The Unthinkable Pizza", "Loaded with plant based protein topping along with black olives and red paprika", 3));
        pizzaOptions.add(2,new PizzaDetails("Pepper Barbecue Chicken", "Pepper barbecue chicken for that extra zing", 4));
        pizzaOptions.add(3,new PizzaDetails("Chicken Golden Delight", "Double pepper barbecue chicken, golden corn and extra cheese, true delight", 4));

        ArrayAdapter adapterPizzaOptions = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, pizzaOptions);

        ListView pizzaOptionsLV = findViewById(R.id.pizzaOptionsLV);
        pizzaOptionsLV.setAdapter(adapterPizzaOptions);

        pizzaOptionsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pizzaName = pizzaOptions.get(position).name;
                pizzaDesc = pizzaOptions.get(position).desc;
                pizzaPrice = pizzaOptions.get(position).price;
                pizzaSelected = pizzaOptions.get(position).toString();
            }
        });

        cartPizzaArrayList = getIntent().getStringArrayListExtra("updateCartPizzaArrayList_key");
        if (cartPizzaArrayList == null){
            cartPizzaArrayList = new ArrayList<>();
        }
    }

    @Override
    public void onClick(View view) {
        Intent n = new Intent(PizzaListActivity.this, MainActivity.class);
        Intent m = new Intent(PizzaListActivity.this, CartPizzaListActivity.class);
        switch(view.getId()){
            case R.id.addToCartHomeBtn:
                cartPizzaArrayList.add(pizzaSelected);
                PrefConfig.writeListInPref(getApplicationContext(), cartPizzaArrayList);
                break;
            case R.id.customPizzaHomeBtn:
                n.putExtra("pizzaName_key", pizzaName);
                n.putExtra("pizzaDesc_key", pizzaDesc);
                n.putExtra("pizzaPrice_key", String.valueOf(pizzaPrice));
                n.putStringArrayListExtra("cartPizzaArrayList_key", cartPizzaArrayList);
                startActivity(n);
                break;
            case R.id.viewCartBtn:
                cartPizzaArrayList = PrefConfig.readListFromPref(this);
                if (cartPizzaArrayList == null){
                    cartPizzaArrayList = new ArrayList<>();
                }
                m.putStringArrayListExtra("cartPizzaArrayList_key", cartPizzaArrayList);
                startActivity(m);
                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}