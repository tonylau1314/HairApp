package com.example.besthairstyleapp.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.UserController;
import com.example.besthairstyleapp.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

        EditText email;
        EditText password;
        CheckBox rememberMe;
        Button loginBtn;
        TextView forgetpassword;
        TextView register;
        String emailText, passwordText;
        UserController userController;
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeview();
        initializeviewSetListener();
    }

    public void initializeview() {
        email =(EditText) findViewById(R.id.Email);
        password =(EditText) findViewById(R.id.Password);
        rememberMe =(CheckBox) findViewById(R.id.rememberMe);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        forgetpassword = (TextView)findViewById(R.id.forgetpassword);
        register = (TextView)findViewById(R.id.register);

    }

    public void initializeviewSetListener(){
        loginBtn.setOnClickListener(this);
        forgetpassword.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    public void checkEmptyOrNot(EditText view,String input, String errorMessage){
        if (input.isEmpty()){

            view.setError(errorMessage);

            view.requestFocus();

            return;
        }else{
              this.userController =new UserController();

              this.userController.checkUserAccountPassword(this.passwordText,this.emailText);

              checkDataArraivedOrNot();


        }
    }

    public void checkDataArraivedOrNot(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (userController.getuserModelpasswordAndEmailCorrectorNot()==null ) {
                    System.out.println("tony"+userController.getuserModelpasswordAndEmailCorrectorNot());
                }

                System.out.println("finalllyHelp"+userController.getuserModelpasswordAndEmailCorrectorNot());

                userloginCorrect(userController.getuserModelpasswordAndEmailCorrectorNot());
            }
        });
        t1.start();
    }

    public void userloginCorrect(Boolean correctOrNot){
        if(correctOrNot.equals(true)){
            rememberUserAccount();
            changeMainPage();
        }
    }

    public void rememberUserAccount(){
        SharedPreferences pref = getSharedPreferences("User", MODE_PRIVATE);

        pref.edit().putString("password", this.passwordText).commit();

        pref.edit().putString("email", this.emailText).commit();
    }

    public void changeMainPage(){
        System.out.println("arrived");
        Intent intent =new Intent(this, MainActivity.class);
        LoginActivity.this.startActivity(intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                this.emailText= email.getText().toString().trim();
                this.passwordText=  password.getText().toString().trim();
                checkEmptyOrNot(email,emailText,"Email is not inputted");
                checkEmptyOrNot(password,passwordText,"Password is not inputted");

                break;
            case R.id.forgetpassword:
                Intent forgetpasswordintent =new Intent(this, ForgetPasswordActivity.class);
                LoginActivity.this.startActivity(forgetpasswordintent);

                break;
            case R.id.register:
                Intent registerintent =new Intent(this, RegisterAcivity.class);
                LoginActivity.this.startActivity(registerintent);
                break;
        }

    }

}