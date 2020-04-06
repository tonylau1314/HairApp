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
    private HairService model;
    private WatchedHairActivity view;
    private RecycleViewAdapter RecycleViewAdapter;
    Context context;
    int layout;
    Activity activity;
    RecycleViewAdapter recycleViewAdapter;
    private int onclickTypenumber;
    private Map<Integer, Map<String, Object>>postNewMap = new HashMap<Integer,Map<String, Object>>();

    public HairServiceController(Context context, WatchedHairActivity view,Activity activity){
        this.model = new HairService();
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
        this.model = new HairService();
    }


    public String[] getHairServiceCountryStyle(){
        return model.getCountryStyle();
    }


    public String[] getHairServicepostNewYear(){
        return model.getpostNewYear();
    }


    public Map<Integer, Map<String, Object>> getModelgethairCuttingMap(){
        System.out.println("TonyCHeck"+model.gethairCuttingMap());

        return model.gethairCuttingMap();
    }

    public Map<Integer, Map<String, Object>> getModelhairColoringMap(){
        return model.gethairColoringMap();
    }


    public Map<Integer, Map<String, Object>> getModelhairShampooMap(){
        return model.gethairShampooMap();
    }


    public Map<Integer, Map<String, Object>> getModelgethairPermMap(){
        return model.gethairPermMap();
    }


    public Map<Integer, Map<String, Object>> getModelhairPackageMap(){
        return model.gethairPackageMap();
    }

    public void SetonclickTypenumber(int onclickTypenumber){
        this.onclickTypenumber =onclickTypenumber;
        checkDisplaySwitchTypeNew();
    }

    public Map<String,Object> getModelhairServiceMap(){
        return model.gethairServiceMap();
    }

    public void getModelAllhairInformantion(){
        model.getAllhairInformantion();
    }

    public void checkDisplaySwitchTypeNew(){
        switch (onclickTypenumber) {
            case 0:
                postNewMap=getModelgethairCuttingMap();
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
        System.out.println("checkTony"+postNewMap);
        recycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,postNewMap);
        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context));


    }

 /*   public void displayNews(){
        RecyclerView recycleview =(RecyclerView)this.activity.findViewById(R.id.recycle_view);

        recycleViewAdapter = new RecycleViewAdapter(R.layout.post_informantion_layout,this.context,getHairServiceUserIcon(),getHairServiceStylist(),getHairServicePostNewsTime(),getHairServiceHairImg());


        recycleview.setAdapter(recycleViewAdapter);
        recycleview.setLayoutManager(new LinearLayoutManager(this.context));


    }
*/
    //clear old data and add new data
  /*  public void updateData(RecycleViewAdapter recycleViewAdapter){
        HairServiceController hairServiceController=new HairServiceController();

        System.out.println("check"+hairServiceController.getHairServiceStylist());
        this.postNewuserName=hairServiceController.getHairServiceStylist();


        System.out.println("aaaa"+newList);
        DiffUtilCallback diffUtilCallback = new DiffUtilCallback(postNewuserName,newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);
        // postNewuserName= new String[2];
         String postNewuserName[] = new String[newList.length];

        for (int counter = 0; counter <newList.length; counter++) {
            postNewuserName[counter]=newList[counter];
        }

        //      dataSource.addAll(newList);
        System.out.println("checkNew"+newList);

        diffResult.dispatchUpdatesTo(hairServiceController.recycleViewAdapter);
    }
*/


}
