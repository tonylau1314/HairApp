package com.example.besthairstyleapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.Controller.UserController;
import com.example.besthairstyleapp.R;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{

        EditText email;
        EditText password;
        CheckBox rememberMe;
        Button loginBtn;
        TextView forgetpassword, register;
        String emailText, passwordText;
        UserController userController;
        HairServiceController hairServiceController;
        Intent intent;
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

              this.hairServiceController =new HairServiceController();

              this.hairServiceController.getModelAllhairInformantion();

              this.userController.checkUserAccountPassword(this.passwordText,this.emailText);

              checkDataArraivedOrNot();

        }
    }

    public void checkDataArraivedOrNot(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (userController.getuserModelpasswordAndEmailCorrectorNot()==null ||hairServiceController.getModelDBbhairServiceMap()==null) {
                 }

                 userloginCorrect(userController.getuserModelpasswordAndEmailCorrectorNot());
            }
        });
        t1.start();
    }

    public void userloginCorrect(Boolean correctOrNot){
        if(correctOrNot.equals(true)){
              changeMainPage();
        }
    }


    public void changeMainPage(){
          intent =new Intent(this, MainActivity.class);
           LoginActivity.this.startActivity(intent);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:
                emailText = email.getText().toString().trim();
                passwordText = password.getText().toString().trim();
                checkEmptyOrNot(email,emailText,"Email is not inputted");
                checkEmptyOrNot(password,passwordText,"Password is not inputted");

                break;
            case R.id.forgetpassword:
                this.startActivity(new Intent(this, ForgetPasswordActivity.class));

                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterAcivity.class));
                break;
        }

    }

}