package com.example.ash.simplelist;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class myListView extends AppCompatActivity {

    ListView myListView;
    String[] items;
    String[] locations;
    String[] prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView1);
        items = res.getStringArray(R.array.items);
        locations = res.getStringArray(R.array.Locations);
        prices = res.getStringArray(R.array.prices);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, locations);
        myListView.setAdapter(itemAdapter);

    }
}
