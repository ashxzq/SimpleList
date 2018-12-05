package com.example.ash.simplelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //Attempt to Add an Item to List
        Button ToAddItem = (Button)findViewById(R.id.ToAddItem);
        ToAddItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent AddANewItem = new Intent(getApplicationContext(), AddItemPage.class);
                // show how to pass information to another activity
                startActivity(AddANewItem);
            }
        });

        //Attempt to View Items already added
        Button ToViewItem = (Button)findViewById(R.id.ToViewItem);
        ToViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SeeWaysToViewItems = new Intent(getApplicationContext(), WaysToViewItems.class);
                startActivity(SeeWaysToViewItems);
            }
        });

    }
}
