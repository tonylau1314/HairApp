package com.example.besthairstyleapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Adapter.GridAdapter;
import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;

public class MainActivity extends AppCompatActivity {
      ImageView menuButton;
      GridView grid;
      ImageView homeIconBtn;
      ImageView hairIconBtn;
      ImageView scheduleIconBtn;
      ImageView userIconBtn;
      BaseAdapter adapter;
      static final int COLUMNS = 2;
      String[] dataStoreHairName = {"Hair cutting","Hair coloring","Hair shampoo","Hair perm","Hair Package","Hair health"};
      int onclicknumber;
      Intent intent;
      Intent getintent;
      HairServiceController hairServiceController = new HairServiceController();
      HairService hairService =new HairService();
       @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        homeIconBtn = (ImageView) findViewById(R.id.home_icon_button);
        hairIconBtn = (ImageView) findViewById(R.id.hair_icon_button);
        scheduleIconBtn = (ImageView) findViewById(R.id.schedule_icon_button);
        userIconBtn = (ImageView) findViewById(R.id.user_icon_buttin);

//        hairService.uploadHairSerivceData("andrewcox@hotmail.com","Andrew Cox","Nature style","2018","Forest","1hr","160","Hair cutting","China");
         initializeGridview();
         gridOnclick();

     }

    private void initializeGridview() {
        grid = (GridView) findViewById(R.id.grid);
        adapter = new GridAdapter(this,dataStoreHairName, hairService.getdataStoreHairImg());
        grid.setAdapter(adapter);
        grid.setNumColumns(COLUMNS);
    }

    private void gridOnclick(){
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                onclicknumber= position;
                changeMainPage();
            }
        });
    }



    private void changeMainPage(){
            intent = new Intent(this, WatchedHairActivity.class);
             passDataToNexActivity();
            this.startActivity(intent);
      }

    private void passDataToNexActivity(){
        intent.putExtra("onclicknumber", onclicknumber);
    }

}
