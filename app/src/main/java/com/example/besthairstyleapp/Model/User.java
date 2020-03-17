package com.example.besthairstyleapp.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.besthairstyleapp.Dbsetting.Dbsetting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Dbsetting {
    int password;

    String email;

    String accountName;

    int userIcon;

    String allUserInformantion;

    private CollectionReference userCollection;


    Map<String,Object> userMap= new HashMap<>();

    final String CollectionName="User";

    final String passwordTitle= "Password";

    final String finalEmailTitle= "Email";

    final String finalaccountNameTitle= "AccountName";

    final String finalUserIconTitle= "UserIcon";

    private ArrayList<String> allUserInformantionArraylist;

    JSONArray jArray;

    String querySuccessOrfail;

    String queryTitle ;

    String queryDescription ;

    Map<String,Object> userAllInformantion ;

    String emailExitOrNot;


    public User() {

    }

    public void userInsertSelfInformantion(int password, String email, String accountName){

        userMap.put(this.passwordTitle,password);

        userMap.put(this.finalEmailTitle,email);

        userMap.put(this.finalaccountNameTitle,accountName);

        db.collection(CollectionName).document(this.finalEmailTitle).set(userMap);
    }


    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }


    public ArrayList<String> getAllUserInformantionArraylist() {
        return this.allUserInformantionArraylist;
    }

    public void setAllUserInformantionArraylist (ArrayList<String> allUserInformantionArraylist) {
        this.allUserInformantionArraylist = allUserInformantionArraylist;
    }

    public void editInformantion(int password, String email, String accountName){

        userMap.put(this.passwordTitle,password);

        userMap.put(this.finalEmailTitle,email);

        userMap.put(this.finalaccountNameTitle,accountName);

        db.collection(CollectionName).document(email).update(userMap);
    }

    public void register(int password, String email, String accountName){
        CheckEmailExitOrNot(email);

        if(isEmailValid(email)==true){
            if(this.emailExitOrNot =="this email not exit"){
                userInsertSelfInformantion(password,email,accountName);
            }else {
                this.getEmailOrNotStatment();
            }
        }else {
            String errorMesssage ="your form is wrong";
        }

    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void setEmailOrNotStatment(String emailExitOrNot) {
        this.emailExitOrNot = emailExitOrNot;
    }

    public String getEmailOrNotStatment() {
        return  this.emailExitOrNot;
    }


    public void CheckEmailExitOrNot(String email){
      db.collection(CollectionName).document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
          @Override
          public void onComplete(@NonNull Task<DocumentSnapshot> task) {
              User user= new User();
              String emailExitOrNot;
              if (task.isSuccessful()) {
                  DocumentSnapshot document = task.getResult();
                  if (document.exists()) {
                      emailExitOrNot="this email exit";

                     user.setEmailOrNotStatment(emailExitOrNot);

                  } else {
                      emailExitOrNot="this email not exit";
                      user.setEmailOrNotStatment(emailExitOrNot);

                  }
              } else {
                      emailExitOrNot="errror";
                  user.setEmailOrNotStatment(emailExitOrNot);

              }
          }
      });
    }

    public void getUserAllInformantion(){
        db.collection(CollectionName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                User user=new User();
                if (task.isSuccessful()) {
                    System.out.println(task);
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (jArray != null) {
                            for (int i=0;i<jArray.length();i++){
                                user.getAllUserInformantionArraylist();
                                try {
                                    allUserInformantionArraylist.add(jArray.getString(i));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        System.out.println("Tony"+document.getData());
                    }
                } else {
                    Log.d("Error", "Error getting documents: ", task.getException());
                }
            }
        });

    }
}
