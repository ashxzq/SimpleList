package com.example.ash.simplelist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class myListView extends AppCompatActivity {

    private static final String TAG = "myListView";
    ArrayList<Product> productList;
    ListView myListView;
    TextView Count;
    TextView Total;

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
        setContentView(R.layout.activity_my_list_view);
        myListView = (ListView) findViewById(R.id.myListView1);
        Count = (TextView)findViewById(R.id.Count);
        Total = (TextView)findViewById(R.id.total);
        Log.d(TAG, "onCreate: Started.");

        //loadData from shared preferences
        loadData();

        if (productList == null || productList.size() == 0) {
            Intent intent = new Intent(this, AddItemPage.class);
            startActivity(intent);
        } else {
            Count.setText(Integer.toString(productList.size()));
            double total = 0;
            for (int i = 0; i < productList.size(); i++) {
                total += Double.parseDouble(productList.get(i).price);
            }
            Total.setText(Double.toString(total));
            ProductListAdapter adapter = new ProductListAdapter(this, R.layout.listview_detail, productList);
            myListView.setAdapter(adapter);
        }
    }



        //Bundle bundleObject = getIntent().getExtras();
        //productList = (ArrayList<Product>) bundleObject.getSerializable("products");
        //myListView = (ListView)findViewById(R.id.myListView1);
        //productList = getIntent().getExtras().getParcelableArrayList("productList");

        //ProductListAdapter adapter = new ProductListAdapter(this, R.layout.listview_detail, productList);
        //myListView.setAdapter(adapter);


}
