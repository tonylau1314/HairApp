package com.example.besthairstyleapp.Dbsetting;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

public  class Dbsetting {
     public FirebaseFirestore db=FirebaseFirestore.getInstance();
     public StorageReference mStorageRef;
}
