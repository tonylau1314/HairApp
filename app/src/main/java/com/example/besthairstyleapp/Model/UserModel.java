package com.example.besthairstyleapp.Model;

import com.example.besthairstyleapp.Dbsetting.Dbsetting;
import com.google.firebase.firestore.CollectionReference;

    public class UserModel extends Dbsetting {
        public CollectionReference userCollection= db.collection("User");

        public UserModel(){

        }

        public void queryUserAllInformantion(){

        }
}
