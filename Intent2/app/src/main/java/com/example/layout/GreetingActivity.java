package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class GreetingActivity extends AppCompatActivity {

    private TextView textViewMessage;
    private Button buttonBack;

    private String fullName;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        this.textViewMessage =(TextView) this.findViewById(R.id.textView_message);
        this.buttonBack = (Button) this.findViewById(R.id.button_back);

        this.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        // Intent is passed into
        Intent intent = this.getIntent();

        this.fullName = intent.getStringExtra("fullName");
        this.message = intent.getStringExtra("message");

        this.textViewMessage.setText(this.message );
    }

    // When completed this Activity, send feedback to the caller.
    @Override
    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        String feedback = "OK, Hello " + this.fullName + ". How are you?";
        data.putExtra("feedback", feedback);

        // Activity finished ok, return the data
        this.setResult(Activity.RESULT_OK, data);
        super.finish();
    }


    // The method is called when the user clicks the "Back" button.
    public void goBack()  {
        // Calling onBackPressed() method to back to the previous Activity.
        this.onBackPressed();
    }


}