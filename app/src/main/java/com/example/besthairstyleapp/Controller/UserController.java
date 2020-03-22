package com.example.besthairstyleapp.Controller;

import android.app.Activity;
import android.content.Context;

import com.example.besthairstyleapp.Model.User;
import com.example.besthairstyleapp.View.LoginActivity;
import com.example.besthairstyleapp.libClass.JavaMailAPI;

import java.util.ArrayList;

public class UserController {
    User model;
    private LoginActivity view;
    Context context;
    int layout;
    public Activity activity;


    public UserController(){
         this.model=new User();
    }



    public void SetUserModelInsertSelfInformantion(int password, String email, String accountName){

    }


    public String getUserModelPassword() {
        return model.getPassword();
    }

    public void setUserModelPassword(String password) {
         model.setPassword(password);

    }

    public String getUserModelEmail(){
        return model.getEmail();
    }

    public void setUserModelEmail(String email) {
        model.setEmail(email);
    }

    public String getUserModelAccountName(){
        return model.getAccountName();
    }

    public void setUserModelAccountName(String accountName) {
        model.setAccountName(accountName);
    }

    public int getUserModelIcon() {
       return model.getUserIcon();

    }

    public void setUserModelIcon(int userIcon) {
         model.setUserIcon(userIcon);
    }


    public ArrayList<String> getUserModelAllUserInformantionArraylist() {
        return model.getAllUserInformantionArraylist();
    }

    public void setUserModelAllUserInformantionArraylist (ArrayList<String> allUserInformantionArraylist) {
        model.setAllUserInformantionArraylist(allUserInformantionArraylist);
    }

    public void editUserModelInformantion(int password, String email, String accountName){
        model.editInformantion(password,email,accountName);
    }

    public void UserModelregister(String password, String email, String accountName){
        model.register(password,email,accountName);

    }

    public void  UserModelisEmailValid(String email) {
        model.isEmailValid(email);
    }

    public void setUserModelEmailOrNotStatment(String emailExitOrNot) {
        model.setEmailOrNotStatment(emailExitOrNot);
    }

    public String getUserModelEmailOrNotStatment() {
        return model.getEmailOrNotStatment();
    }


    public void CheckUserModelEmailExitOrNot(String email){
        model.CheckEmailExitOrNot(email);
    }

    public void getUserModelAllInformantion(){
        model.getUserAllInformantion();
    }

    public Boolean getuserModelpasswordAndEmailCorrectorNot(){
        return model.getpasswordAndEmailCorrectorNot();
    }

    public void checkUserAccountPassword(String password,String email){
        model.login(password,email);
    }

    public void forgetPassword(Context mContext, String mEmail){
        model.CheckEmailExitOrNot(mEmail);

        String password=model.getEmailOrNotStatment();

        System.out.println("Tony check"+password);

        String errorMessage="this email exit";

        if(errorMessage.equals(model.getEmailOrNotStatment())){
            JavaMailAPI javaMailAPI=new JavaMailAPI(mContext,"hairproject1234@gmail.com","Forget password",getUserModelPassword());

            javaMailAPI.execute();
        }else {
            getUserModelEmailOrNotStatment();
        }
    }
}
