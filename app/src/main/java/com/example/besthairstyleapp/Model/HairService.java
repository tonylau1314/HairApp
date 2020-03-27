package com.example.besthairstyleapp.Model;


import androidx.annotation.NonNull;

import com.example.besthairstyleapp.Dbsetting.Dbsetting;
import com.example.besthairstyleapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HairService extends Dbsetting {
        private String[] hairStylist ={"Tony","John","David","yoyo"};

        private String[] dataList={"21-2-2020","21-1-2020","12-10-2020","21-9-2020"};

        private int[] hairImg={R.id.plusicon,R.id.plusicon,R.id.plusicon,R.id.plusicon};

        private String spendTime;

        private int[] price;

        private int[] postID;

        private String[] name;

        private int[] userIcon={R.drawable.hair_health_icon,R.drawable.hair_health_icon,R.drawable.hair_health_icon,R.drawable.hair_health_icon};

        private String[] postHairNewsTime={"11:40","11:50","12:50","12:23"};

        private String[] dataStoreHairName = {"Hair cutting","Hair coloring","Hair shampoo","Hair perm","Hair Package","Hair health"};

        private int[] dataStoreHairImg = {R.drawable.hair_cutting_icon,R.drawable.hair_coloring,R.drawable.hair_shampoo_icon,R.drawable.hair_perm_icon,R.drawable.hair_package_icon,R.drawable.hair_health_icon};

        private String[] countryStyle ={"Korea style","Americal style","China Style"};

        private String postNewYear[]={"2018","2017","2016"};

        Map<String,Object> hairServiceMap;

        final String postIDTitle="PostID";

        final String emailTitle="Email";

        final String hairNameTitle="Hair Name";

        final String dataTitle="Data";

        final String imageTitle="Image";

        final String spendTimeTitle="Spend Time";

        final String priceTitle="Price";

        final String hairTypeTitle="Hair Type";

        final String countryStyleTitle="Country Style";

        final String commentIDTitle="CommentID";

        final String collectionName="HairInformantion";

        private String postId;

        private int counter;
    public HairService(String[] hairStylist,String[] dataList,String spendTime,int[] price,int[] postID,String[] name,int[] hairImg){
        this.hairStylist=hairStylist;
        this.dataList=dataList;
        this.spendTime=spendTime;
        this.price=price;
        this.postID=postID;
        this.name=name;
        this.hairImg=hairImg;
    }
    public HairService(){

    }

    public int[] getdataStoreHairImg() {
        return this.dataStoreHairImg;
    }

    public String[] getdataStoreHairName() {
        return this.dataStoreHairName;
    }

    public String[] getHairStylist() {
        return hairStylist;
    }

    public void setHairStylist(String[] hairStylist) {
        this.hairStylist = hairStylist;
    }

    public String[] getDataList() {
        return dataList;
    }

    public void setDataList(String[] dataList) {
        this.dataList = dataList;
    }

    public int[] getHairImg() {
        return hairImg;
    }

    public void setHairImg(int[] hairImg) {
        this.hairImg = hairImg;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        this.price = price;
    }

    public int[] getPostID() {
        return postID;
    }

    public void setPostID(int[] postID) {
        this.postID = postID;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String[] getCountryStyle(){ return countryStyle; }

    public void setCountryStyle(String[] name) {
        this.countryStyle = countryStyle;
    }

    public String[] getpostNewYear(){ return postNewYear; }

    public void setpostNewYear(String[] postNewYear) {
        this.postNewYear = postNewYear;
    }

    public int[] getUserIcon(){ return userIcon; }

    public void setUserIcon(int[] userIcon) {
        this.userIcon = userIcon;
    }

    public String[] getpostHairNewsTime(){ return this.postHairNewsTime; }

    public void setpostHairNewsTime(String[] postHairNewsTime) {
        this.postHairNewsTime = postHairNewsTime;
    }

    public int getCounter(){ return this.counter; }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void insertHairServiceInformantion(String email,String hairName, String data,String image,String spendTime,String price,String hairtype,String countrystyle){

        updateID();

        hairServiceMap = new HashMap<>();

        hairServiceMap.put(this.postIDTitle,getCounter());

        hairServiceMap.put(this.emailTitle,email);

        hairServiceMap.put(this.hairNameTitle,hairName);

        hairServiceMap.put(this.dataTitle,data);

        hairServiceMap.put(this.imageTitle,image);

        hairServiceMap.put(this.spendTimeTitle,spendTime);

        hairServiceMap.put(this.priceTitle,price);

        hairServiceMap.put(this.hairTypeTitle,hairtype);

        hairServiceMap.put(this.countryStyleTitle,countrystyle);

      //  hairServiceMap.put(this.commentIDTitle,c);

        db.collection(collectionName).document(this.postId).set(hairServiceMap);
    }

    public void updateID(){
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

    public void upLoadHairDate(){
        Calendar calendar=Calendar.getInstance();
        Date today =calendar.getTime();
    }
}
