package com.example.besthairstyleapp.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.R;
import com.squareup.picasso.Picasso;

public class UploadImageActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int pickImageRequest =1;
    Button uploadBtn;
    Button chooseBtn;
    EditText chooseImageImageName;
    ImageView chooseImageView;
    Uri mImageUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_image);
        uploadBtn=findViewById(R.id.uploadimageBtn);
        chooseBtn=findViewById(R.id.ChooseFileBtn);
        chooseImageImageName=findViewById(R.id.imageNameEdit);
        chooseImageView=findViewById(R.id.chooseImageView);

        uploadBtn.setOnClickListener(this);
        chooseBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.uploadimageBtn:

                break;
            case R.id.ChooseFileBtn:
                openFileChoose();

                break;

        }
    }

    public void openFileChoose(){
            Intent intent=new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent,pickImageRequest);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==pickImageRequest&& requestCode==RESULT_OK && data!=null&&data.getData()!=null){
            mImageUri =data.getData();
            Picasso.with(this).load(mImageUri).into(chooseImageView);
            chooseImageView.setImageURI(mImageUri);

        }
    }
}