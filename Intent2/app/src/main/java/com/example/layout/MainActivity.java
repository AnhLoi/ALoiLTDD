package com.example.layout;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFullName;
    private TextView textFeedback;

    private Button buttonSendMessage;

    public static final int MY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextFullName = (EditText)this.findViewById(R.id.editText_fullName);
        this.textFeedback = (TextView)this.findViewById(R.id.textView_feedback);

        this.buttonSendMessage = (Button)this.findViewById(R.id.button_sendMessage);

        this.buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    // When 'Greeting Activity' completed, it sends back a feedback.
    // (If you have started it by startActivityForResult())
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == MY_REQUEST_CODE) {
            String feedback = data.getStringExtra("feedback");
            this.textFeedback.setText(feedback);
        } else {
            this.textFeedback.setText("!?");
        }
    }

    // The method is called when the user clicks on "Send Message to GreetingActivity" button.
    public void sendMessage( )  {
        String fullName= this.editTextFullName.getText().toString();
        String message = "Hello, Please say hello me!";

        Intent intent = new Intent(this,GreetingActivity.class);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message", message);

        // Start Activity and no need feedback.
        // this.startActivity(intent);

        // Start Activity and get feedback.
        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }

}