package com.example.besthairstyleapp.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.UserController;
import com.example.besthairstyleapp.R;

public class ForgetPasswordActivity extends AppCompatActivity implements View.OnClickListener{
    EditText forgetpasswordEmail;
    Button Sendbtn;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        initializeview();
        initializeviewSetListener();
    }
    public void initializeview() {
        forgetpasswordEmail = (EditText) findViewById(R.id.Email);
        Sendbtn = (Button) findViewById(R.id.Sendbtn);
    }
    public void initializeviewSetListener(){
        Sendbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        UserController userController = new UserController();
        String mail=forgetpasswordEmail.getText().toString().trim();
        userController.forgetPassword(this,mail);
    }
}