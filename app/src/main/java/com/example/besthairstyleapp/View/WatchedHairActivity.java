package com.example.besthairstyleapp.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;

public class WatchedHairActivity extends AppCompatActivity {

    HairService HairService;
    HairServiceController HairServiceController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);
        displayCountryStyleFliter();
        displayNews();
        displayYearFliter();
    }
    public void displayNews(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this, HairService, this, this);
        HairServiceController.displayNews();
    }
    public void displayCountryStyleFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this, HairService, this, this);
        HairServiceController.displayStyleCountryFliter();
    }

    public void displayYearFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this, HairService, this, this);
        HairServiceController.displayYeayFilter();
    }
}