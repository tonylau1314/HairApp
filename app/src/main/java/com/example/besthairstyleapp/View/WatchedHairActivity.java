package com.example.besthairstyleapp.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;

import java.util.ArrayList;
import java.util.HashMap;


public class WatchedHairActivity extends AppCompatActivity {

    HairService HairService;
    HairServiceController HairServiceController;
    Intent intent;
    int onclicknumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);
        getIntents();
        setInents();
        displayCountryStyleFliter();
        displayYearFliter();
        displayNews();

    }


    private void getIntents(){
        intent = getIntent();
        HashMap<String, ArrayList<String>> hashMap = (HashMap<String, ArrayList<String>>) intent.getSerializableExtra("getHairCuttingMap");
        System.out.println("check12312312"+hashMap);
        onclicknumber = intent.getIntExtra("onclicknumber", 0);
    }

    private void setInents(){
        HairServiceController = new HairServiceController();
        HairServiceController.SetonclickTypenumber(this.onclicknumber);
    }

    private void displayNews(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayNews();
    }

    private void displayCountryStyleFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayStyleCountryFliter();
    }

    private void displayYearFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayYeayFilter();
    }

}