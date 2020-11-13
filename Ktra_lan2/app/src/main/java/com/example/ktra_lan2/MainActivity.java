package com.example.ktra_lan2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Product> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GridViewAdapter(this, image_details));

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Product country = (Product) o;
                Toast.makeText(MainActivity.this, "Selected :"
                        + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }






    public List<Product> getProductList(){
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.chomchom, "Chôm chôm", "40.000đ/ ky"));
        productList.add(new Product(R.drawable.saurieng, "Sầu riêng hạt lép", "109.000đ/ ky"));
        productList.add(new Product(R.drawable.mangcau, "Mãng cầu", "60.000đ/ ky"));
        productList.add(new Product(R.drawable.dautay ,"Dâu tây Đà Lạt", "200.000đ/ ky"));
        productList.add(new Product(R.drawable.dudu, "Đu đủ ruột đỏ", "45.000đ/ ky"));
        productList.add(new Product(R.drawable.luudo, "Lựu đỏ", "50.000đ/ ky"));
        productList.add(new Product(R.drawable.cam, "Cam", "55.000đ/ ky"));
        productList.add(new Product(R.drawable.nhomi, "Nho đen Mĩ", "150.000đ/ ky"));
        productList.add(new Product(R.drawable.bobooth, "Bơ booth", "20.000đ/ ky"));
        productList.add(new Product(R.drawable.logo, "Title 1", "This is description 1"));
        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(), productList.get(i).getTitle() + " - " + productList.get(i).getDescription(), Toast.LENGTH_SHORT).show();
        }
    };



}