package com.example.besthairstyleapp.View;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Adapter.GridAdapter;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;

public class MainActivity extends AppCompatActivity {
    ImageView menuButton;
    GridView grid;
    ImageView homeIconBtn;
    ImageView hairIconBtn;
    ImageView scheduleIconBtn;
    ImageView userIconBtn;
    private BaseAdapter adapter;
    private static final int COLUMNS = 2;
    private String[] dataStoreHairName = {"Hair cutting","Hair coloring","Hair shampoo","Hair perm","Hair Package","Hair health"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        homeIconBtn = (ImageView) findViewById(R.id.home_icon_button);
        hairIconBtn = (ImageView) findViewById(R.id.hair_icon_button);
        scheduleIconBtn = (ImageView) findViewById(R.id.schedule_icon_button);
        userIconBtn = (ImageView) findViewById(R.id.user_icon_buttin);
        initializeGridview();

    }
    public void initializeGridview() {
        GridView grid = (GridView) findViewById(R.id.grid);
        HairService hairServiceTypeModel = new HairService();
        adapter = new GridAdapter(this,dataStoreHairName, hairServiceTypeModel.getdataStoreHairImg());
        grid.setAdapter(adapter);
        grid.setNumColumns(COLUMNS);
    }


}
