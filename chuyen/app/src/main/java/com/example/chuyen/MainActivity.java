package com.example.chuyen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_lISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        stubList.inflate();
        stubGrid.inflate();

        listView = (ListView) findViewById(R.id.mylistview);
        gridView = (GridView) findViewById(R.id.mygridview);

        getProductList();

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_lISTVIEW);

        listView.setOnItemClickListener(onItemClick);
        gridView.setOnItemClickListener(onItemClick);

        switchView();
    }

    private void switchView() {
        if(VIEW_MODE_lISTVIEW == currentViewMode){
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        }
        else {
            stubList.setVisibility(View.GONE);
            stubGrid.setVisibility(View.VISIBLE);
        }
        setAdapter();
    }

    private void setAdapter() {
        if (VIEW_MODE_lISTVIEW == currentViewMode){
            listViewAdapter = new ListViewAdapter(this, R.layout.list_item, productList);
            listView.setAdapter(listViewAdapter);
        }
        else {
            gridViewAdapter = new GridViewAdapter(this, R.layout.grid_item, productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    public List<Product> getProductList(){
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.logo, "Võ Thị Ánh Lời", "This is description 1"));
        productList.add(new Product(R.drawable.chomchom, "Chôm chôm", "40.000đ/ ky"));
        productList.add(new Product(R.drawable.saurieng, "Sầu riêng hạt lép", "109.000đ/ ky"));
        productList.add(new Product(R.drawable.mangcau, "Mãng cầu", "60.000đ/ ky"));
        productList.add(new Product(R.drawable.dautay ,"Dâu tây Đà Lạt", "200.000đ/ ky"));
        productList.add(new Product(R.drawable.dudu, "Đu đủ ruột đỏ", "45.000đ/ ky"));
        productList.add(new Product(R.drawable.luudo, "Lựu đỏ", "50.000đ/ ky"));
        productList.add(new Product(R.drawable.cam, "Cam", "55.000đ/ ky"));
        productList.add(new Product(R.drawable.nhomi, "Nho đen Mĩ", "150.000đ/ ky"));
        productList.add(new Product(R.drawable.bobooth, "Bơ booth", "20.000đ/ ky"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(getApplicationContext(), productList.get(i).getTitle() + " - " + productList.get(i).getDescription(), Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_menu1:
                if (VIEW_MODE_lISTVIEW == currentViewMode){
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                }
                else {
                    currentViewMode = VIEW_MODE_lISTVIEW;
                }
                switchView();
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();
                break;
        }
        return true;
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    productList.remove(position);
                    //cập nhật lại listview
                    listViewAdapter.notifyDataSetChanged();

                }
            });
            alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }

    }
}

