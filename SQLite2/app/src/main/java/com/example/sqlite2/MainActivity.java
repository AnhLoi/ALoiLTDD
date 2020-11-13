package com.example.sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  Button btnThem;
    private  Button btnSua;
    private Button btnXoa;
    private EditText etId;
    private EditText etName;
    private EditText etToan;
    private EditText etLi;
    private EditText etHoa;
    private MyDatabaseHelper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabase= new MyDatabaseHelper(this);
        initView();
        initListener();
    }
    private void initListener(){
        btnThem.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           String name= etName.getText().toString();
                                           String toan= etToan.getText().toString();
                                           String li= etLi.getText().toString();
                                           String hoa= etHoa.getText().toString();
                                           boolean bl= myDatabase.insertData(name, toan ,li , hoa);

                                           if(bl) {
                                               Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                                           }else {
                                               Toast.makeText(MainActivity.this, "Insert fall", Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   }
        );
        btnSua.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                      }
                                  }
        );

        btnXoa.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                      }
                                  }
        );
    }

    private void initView(){
        btnThem = (Button) findViewById(R.id.btn_them);
        btnSua = (Button) findViewById(R.id.btn_sua);
        btnXoa = (Button) findViewById(R.id.btn_xoa);
        etId= (EditText) findViewById(R.id.et_id);
        etName= (EditText) findViewById(R.id.et_name);
        etToan= (EditText) findViewById(R.id.et_toan);
        etLi= (EditText) findViewById(R.id.et_li);
        etHoa= (EditText) findViewById(R.id.et_hoa);



    }
}