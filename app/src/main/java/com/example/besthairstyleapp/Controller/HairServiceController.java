package com.example.besthairstyleapp.Controller;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.Adapter.RecycleViewAdapter;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;
import com.example.besthairstyleapp.View.WatchedHairActivity;

import java.util.ArrayList;
import java.util.List;

public class HairServiceController implements View.OnClickListener{
    private HairService model;
    private WatchedHairActivity view;
    private RecycleViewAdapter RecycleViewAdapter;
    Context context;
    int layout;
    public Activity activity;
   // public WatchedHairActivity asd;//test
    public  RecycleViewAdapter recycleViewAdapter;
    TextView asd;
    public HairServiceController(Context context, WatchedHairActivity view,Activity activity){
        this.model= new HairService();
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

    public HairServiceController(){
        this.model= new HairService();

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
        recycleViewAdapter=new RecycleViewAdapter(R.layout.fliter_list_view,this.context,getHairServiceCountryStyle(),getHairServicepostNewYear());
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false));
    }

    public void displayYeayFilter(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.fliter_year_recycle_view);
         recycleViewAdapter=new RecycleViewAdapter(R.layout.fliter_year_list_view,this.context,getHairServicepostNewYear());
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context, RecyclerView.HORIZONTAL, false));
    }

    public void displayNews(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.recycle_view);

        recycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,getHairServiceUserIcon(),getHairServiceStylist(),getHairServicePostNewsTime(),getHairServiceHairImg());

        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context));


    }


    public void insertSingleItem() {

        System.out.println("Insideasd");

        String item = "Pig";
        int insertIndex = 3;
        List<String> filterCollection=new ArrayList<>();
        for (int i = 0; i < getHairServiceStylist().length; i++){
            filterCollection.add(getHairServiceStylist()[i]);
        }
        filterCollection.add(insertIndex, item);
        recycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,getHairServiceUserIcon(),getHairServiceStylist(),getHairServicePostNewsTime(),getHairServiceHairImg());

    }


    private void removeSingleItem() {
        System.out.println("CheckclickTony");
        List<String> filterCollection=new ArrayList<>();
        for (int i = 0; i < getHairServiceStylist().length; i++){
            filterCollection.add(getHairServiceStylist()[i]);
        }
        int removeIndex = 2;
        filterCollection.remove(removeIndex);
        recycleViewAdapter.notifyItemRemoved(removeIndex);
    }


    @Override
    public void onClick(View v) {
        insertSingleItem();
    }
}
