package com.example.besthairstyleapp.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.Model.User;
import com.example.besthairstyleapp.R;
import com.google.firebase.firestore.FirebaseFirestore;


public class WatchedHairActivity extends AppCompatActivity {

    HairService HairService;
    HairServiceController HairServiceController;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    User user;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_page);
        User user=new User();
        user.getUserAllInformantion();
        displayCountryStyleFliter();
        displayNews();
        displayYearFliter();

    }
    public void displayNews(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayNews();
    }
    public void displayCountryStyleFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayStyleCountryFliter();
    }

    public void displayYearFliter(){
        HairService = new HairService();
        HairServiceController = new HairServiceController(this , this, this);
        HairServiceController.displayYeayFilter();
    }

}