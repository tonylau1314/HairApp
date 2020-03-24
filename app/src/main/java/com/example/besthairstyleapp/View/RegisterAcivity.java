package com.example.besthairstyleapp.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Controller.UserController;
import com.example.besthairstyleapp.R;

public class RegisterAcivity extends AppCompatActivity implements View.OnClickListener {
    EditText firstname;
    EditText lastname;
    EditText email;
    EditText password;
    Button registerBtn;
    String inputfirstname;
    String inputlastname;
    String inputemail;
    String inputpassword;
    UserController userController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeview();
        initializeviewSetListener();


    }

    public void initializeview() {
        firstname =(EditText) findViewById(R.id.firstname);
        lastname =(EditText) findViewById(R.id.lastname);
        email =(EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        registerBtn = (Button)findViewById(R.id.registerBtn);

    }

    public void initializeviewSetListener(){

        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.registerBtn:
                this.inputfirstname = firstname.getText().toString().trim();

                this.inputlastname = lastname.getText().toString().trim();

                this.inputemail = email.getText().toString().trim();

                this.inputpassword = password.getText().toString().trim();

                checkEmptyOrNot(firstname, inputfirstname, "firstname is not inputted");

                checkEmptyOrNot(lastname, inputlastname, "lastname is not inputted");

                checkEmptyOrNot(email, inputemail, "email is not inputted");

                checkEmptyOrNot(password, inputpassword, "password is not inputted");

                break;
        }
    }

    public void checkEmptyOrNot(EditText view,String input, String errorMessage){
        if (input.isEmpty()){

            view.setError(errorMessage);

            view.requestFocus();

            return;

        }else{
            System.out.println("asd.net");

            this.userController =new UserController();

            String userName= inputlastname+inputfirstname;

            this.userController.UserModelregister(inputpassword,inputemail,userName);
        }
    }

}