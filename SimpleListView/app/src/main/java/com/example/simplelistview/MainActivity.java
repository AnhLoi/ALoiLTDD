package com.example.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listview);

        //

        UserAcount tom = new UserAcount("Tom","admin");
        UserAcount jerry = new UserAcount("Jerry","user");
        UserAcount donald = new UserAcount("Donald","guest", false);

        UserAcount[] users = new UserAcount[]{tom,jerry, donald};


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<UserAcount> arrayAdapter
                = new ArrayAdapter<UserAcount>(this, android.R.layout.simple_list_item_1 , users);

        listView.setAdapter(arrayAdapter);
    }


}
