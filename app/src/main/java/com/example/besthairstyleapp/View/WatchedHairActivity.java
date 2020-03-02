package com.example.besthairstyleapp.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.Adapter.RecycleViewAdapter;
import com.example.besthairstyleapp.R;

public class WatchedHairActivity extends AppCompatActivity {

    RecyclerView recycleview;
    int[]  postNewUserIcon = {R.drawable.hair_cutting_icon,R.drawable.hair_coloring,R.drawable.hair_shampoo_icon,R.drawable.hair_perm_icon,R.drawable.hair_package_icon,R.drawable.hair_health_icon};
    String [] postNewuserName ={"tony","Tom","Jason"};
    String [] postNewsTime ={"11-12-2019","11-2-2019","11-1-2019","10-1-2019"};
    int [] plusicon;
    RecycleViewAdapter recycleViewAdapter;
    RecycleViewAdapter hor_recycleViewAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        initVerticallyRecycleView();
        initHorizontalRecycleView();
    }

    public void initVerticallyRecycleView(){
        recycleview =(RecyclerView)findViewById(R.id.recycle_view);
        recycleViewAdapter =new RecycleViewAdapter(this,postNewUserIcon,postNewuserName,postNewsTime,plusicon);
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
    }

    public void initHorizontalRecycleView(){
        recycleview =(RecyclerView)findViewById(R.id.horizontal_recycle_view);
        hor_recycleViewAdapter =new RecycleViewAdapter(this,postNewUserIcon,postNewuserName,postNewsTime,plusicon);
        recycleview.setAdapter(hor_recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }
}