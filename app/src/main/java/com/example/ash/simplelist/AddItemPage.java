package com.example.ash.simplelist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddItemPage extends AppCompatActivity {

    Button addNewItem;
    ArrayList<Product> productList;
    EditText enterProductName;
    EditText enterLocation;
    EditText enterPrice;

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(productList);
        editor.putString("products", json);
        editor.commit();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("products", null);
        Type type = new TypeToken<ArrayList<Product>>(){}.getType();
        productList = gson.fromJson(json, type);

        if (productList == null) {
            productList = new ArrayList<Product>();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_page);

        //get add-item button
        addNewItem = (Button)findViewById(R.id.AddNewItem);
        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enterProductName = (EditText)findViewById(R.id.EnterProductName);
                enterLocation = (EditText)findViewById(R.id.EnterLocation);
                enterPrice = (EditText)findViewById(R.id.EnterPrice);

                //utilize inputs
                String name = enterProductName.getText().toString();
                String location = enterLocation.getText().toString();
                String price = enterPrice.getText().toString();

                //load dara from sharedpreferences
                loadData();

                //add new data
                if (name == null || name.trim().equals("") || location == null || location.length() == 0 || price == null || price.length() == 0){
                    Toast.makeText(getBaseContext(), "Product Name/Location/Price is Empty", Toast.LENGTH_LONG).show();
                } else {
                    Product addnew = new Product(name, location, price);
                    productList.add(addnew);
                    saveData();
                }

                //transfer data to viewitems page
                Intent intent = new Intent(AddItemPage.this, MainPage.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("products",productList);
                //intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
