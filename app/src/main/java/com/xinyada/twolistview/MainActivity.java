package com.xinyada.twolistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lv_left;
    private ListView lv_right;
    ArrayList<Bean.AddressEntity> leftlist;
    private ArrayList<String> rightlist;
    private LeftAdapter leftAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_left = (ListView) findViewById(R.id.lv_left);
        lv_right = (ListView) findViewById(R.id.lv_right);
        initModle();
        leftAdapter = new LeftAdapter(MainActivity.this, leftlist);
        lv_left.setAdapter(leftAdapter);
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                rightlist = (ArrayList<String>) leftlist.get(i).getArea();
                initAdapter(rightlist);
                leftAdapter.notifyDataSetChanged();
            }
        });
        initAdapter((ArrayList<String>) leftlist.get(0).getArea());

    }

    private void initAdapter(ArrayList<String> rightlist) {
        RightAdapter rightAdapter = new RightAdapter(MainActivity.this, rightlist);
        lv_right.setAdapter(rightAdapter);
        rightAdapter.notifyDataSetChanged();
    }

    private void initModle() {
        leftlist = new ArrayList<Bean.AddressEntity>();
        Gson gson = new Gson();
        String json = "{\"result\":\"Y\", \"address\":[{\"name\":\"衣服\",\"custId\":\""
                + R.mipmap.ic_launcher
                + "\", \"area\":[\"呢大衣\",\"小西服\",\"背心\",\"外套\",\"运动服\"]},{\"name\":\"裤子\", \"custId\":\""
                + R.mipmap.ic_launcher
                + "\",\"area\":[\"长裤子\",\"短裤子\",\"秋裤\",\"牛仔裤\",\"优衣库\",\"各种裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\",\"短裤子\"]}]}";
        java.lang.reflect.Type type = new TypeToken<Bean>() {
        }.getType();
        Bean b = gson.fromJson(json, type);
        leftlist.addAll(b.getAddress());
    }
}
