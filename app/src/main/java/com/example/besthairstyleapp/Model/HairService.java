package com.example.besthairstyleapp.Model;



import android.graphics.drawable.Drawable;

import com.example.besthairstyleapp.R;

import java.util.ArrayList;
import java.util.List;

public class HairService {
    private String[] hairStylist ;

    private String[] dataList;

    private int[] hairImg;

    private String spendTime;

    private int[] price;

    private int[] postID;

    private String[] name;

    private String[] dataStoreHairName = {"Hair cutting","Hair coloring","Hair shampoo","Hair perm","Hair Package","Hair health"};

    private int[] dataStoreHairImg = {R.drawable.hair_cutting_icon,R.drawable.hair_coloring,R.drawable.hair_shampoo_icon,R.drawable.hair_perm_icon,R.drawable.hair_package_icon,R.drawable.hair_health_icon};


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
    public String[] dataStoreHairName() {
        return this.dataStoreHairName;
    }

    public int[] dataStoreHairImg() {
        return this.dataStoreHairImg;
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


}
