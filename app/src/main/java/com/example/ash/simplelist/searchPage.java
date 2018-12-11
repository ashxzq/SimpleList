package com.example.ash.simplelist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class searchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        //Attempt to launch an activity outside app
        Button GoogleBtn = (Button)findViewById(R.id.GoogleBtn);
        GoogleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://www.google.com/";
                Uri webaddress1 = Uri.parse(google);
                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress1);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });

        Button AmazonBtn = (Button)findViewById(R.id.AmazonBtn);
        AmazonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amazon = "http://www.amazon.com/";
                Uri webaddress2 = Uri.parse(amazon);
                Intent goToAmazon = new Intent(Intent.ACTION_VIEW, webaddress2);
                if (goToAmazon.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToAmazon);
                }
            }
        });

        Button WalgreenBtn = (Button)findViewById(R.id.WalgreenBtn);
        WalgreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String walgreen = "http://www.walgreen.com/";
                Uri webaddress3 = Uri.parse(walgreen);
                Intent goToWalgreen = new Intent(Intent.ACTION_VIEW, webaddress3);
                if (goToWalgreen.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToWalgreen);
                }
            }
        });

        Button CountyMarketBtn = (Button)findViewById(R.id.CountyMarket);
        CountyMarketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countyMarket = "http://www.mycountymarket.com/";
                Uri webaddress4 = Uri.parse(countyMarket);
                Intent goToCounty = new Intent(Intent.ACTION_VIEW, webaddress4);
                if (goToCounty.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToCounty);
                }
            }
        });
    }
}
