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
    Button deleteSelectedBtn;
    Button emptyCartBtn;
    Button updateBtn;
    ListView pizzaCartLV;
    private String itemAtPosition;
    private int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_pizza_list);

        backToHomeBtn = findViewById(R.id.backToHomeBtn);
        backToHomeBtn.setOnClickListener(this);

        deleteSelectedBtn = findViewById(R.id.deleteSelectedBtn);
        deleteSelectedBtn.setOnClickListener(this);
        emptyCartBtn = findViewById(R.id.emptyCartBtn);
        emptyCartBtn.setOnClickListener(this);
        updateBtn = findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(this);

        Intent intent = getIntent();
        cartPizzaArrayList = intent.getStringArrayListExtra("cartPizzaArrayList_key");

        ArrayAdapter adapterPizzaCartList = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cartPizzaArrayList);
        pizzaCartLV = findViewById(R.id.pizzaCartLV);
        pizzaCartLV.setAdapter(adapterPizzaCartList);

        pizzaCartLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemAtPosition = cartPizzaArrayList.get(position);
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent n = new Intent(CartPizzaListActivity.this, PizzaListActivity.class);
        switch(view.getId()){
            case R.id.backToHomeBtn:
                n.putStringArrayListExtra("updateCartPizzaArrayList_key", cartPizzaArrayList);
                startActivity(n);
                break;
            case R.id.emptyCartBtn:
                cartPizzaArrayList.clear();
                PrefConfig.writeListInPref(getApplicationContext(), cartPizzaArrayList);
                Toast.makeText(this, "Cart Cleared", Toast.LENGTH_SHORT).show();
                this.recreate();
                cartPizzaArrayList = PrefConfig.readListFromPref(this);
                if (cartPizzaArrayList == null){
                    cartPizzaArrayList = new ArrayList<>();
                }
                break;
            case R.id.deleteSelectedBtn:
                cartPizzaArrayList.remove(itemAtPosition);
                PrefConfig.writeListInPref(getApplicationContext(), cartPizzaArrayList);
                Toast.makeText(this, "Item Removed", Toast.LENGTH_SHORT).show();
                this.recreate();
                cartPizzaArrayList = PrefConfig.readListFromPref(this);
                if (cartPizzaArrayList == null){
                    cartPizzaArrayList = new ArrayList<>();
                }
                break;
            case R.id.updateBtn:

                break;
            default:
                Toast.makeText(this, "View not Implemented", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}