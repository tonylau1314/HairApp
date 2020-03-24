package com.example.besthairstyleapp.Model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.besthairstyleapp.Dbsetting.Dbsetting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
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
    private String password;

    private String strPassword;

    private String email;

    private String accountName;

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

    private Boolean passwordAndEmailCorrectorNot;

    public User(String email,String password) {
        this.email=email;
        this.password=password;
    }

    public User() {

    }
    public void userInsertSelfInformantion(String password, String email, String accountName){
            userMap= new HashMap<>();

            userMap.put(this.passwordTitle,password);   //crash problem

            userMap.put(this.finalEmailTitle,email);

            userMap.put(this.finalaccountNameTitle,accountName);

            db.collection(CollectionName).document(email).set(userMap);

    }


    public String getPassword() {
        return password;
    }

    public String getstrPassword() {
        return strPassword;
    }


    public void setpasswordAndEmailCorrectorNot(Boolean passwordAndEmailCorrectorNot) {
        this.passwordAndEmailCorrectorNot=passwordAndEmailCorrectorNot;
    }

    public Boolean getpasswordAndEmailCorrectorNot() {
        return this.passwordAndEmailCorrectorNot;
    }


    public void setstrPassword(String password) {
        this.strPassword=password;
    }

    public void setPassword(String password) {
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

    public void register(String password, String email, String accountName){
        setPassword(password);
        setEmail(email);
        setAccountName(accountName);
        CheckEmailExitOrNot(email);
        checkRegisterDataArraivedOrNot();
    }

    public void CheckEmailValidAndEmailExitOrNot(String email){
        if(isEmailValid(email)==true){
            if(this.emailExitOrNot =="this email not exit"){

                userInsertSelfInformantion(getPassword(),getEmail(),getAccountName());
            }else {
                String errorMesssage ="this is not an email";
            }
        }else {
            String errorMesssage ="this is not input wrong";
        }
    }

    public void checkRegisterDataArraivedOrNot(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (getEmailExitOrNotExitStatment()== null) {
                    System.out.println("WhatIs"+getEmailExitOrNotExitStatment());

                }
                System.out.println("fuck"+getEmailExitOrNotExitStatment());
                CheckEmailValidAndEmailExitOrNot(getEmail());
            }
        });
        t1.start();
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void setEmailExitOrNotExitStatment(String emailExitOrNot) {
        this.emailExitOrNot = emailExitOrNot;
    }

    public String getEmailExitOrNotExitStatment() {
        return this.emailExitOrNot;
    }

    public void login(String password,String email){
         setEmail(email);

         setPassword(password);

         db.collection(CollectionName).document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            public void onComplete(@NonNull Task<DocumentSnapshot> task)  {
                String getemail;

                String getpassword;
                System.out.println("Getsomething");
                try {

                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();

                        userMap=document.getData();

                        getemail=userMap.get("Email").toString();

                        getpassword=userMap.get("Password").toString();


                        if(getEmail().equals(getemail)||getPassword().equals(getpassword)){
                            setpasswordAndEmailCorrectorNot(true);

                        }
                         else {
                             setpasswordAndEmailCorrectorNot(false);
                        }
                    }
                        else {

                    }
                    } catch(NullPointerException e) {
                        setpasswordAndEmailCorrectorNot(false);
                }
            }

        });
    }


    public void CheckEmailExitOrNot(String email){
        db.collection(CollectionName).document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
          @Override
          public void onComplete(@NonNull Task<DocumentSnapshot> task) {
              String getpassword;

              String emailExitOrNot;

              System.out.println("step1");

              if (task.isSuccessful()) {
                  System.out.println("step2");

                  DocumentSnapshot document = task.getResult();

                  User.this.userMap=document.getData();

                  if (document.exists()) {
                      System.out.println("step3");

                      emailExitOrNot="this email exit";

                      User.this.setEmailExitOrNotExitStatment(emailExitOrNot);

                      getpassword=User.this.userMap.get("Password").toString();

                      User.this.setPassword(getpassword);

                  } else {
                      emailExitOrNot="this email not exit";

                      System.out.println("step4");

                      User.this.setEmailExitOrNotExitStatment(emailExitOrNot);
                  }
              } else {
                      emailExitOrNot="this email not exit";
                  System.out.println("step5");


                  User.this.setEmailExitOrNotExitStatment(emailExitOrNot);

              }
          }
      });
        System.out.println("step6");

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
                        System.out.println(document.getData());
                    }
                } else {
                    Log.d("Error", "Error getting documents: ", task.getException());
                }
            }
        });

    }
}
