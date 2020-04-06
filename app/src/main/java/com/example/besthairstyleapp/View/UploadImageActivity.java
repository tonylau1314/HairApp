package com.example.besthairstyleapp.View;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.besthairstyleapp.Model.Upload;
import com.example.besthairstyleapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UploadImageActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int pickImageRequest =1;
    Button uploadBtn;
    Button chooseBtn;
    EditText chooseImageImageName;
    EditText countryStyle;
    EditText email;
    EditText hairName;
    EditText hairType;
    EditText image;
    EditText price;
    EditText spendTime;

    ImageView chooseImageView;
    Uri mImageUri;
    private static final int PICK_IMAGE_REQUEST =1;
    private StorageReference mStorageRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_image);
        uploadBtn=findViewById(R.id.uploadimageBtn);
        chooseBtn=findViewById(R.id.ChooseFileBtn);
        chooseImageImageName=findViewById(R.id.imageNameEdit);

        chooseImageView=findViewById(R.id.chooseImageView);

        mStorageRef = FirebaseStorage.getInstance().getReference("upload/4315323.jpg");


        uploadBtn.setOnClickListener(this);
        chooseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.uploadimageBtn:
                uploadFile();
                break;
            case R.id.ChooseFileBtn:
                openFileChoose();

                break;

        }
    }


    private void openFileChoose(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){

            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(chooseImageView);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    private void uploadFile(){
        if (mImageUri!=null){
            StorageReference fileReference=mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri));
            fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Upload upload=new Upload(chooseImageImageName.getText().toString().trim(),taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());

                }
            })
           .addOnFailureListener(new OnFailureListener() {
               @Override
               public void onFailure(@NonNull Exception e) {

               }
           })

            .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

            }
        });

        }
    }

}