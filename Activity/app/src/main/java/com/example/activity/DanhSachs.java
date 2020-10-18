package com.example.activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DanhSachs extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpen=(Button)
                findViewById(R.id.btnOpenProfile);
        btnOpen.setOnClickListener(new
                                           View.OnClickListener() {
                                               public void onClick(View arg0) {
                                                   doOpenProfile();
                                               }
                                           });
    }
    public void doOpenProfile()
    {
        Intent myIntent=new Intent(this, ContactsContract.Profile.class);
        startActivity(myIntent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.danh_sach, menu);
        return true;
    }
}