package com.example.csdl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    ArrayList<SinhVien> arr;
    Context ct;
    public SinhVienAdapter(@NonNull Context context, int resource, ArrayList<SinhVien> o) {
        super(context, resource, o);
        this.ct =context;
        this.arr= new ArrayList<>(data.getDt().arrSV);
    }
@Override
public void notifyDataSetChanged(){
        this.arr= data.getDt().arrSV;
        super.notifyDataSetChanged();
}
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
       View row= convertView;
       viewHolder v;
       if(row== null){
           LayoutInflater inflater= (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row= inflater.inflate(R.layout.item_sinh_vien, null);
            v= new viewHolder(row);


       }
        v= new viewHolder(row);
       if(arr.size()>0){
           System.out.println("dugh");
           v.setView(arr.get(position));
       }
       return row;
    }
    class viewHolder{
        TextView txtTen, txtSDT, txtEmail, txtlop;
        ImageView imgGT;
        public viewHolder(View v){
            txtTen= (TextView)v.findViewById(R.id.txtTen);
            txtlop= (TextView)v.findViewById(R.id.txtlop);
            txtEmail= (TextView)v.findViewById(R.id.txtEmail);
            txtSDT= (TextView)v.findViewById(R.id.txtSDT);
            imgGT= (ImageView)v.findViewById(R.id.imgGT);
        }
        public void setView(SinhVien sv){
            txtTen.setText((sv.getTen()));
            txtSDT.setText((sv.getSodt()));
            txtlop.setText((sv.getLophoc()));
            txtEmail.setText((sv.getEmail()));
            System.out.println("dugh)"+ sv.getGioitinh());
           if(sv.getGioitinh().equals("nu")){
               imgGT.setImageResource(R.drawable.nu);
           }else{
               imgGT.setImageResource(R.drawable.nam);
           }
        }
    }
}
