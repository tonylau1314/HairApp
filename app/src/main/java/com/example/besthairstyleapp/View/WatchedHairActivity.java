package com.example.besthairstyleapp.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;


public class WatchedHairActivity extends AppCompatActivity {

    HairService hairService = new HairService();
    HairServiceController HairServiceController =new HairServiceController();
    Intent intent;
    int onclicknumber;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);

        System.out.println("fastCheck"+hairService.gethairCuttingMap().get(0).get("UserName"));

        getIntents();
        setonclicknumber();
        displayCountryStyleFliter();
        displayYearFliter();
        displayNews();
    }


    private void getIntents(){
        intent = getIntent();
        onclicknumber = intent.getIntExtra("onclicknumber", 0);
    }

    private void setonclicknumber(){
        HairServiceController = new HairServiceController();
        HairServiceController.SetonclickTypenumber(this.onclicknumber);
    }

    private void displayNews(){
        hairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayNews();
    }

    private void displayCountryStyleFliter(){
        hairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayStyleCountryFliter();
    }

    private void displayYearFliter(){
        hairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayYeayFilter();
    }

}