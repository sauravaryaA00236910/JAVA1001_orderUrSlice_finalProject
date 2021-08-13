package com.saurav.orderurslice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private float totalPrice;
    private EditText totalPriceET;
    private Button btnAddToCart;
    private TextView pizzaTypeTV;
    private TextView pizzaDescTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalPrice = 0;

        String pizzaName = getIntent().getStringExtra("pizzaName_key");
        pizzaTypeTV = findViewById(R.id.pizzaTypeTV);
        pizzaTypeTV.setText(pizzaName);

        String pizzaDesc = getIntent().getStringExtra("pizzaDesc_key");
        pizzaDescTV = findViewById(R.id.pizzaDescTV);
        pizzaDescTV.setText(pizzaDesc);


        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(MainActivity.this, CartPizzaListActivity.class);
                n.putExtra("pizzaType_key", (Parcelable) pizzaTypeTV);
//                startActivity(n);
//                Intent d = new Intent(MainActivity.this, CartPizzaListActivity.class);
                n.putExtra("pizzaDesc_key", (Parcelable) pizzaDescTV);
                // loop through toppings and create a String with items
                // putExtra(toppings)

                // putExtra(chicken?)
                // putExtra(onions?)
                // ...
                startActivity(n);

                startActivity(new Intent(getApplicationContext(), CartPizzaListActivity.class));
            }
        });

        totalPriceET = findViewById(R.id.totalPriceET);
        CheckBox extraCheeseCheck = findViewById(R.id.extraCheeseCheck);
        EditText extraCheesePrice = findViewById(R.id.extraCheesePrice);

        extraCheeseCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    totalPrice += Float.parseFloat(extraCheesePrice.getText().toString());
                    totalPriceET.setText(String.valueOf(totalPrice));
                }else {
                    totalPrice -=1;
                    totalPriceET.setText(String.valueOf(totalPrice));
                }
            }
        });

//        PizzaSize[] sizes = {new PizzaSize("Regular", 1.5f), new PizzaSize("Medium", 3f), new PizzaSize("Large", 5f)};
        ArrayList<PizzaSize> sizes = new ArrayList<>();
        sizes.add(0, new PizzaSize("None", 0f));
        sizes.add(1, new PizzaSize("Regular", 1.5f));
        sizes.add(2, new PizzaSize("Medium", 3f));
        sizes.add(3, new PizzaSize("Large", 5f));

        ArrayAdapter adapterSize = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, sizes);

        Spinner sizeSpinner = findViewById(R.id.selectSizeSpinner);
        sizeSpinner.setAdapter(adapterSize);

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                totalPrice += sizes.get(position).price;
                totalPriceET.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        PizzaCrust[] crusts = {new PizzaCrust("New Hand Tossed", 1f), new PizzaCrust("Cheese Burst", 2f), new PizzaCrust("Fresh Pan", 2f), new PizzaCrust("Classic Hand Tossed", 1f)};
        ArrayList<PizzaCrust> crusts = new ArrayList<>();
        crusts.add(0, new PizzaCrust("None", 0f));
        crusts.add(1, new PizzaCrust("New Hand Tossed", 1f));
        crusts.add(2, new PizzaCrust("Cheese Burst", 2f));
        crusts.add(3, new PizzaCrust("Fresh Pan", 2f));
        crusts.add(4, new PizzaCrust("Classic Hand Tossed", 2f));
        ArrayAdapter adapterCrust = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, crusts);
        Spinner crustSpinner = findViewById(R.id.selectCrustSpinner);
        crustSpinner.setAdapter(adapterCrust);

        crustSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                totalPrice += crusts.get(position).price;
                totalPriceET.setText(String.valueOf(totalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        PizzaVegTopping[] vegToppings = {new PizzaVegTopping("Grilled Mushrooms", 0.5f), new PizzaVegTopping("Onion", 0.5f), new PizzaVegTopping("Crisp Capsicum", 0.5f), new PizzaVegTopping("Fresh Tomato", 0.5f), new PizzaVegTopping("Paneer", 0.5f), new PizzaVegTopping("Red Pepper", 0.5f), new PizzaVegTopping("Jalapeno", 0.5f), new PizzaVegTopping("Golden Corn", 0.5f), new PizzaVegTopping("Black Olive", 0.5f)};
        ArrayList<PizzaVegTopping> vegToppings = new ArrayList<>();
        vegToppings.add(0, new PizzaVegTopping("None", 0f));
        vegToppings.add(1, new PizzaVegTopping("Grilled Mushrooms", 0.5f));
        vegToppings.add(2, new PizzaVegTopping("Onion", 0.5f));
        vegToppings.add(3, new PizzaVegTopping("Crisp Capsicum", 0.5f));
        vegToppings.add(4, new PizzaVegTopping("Fresh Tomato", 0.5f));
        vegToppings.add(5, new PizzaVegTopping("Paneer", 0.5f));
        vegToppings.add(6, new PizzaVegTopping("Red Pepper", 0.5f));
        vegToppings.add(7, new PizzaVegTopping("Jalapeno", 0.5f));
        vegToppings.add(8, new PizzaVegTopping("Golden Corn", 0.5f));
        vegToppings.add(9, new PizzaVegTopping("Black Olive", 0.5f));
        ArrayAdapter adapterVegTopping = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, vegToppings);
        ListView vegToppingsLV = findViewById(R.id.vegToppingsLV);
        vegToppingsLV.setAdapter(adapterVegTopping);

        vegToppingsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView item = (CheckedTextView) view;
                item.toggle();
                if(item.isChecked()){
                    totalPrice += vegToppings.get(position).price;
                    totalPriceET.setText(String.valueOf(totalPrice));
                }else{
                    totalPrice -= vegToppings.get(position).price;
                    totalPriceET.setText(String.valueOf(totalPrice));
                }
            }
        });

        ArrayList<PizzaNonVegTopping> nonVegToppings = new ArrayList<>();
        nonVegToppings.add(0, new PizzaNonVegTopping("None", 0f));
        nonVegToppings.add(1, new PizzaNonVegTopping("Pepper Barbeque Chicken", 1f));
        nonVegToppings.add(2, new PizzaNonVegTopping("Peri-Peri Chicken", 1f));
        nonVegToppings.add(3, new PizzaNonVegTopping("Grilled Chicken Rasher", 1f));
        nonVegToppings.add(4, new PizzaNonVegTopping("Chicken Sausage", 1f));
        nonVegToppings.add(5, new PizzaNonVegTopping("Chicken Tikka", 1f));
        nonVegToppings.add(6, new PizzaNonVegTopping("Chicken Pepperoni", 1f));

        ArrayAdapter adapterNonVegTopping = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, nonVegToppings);
        ListView nonVegToppingsLV = findViewById(R.id.nonVegToppingsLV);
        nonVegToppingsLV.setAdapter(adapterNonVegTopping);

        nonVegToppingsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckedTextView item = (CheckedTextView) view;
                item.toggle();
                if(item.isChecked()){
                    totalPrice += nonVegToppings.get(position).price;
                    totalPriceET.setText(String.valueOf(totalPrice));
                }else{
                    totalPrice -= nonVegToppings.get(position).price;
                    totalPriceET.setText(String.valueOf(totalPrice));
                }
            }
        });
    }
}