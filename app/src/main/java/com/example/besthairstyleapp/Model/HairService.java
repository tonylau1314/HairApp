package com.example.besthairstyleapp.Model;


import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;

import androidx.annotation.NonNull;

import com.example.besthairstyleapp.Dbsetting.Dbsetting;
import com.example.besthairstyleapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.json.JSONArray;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class HairService extends Dbsetting {

    private String dataStoreHairName[] = {"Hair cutting", "Hair coloring", "Hair shampoo", "Hair perm", "Hair Package", "Hair health"};

    private int[] dataStoreHairImg = {R.drawable.hair_cutting_icon,R.drawable.hair_coloring,R.drawable.hair_shampoo_icon,R.drawable.hair_perm_icon,R.drawable.hair_package_icon,R.drawable.hair_health_icon};


    private Map<String, Object> hairServiceMap = new HashMap<String, Object>();

    private Map<String,Object> getDBbhairServiceMap= new HashMap<String, Object>();

    private static Map<Integer, Map<String, Object>>hairCuttingMap = new HashMap<Integer,Map<String, Object>>();

    private static Map<Integer, Map<String, Object>>hairColoringMap = new HashMap<Integer,Map<String, Object>>();

    private static Map<Integer, Map<String, Object>>hairShampooMap = new HashMap<Integer,Map<String, Object>>();

    private static Map<Integer, Map<String, Object>>hairPermMap = new HashMap<Integer,Map<String, Object>>();

    private static Map<Integer, Map<String, Object>>hairPackageMap = new HashMap<Integer,Map<String, Object>>();



    private int cuttingKeyCounter;

    private int coloringKeyCounter;

    private int hairShampooCounter;

    private int hairPermCounter;

    private int hairPackageCounter;

    private String gethairtype;

    final String postIDTitle = "PostID";

    final String emailTitle = "Email";

    final String hairNameTitle = "Hair Name";

    final String dataTitle = "Data";

    final String imageTitle = "Image";

    final String spendTimeTitle = "Spend Time";

    final String priceTitle = "Price";

    final String hairTypeTitle = "Hair Type";

    final String countryStyleTitle = "Country Style";

    final String commentIDTitle = "CommentID";

    final String collectionName = "HairInformantion";

    final String yeartitle = "UpLoadYear";

    final String monthTitle = "UpLoadMonth";

    final String dayTitle = "UploadDay";

    final String hourTitle = "UploadHours";

    final String userNameTitle = "UserName";

    private String postId;

    Uri mImageUri;

    private int counter;

    int month;

    int year;

    int day;

    int hour;

    private String userInputemail;

    private String userInputhairName;

    private String userInputdata;

    private String userInputimage;

    private String userInputspendTime;

    private String userInputprice;

    private String userInputhairtype;

    private String userInputcountryStyle;

    private String userInputUserName;

    JSONArray jArray;

    private String[] countryStyle ={"Korea style","Americal style","China Style"};

    private String postNewYear[]={"2018","2017","2016"};

    public HairService() {
    }

    public String[] getpostNewYear(){ return postNewYear; }

    public int[] getdataStoreHairImg() {
        return this.dataStoreHairImg;
    }

    public String[] getCountryStyle(){ return countryStyle; }


    public String[] getdataStoreHairName() {
        return this.dataStoreHairName;
    }



    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setHairCuttingMap (Map<Integer, Map<String, Object>> hairCuttingMap){
        this.hairCuttingMap = hairCuttingMap;
    }

    public void sethairColoringMap (Map<Integer, Map<String, Object>> hairColoringMap){
        this.hairColoringMap=hairColoringMap;
    }

    public void sethairShampooMap (Map<Integer, Map<String, Object>>  hairShampooMap){
        this.hairShampooMap=hairShampooMap;
    }

    public void sethairPermMap (Map<Integer, Map<String, Object>>  hairPermMap){
        this.hairPermMap= hairPermMap;
    }

    public void sethairPackageMap (Map<Integer, Map<String, Object>>  hairPackageMap){
        this.hairPackageMap= hairPackageMap;
    }

    public Map<Integer, Map<String, Object>> gethairCuttingMap(){

        System.out.println("debug_paul: "+ this.hairCuttingMap);

        return this.hairCuttingMap;
    }

    public Map<Integer, Map<String, Object>> gethairColoringMap(){
        return this.hairColoringMap;
    }


    public Map<Integer, Map<String, Object>> gethairShampooMap(){
        return this.hairShampooMap;
    }

    public Map<Integer, Map<String, Object>> gethairPermMap(){
        return this.hairPermMap;
    }


    public Map<Integer, Map<String, Object>> gethairPackageMap(){
        return this.hairPackageMap;
    }

    public  Map<String, Object>  gethairServiceMap(){
        return this.hairServiceMap;
    }

    public Map<String,Object> getDBbhairServiceMap(){
        return this.getDBbhairServiceMap;
    }

    public void insertHairServiceInformantion() {

        updateID();

        upLoadHairDate();

        hairServiceMap = new HashMap<>();

        //  uploadImage();
        this.postId=String.valueOf(counter);

        hairServiceMap.put(this.postIDTitle, postId);

        hairServiceMap.put(this.userNameTitle, this.userInputUserName);

        hairServiceMap.put(this.emailTitle, this.userInputemail);

        hairServiceMap.put(this.hairNameTitle, this.userInputhairName);

        hairServiceMap.put(this.yeartitle, this.year);

        hairServiceMap.put(this.monthTitle, this.month);

        hairServiceMap.put(this.dayTitle, this.day);

        hairServiceMap.put(this.hourTitle, this.hour);

        hairServiceMap.put(this.imageTitle, this.userInputimage);

        hairServiceMap.put(this.spendTimeTitle, this.userInputspendTime);

        hairServiceMap.put(this.priceTitle, this.userInputprice);

        hairServiceMap.put(this.hairTypeTitle,this.userInputhairtype);

        hairServiceMap.put(this.countryStyleTitle, this.userInputcountryStyle);

        //  hairServiceMap.put(this.commentIDTitle,c);
        System.out.println("aasss");
        db.collection(collectionName).document(this.postId).set(hairServiceMap);
    }

    public void uploadHairSerivceData(String email,String userName,String hairName,String data,String image,String spendTime,String price,String hairtype,String countrystyle){
        userInputemail=email;
        userInputhairName=hairName;
        userInputUserName=userName;
        userInputimage=image;
        userInputspendTime=spendTime;
        userInputprice=price;
        userInputhairtype=hairtype;
        userInputcountryStyle=countrystyle;
        updateID();
        checkIDArraivedOrNot();
    }


    public void updateID() {
        db.collection(collectionName).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int count = 0;
                    for (DocumentSnapshot document : task.getResult()) {
                        count++;

                    }
                    setCounter(count);
                } else {

                }
            }
        });
    }

    private void upLoadHairDate() {
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1; // Note: zero based!
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
    }

    public void uploadImage(final String imageName,Uri mImageUri,Context context) {
        if (mImageUri!=null){
            StorageReference fileReference=mStorageRef.child(System.currentTimeMillis()+"."+getFileExtension(mImageUri,context));
            fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    Upload upload=new Upload(imageName,taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());

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

    private String getFileExtension(Uri uri, Context context){
        ContentResolver cr=context.getContentResolver();
        MimeTypeMap mime= MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void checkIDArraivedOrNot(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (counter == 0) {

                }
                insertHairServiceInformantion();
            }
        });
        t1.start();
    }



    public void getAllhairInformantion(){
        db.collection(collectionName)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                try {
                                    HairService.this.getDBbhairServiceMap = document.getData();

                                    HairService.this.gethairtype = getDBbhairServiceMap.get("Hair Type").toString();

                                    System.out.println("check123123"+HairService.this.gethairtype);

                                    typeFilter ();

                                } catch(NullPointerException e) {

                                }
                            }
                        } else {
                        }
                    }
                });
    }

    public void DownloadAllhairInformantion(){
        getAllhairInformantion();
        checkDownloadSucceesfuleOrnot();
    }

    public void checkDownloadSucceesfuleOrnot(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (hairCuttingMap.isEmpty()) {
                    System.out.println("asdsdsnull");
                }

                gethairCuttingMap();
            }
        });
        t1.start();
    }


    private void typeFilter (){
        switch (HairService.this.gethairtype) {

            case "Hair cutting":
                hairCuttingMap.put(cuttingKeyCounter++,getDBbhairServiceMap);
                System.out.println("typeFilter"+getDBbhairServiceMap);
                break;

            case "Hair coloring":
                hairColoringMap.put(coloringKeyCounter++,getDBbhairServiceMap);
                break;

            case "Hair shampoo":
                hairShampooMap.put(hairShampooCounter++,getDBbhairServiceMap);
                break;

            case "Hair perm":
                hairPermMap.put(hairPermCounter++,getDBbhairServiceMap);
                break;

            case "Hair Package":
                hairPackageMap.put(hairPackageCounter++,getDBbhairServiceMap);
                break;
        }
        System.out.println("typeFilter123"+getDBbhairServiceMap);

    }




}