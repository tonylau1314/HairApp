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

        userMap.put(this.passwordTitle,password);

        userMap.put(this.finalEmailTitle,email);

        userMap.put(this.finalaccountNameTitle,accountName);

        db.collection(CollectionName).document(this.finalEmailTitle).set(userMap);
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
        CheckEmailExitOrNot(email);

        if(isEmailValid(email)==true){
            if(this.emailExitOrNot =="this email not exit"){
                userInsertSelfInformantion(password,email,accountName);
            }else {
                this.getEmailOrNotStatment();
            }
        }else {
            String errorMesssage ="this is not an email";
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
        return this.emailExitOrNot;
    }

    public void login(String password,String email){
        final User user= new User();
        user.setEmail(email);
        user.setPassword(password);
        db.collection(CollectionName).document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {

            public void onComplete(@NonNull Task<DocumentSnapshot> task)  {
                String getemail;
                String getpassword;
                try {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    user.userMap=document.getData();

                    getemail=user.userMap.get("Email").toString();

                    getpassword=user.userMap.get("Password").toString();

                    if(user.getEmail().equals(getemail)||user.getPassword().equals(getpassword)){
                        System.out.println("tony correctly");
                        user.setpasswordAndEmailCorrectorNot(true);
                    }
                     else {
                        System.out.println("your password is not correctly");
                        user.setpasswordAndEmailCorrectorNot(false);
                    }
                }
                    } catch(NullPointerException e) {
                    user.setpasswordAndEmailCorrectorNot(false);
                }
            }
        });
    }

    public void checkPasswordAndEmail(String email, int password){

    }

    public String CheckEmailExitOrNot(String email){
        db.collection(CollectionName).document(email).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
          @Override
          public void onComplete(@NonNull Task<DocumentSnapshot> task) {
              User user= new User();

              String emailExitOrNot;

              if (task.isSuccessful()) {

                  DocumentSnapshot document = task.getResult();

                  user.userMap=document.getData();

                  if (document.exists()) {
                      emailExitOrNot="this email exit";

                      user.setEmailOrNotStatment(emailExitOrNot);

                      String getpassword=user.userMap.get("Password").toString();

                      user.setPassword(getpassword);
                  } else {
                      emailExitOrNot="this email not exit";

                      user.setEmailOrNotStatment(emailExitOrNot);
                  }
              } else {
                      emailExitOrNot="error";

                      user.setEmailOrNotStatment(emailExitOrNot);

              }
          }
      });
        return getPassword();
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
