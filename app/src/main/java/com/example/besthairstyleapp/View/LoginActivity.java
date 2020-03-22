package com.example.besthairstyleapp.View;

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
             UserController userController =new UserController();
             userController.checkUserAccountPassword(this.passwordText,this.emailText);

             if(userController.getuserModelpasswordAndEmailCorrectorNot()){
                 SharedPreferences pref = getSharedPreferences("User", MODE_PRIVATE);
                 pref.edit().putString("password", this.passwordText).commit();
                 pref.edit().putString("email", this.emailText).commit();
             }

        }
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


                break;
            case R.id.register:

                break;
        }

    }

}