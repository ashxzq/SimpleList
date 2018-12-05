package com.example.ash.simplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WaysToViewItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ways_to_view_items);

        //View Items sorted by List Names
        Button ViewByListName = (Button)findViewById(R.id.ViewByListNameBtn);
        ViewByListName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ItemViewByListName = new Intent(getApplicationContext(), com.example.ash.simplelist.ItemViewByListName.class);
                startActivity(ItemViewByListName);
            }
        });

        //View Items sorted by dates
        Button ViewByDates = (Button)findViewById(R.id.ViewByDateBtn);
        ViewByDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ItemViewByDate = new Intent(getApplicationContext(), com.example.ash.simplelist.ItemViewByDate.class);
                startActivity(ItemViewByDate);
            }
        });

        //View items sorted by locations
        Button ViewByLocation = (Button)findViewById(R.id.ViewByLocationBtn);
        ViewByLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ItemViewByLocation = new Intent(getApplicationContext(), com.example.ash.simplelist.ItemViewByLocation.class);
                startActivity(ItemViewByLocation);
            }
        });

        //View items sorted by price
        Button ViewByPrice = (Button)findViewById(R.id.ViewByPriceBtn);
        ViewByPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ItemViewByPrice = new Intent(getApplicationContext(), com.example.ash.simplelist.ItemViewByPrice.class);
                startActivity(ItemViewByPrice);
            }
        });
    }
}
