package com.example.cuoiky;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_REGISTER =1 ;
    private Context context;

    private EditText editName;
    private EditText editEmail;
    private EditText editPhone;
    private EditText editPassword;

    private EditText editDate;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        connectView();
    }

    private void connectView() {
        editName = (EditText) findViewById(R.id.edit_name_321);
        editEmail = (EditText) findViewById(R.id.edit_email_321);
        editPhone = (EditText) findViewById(R.id.edit_phone_321);

        editPassword = (EditText) findViewById(R.id.edit_pass_321);
        editDate = (EditText) findViewById(R.id.edit_date_321);

        progressBar = (ProgressBar) findViewById(R.id.progressLogin_321);

        findViewById(R.id.btn_Register_321).setOnClickListener(this);
        findViewById(R.id.btn_back_321).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_Register_321:
                register();
                break;
            case R.id.btn_back_321:
                goBack();
                break;
        }
    }

    private void register() {
        boolean error = false;

        showProgress(true);
        // when process we must have sometime

        // get data
        String userName = editName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String email = editEmail.getText().toString().trim();

        String dateofbirth = editDate.getText().toString().trim();



        // password empty
        if (TextUtils.isEmpty(password)) {
            editPassword.requestFocus();
            editPassword.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // username empty
        if (TextUtils.isEmpty(userName)) {
            editName.requestFocus();
            editName.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        // password empty
        if (TextUtils.isEmpty(phone)) {
            editPhone.requestFocus();
            editPhone.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        // password empty
        if (TextUtils.isEmpty(email)) {
            editEmail.requestFocus();
            editEmail.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        // password empty

        // password empty
        if (TextUtils.isEmpty(dateofbirth)) {
            editDate.requestFocus();
            editDate.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }



        // all data is ok
        showProgress(false);

        if (!error) {
            // create intent to send data back Login Activity
            Intent intent = new Intent();

            // send data
            intent.putExtra(LoginActivity.KEY_USER_FROM_REGISTER, userName);

            setResult(RESULT_OK, intent);
            finish();
        }
    }
    private void goBack() {
        Intent intent = new Intent(context, LoginActivity.class);
        startActivityForResult(intent, REQUEST_CODE_REGISTER);
    }

    private void showProgress(boolean isShow) {
        progressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
        findViewById(R.id.login_form_321).setVisibility(!isShow ? View.VISIBLE : View.GONE);
    }

}