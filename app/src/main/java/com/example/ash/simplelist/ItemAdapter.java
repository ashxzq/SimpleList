package com.example.ash.simplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] locations;
    String[] prices;

    public ItemAdapter(Context c, String[] i, String[] p, String[] l) {
        items = i;
        prices = p;
        locations = l;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.listview_detail, null);
        TextView name = (TextView) v.findViewById(R.id.name);
        TextView location = (TextView) v.findViewById(R.id.location);
        TextView price = (TextView) v.findViewById(R.id.price);

        String itemname = items[position];
        String itemlocation =  locations[position];
        String itemprice = prices[position];

        name.setText(itemname);
        location.setText(itemlocation);
        price.setText(itemprice);

        return v;
    }
}
