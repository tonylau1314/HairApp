package com.example.besthairstyleapp.Controller;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.Adapter.RecycleViewAdapter;
import com.example.besthairstyleapp.Model.HairService;
import com.example.besthairstyleapp.R;
import com.example.besthairstyleapp.View.WatchedHairActivity;

import java.util.HashMap;
import java.util.Map;

public class HairServiceController {
    private HairService model = new HairService();
    private WatchedHairActivity view;
     Context context;
    int layout;
    Activity activity;
    RecycleViewAdapter recycleViewAdapter;
    public RecycleViewAdapter postNewsRecycleViewAdapter;

    private int onclickTypenumber;
    private static Map<Integer, Map<String, Object>>postNewMap = new HashMap<Integer,Map<String, Object>>();

    public HairServiceController(Context context, WatchedHairActivity view,Activity activity){
        this.model = new HairService();
        this.view=view;
        this.context=context;
        this.activity=activity;
    }


    public HairServiceController(int layout, Context context, RecycleViewAdapter RecycleViewAdapter, HairService model, WatchedHairActivity view){
        this.model=model;
        this.view=view;
         this.context=context;
        this.layout=layout;
    }

    public HairServiceController(){

    }


    public String[] getHairServiceCountryStyle(){
        return model.getCountryStyle();
    }


    public String[] getHairServicepostNewYear(){
        return model.getpostNewYear();
    }


    public Map<Integer, Map<String, Object>> getModelgethairCuttingMap(){ 
        return model.gethairCuttingMap();
    }

    public Map<Integer, Map<String, Object>> getModelhairColoringMap(){
        return model.gethairColoringMap();
    }


    public Map<Integer, Map<String, Object>> getModelhairShampooMap(){
        return model.gethairShampooMap();
    }


    public Map<Integer, Map<String, Object>> getModelpostNewMap(){
        return postNewMap;
    }


    public Map<Integer, Map<String, Object>> getModelgethairPermMap(){
        return model.gethairPermMap();
    }

    public void setModelHairCuttingMap(Map<Integer, Map<String, Object>> hairCuttingMap){
        model.setHairCuttingMap(hairCuttingMap);
    }


    public void setModelhairColoringMap(Map<Integer, Map<String, Object>> hairColoringMap){
        model.sethairColoringMap(hairColoringMap);
    }


    public void setModelhairShampooMap(Map<Integer, Map<String, Object>> hairShampooMap){
        model.sethairShampooMap(hairShampooMap);
    }


    public void setModelhairPermMap(Map<Integer, Map<String, Object>> hairPermMap){
        model.sethairPermMap(hairPermMap);
    }


    public void setModelhairPackageMap(Map<Integer, Map<String, Object>> hairPackageMap){
        model.sethairPackageMap(hairPackageMap);
    }

    public Map<Integer, Map<String, Object>> getModelhairPackageMap(){
        return model.gethairPackageMap();
    }


    public void SetonclickTypenumber(int onclickTypenumber){
        this.onclickTypenumber =onclickTypenumber;
        checkDisplaySwitchTypeNew();
    }

    public Object getpostNewsRecycleViewAdapter(){
        return postNewsRecycleViewAdapter;
    }

    public Map<String,Object> getModelhairServiceMap(){
        return model.gethairServiceMap();
    }

    public void getModelAllhairInformantion(){
        model.getAllhairInformantion();
    }

    public  Map<String,Object>  getModelDBbhairServiceMap(){
        return model.getDBbhairServiceMap();
    }

    public Map<Integer, Map<String, Object>> getPostNewMap(){
        return postNewMap;
    }

    public void checkDisplaySwitchTypeNew(){
        switch (onclickTypenumber) {
            case 0:
                System.out.println("checkHairController"+ getModelgethairCuttingMap());
                this.postNewMap=getModelgethairCuttingMap();
             break;

            case 1:
                postNewMap = getModelhairColoringMap();
            break;

            case 2:
                postNewMap =getModelhairShampooMap();
            break;

            case 3:
                postNewMap =getModelgethairPermMap();
            break;

            case 4:
                postNewMap = getModelhairPackageMap();
            break;

        }
    }

    public void displayStyleCountryFliter(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.fliter_recycle_view);
        recycleViewAdapter=new RecycleViewAdapter(R.layout.fliter_list_view,this.context,getHairServiceCountryStyle(),"countryStyleList");
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
        System.out.println("checkControllerpostNewMap"+postNewMap);
        postNewsRecycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,postNewMap);
        recycleview.setAdapter(postNewsRecycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context));
    }


}
