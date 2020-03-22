package com.example.besthairstyleapp.Controller;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.Adapter.RecycleViewAdapter;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;
import com.example.besthairstyleapp.View.WatchedHairActivity;

public class HairServiceController {
    private HairService model;
    private WatchedHairActivity view;
    private RecycleViewAdapter RecycleViewAdapter;
    Context context;
    int layout;
    public Activity activity;

    public HairServiceController(Context context,HairService model, WatchedHairActivity view,Activity activity){
        this.model=model;
        this.view=view;
        this.context=context;
        this.activity=activity;
    }


    public HairServiceController(int layout, Context context, RecycleViewAdapter RecycleViewAdapter, HairService model, WatchedHairActivity view){
        this.model=model;
        this.view=view;
        this.RecycleViewAdapter=RecycleViewAdapter;
        this.context=context;
        this.layout=layout;
    }

    public int[] getHairServiceHairImg() {
        return model.getHairImg();
    }

    public String[] getHairServiceHairName() {
        return model.getdataStoreHairName();
    }

    public String[] getHairServiceStylist() {
        return model.getHairStylist();
    }

    public void setHairServiceStylist(String[] hairStylist) {
        model.setHairStylist(hairStylist);
    }

    public String[] getHairServiceDataList() {
        return model.getDataList();
    }

    public void setHairServiceDataList(String[] dataList) {
        model.setDataList(dataList);
    }

    public void setHairServiceHairImg(int[] hairImg) {
        model.setHairImg(hairImg);
    }

    public String getHairServiceSpendTime() {
       return model.getSpendTime();
    }

    public void setHairServiceSpendTime(String spendTime) {
        model.setSpendTime(spendTime);
    }

    public int[] getHairServicePrice() {
        return model.getPrice();
    }

    public void setHairServicePrice(int[] price) {
        model.setPrice(price);
    }

    public int[] getHairServicePostID() {
        return model.getPostID();
    }

    public void setHairServicePostID(int[] postID) {
        model.setPostID(postID);
    }

    public String[] getHairServiceName() {
        return model.getName();
    }

    public void setHairServiceName(String[] name) {
        model.setName(name);
    }

    public String[] getHairServiceCountryStyle(){
         return model.getCountryStyle();
    }

    public void setHairServiceCountryStyle(String[] name) {
        model.setCountryStyle(name);
    }

    public String[] getHairServicepostNewYear(){
        return model.getpostNewYear();
    }

    public void setHairServicepostNewYear(String[] postNewYear) {
        model.setpostNewYear(postNewYear);
    }

    public int[] getHairServiceUserIcon(){
        return model.getUserIcon();
    }

    public void setHairServiceUserIcon(int[] userIcon) {
        model.setUserIcon(userIcon);
    }

    public String[] getHairServicePostNewsTime(){ return model.getpostHairNewsTime(); }

    public void setHairServicePostHairNewsTime (String[] postHairNewsTime) {
        model.setpostHairNewsTime(postHairNewsTime);
    }

    public void displayStyleCountryFliter(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.fliter_recycle_view);
        RecycleViewAdapter recycleViewAdapter=new RecycleViewAdapter(R.layout.fliter_list_view,this.context,getHairServiceCountryStyle(),getHairServicepostNewYear());
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false));
    }

    public void displayYeayFilter(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.fliter_year_recycle_view);
        RecycleViewAdapter recycleViewAdapter=new RecycleViewAdapter(R.layout.fliter_year_list_view,this.context,getHairServicepostNewYear());
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false));
    }


    public void displayNews(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.recycle_view);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,getHairServiceUserIcon(),getHairServiceStylist(),getHairServicePostNewsTime(),getHairServiceHairImg());
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context));
    }




}
