package com.example.ash.simplelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends ArrayAdapter<Product> {

    private static final String TAG = "ProductListAdapter";

    private Context myContext;
    int myResource;

    public ProductListAdapter(Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        this.myContext = context;
        this.myResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get product information
        String name = getItem(position).getName();
        String location = getItem(position).getLocation();
        String price = getItem(position).getPrice();

        //Create product with the information
        Product product = new Product(name, location, price);

        LayoutInflater inflater = LayoutInflater.from(myContext);
        convertView = inflater.inflate(myResource, parent, false);

        TextView tvName = (TextView)convertView.findViewById(R.id.name);
        TextView tvLocation = (TextView)convertView.findViewById(R.id.location);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.price);

        tvName.setText(name);
        tvLocation.setText(location);
        tvPrice.setText(price);

        return convertView;
    }
}
