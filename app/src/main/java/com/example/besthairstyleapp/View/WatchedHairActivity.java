package com.example.besthairstyleapp.View;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class WatchedHairActivity extends AppCompatActivity {

    HairService HairService;
    HairServiceController HairServiceController;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);
// Write a message to the database
        Map<String, Object> city = new HashMap<>();
        city.put("name", "Los Angeles");
        city.put("state", "CA");
        city.put("country", "USA");

        db.collection("cities").document("LA")
                .set(city);


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