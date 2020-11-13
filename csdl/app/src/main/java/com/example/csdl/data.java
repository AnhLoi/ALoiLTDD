package com.example.csdl;

import java.util.ArrayList;

public class data {
    public static data dt;
    ArrayList<SinhVien> arrSV= new ArrayList<SinhVien>();
    static {
        dt= new data();
    }
    public static data getDt(){
        return dt;
    }

}
