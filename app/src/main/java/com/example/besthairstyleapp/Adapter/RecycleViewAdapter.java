package com.example.besthairstyleapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.Model.Filterlist;
import com.example.besthairstyleapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>  implements View.OnClickListener {
    @NonNull

    private Context context;
    int postNewUserIcon[];
    String postNewuserName[];
    String postNewsTime[];
    int HairImg[];
    String[] countryStyle ;
    String postNewYear[];
    int layout;
    int getCountNumber;
    int onClickNumber;
    String filterYearTitle;
    String hairStyleTitle;

    List<String> dataSource;
    ArrayList<String> bbc;
    ArrayList<String> postuserNameList;

    public RecycleViewAdapter(){

    }

    public RecycleViewAdapter(int layout,Context context,int postNewUserIcon[],String postNewuserName[],String postNewsTime[],int HairImg[]){
        this.context=context;
        this.postNewUserIcon=postNewUserIcon;
        this.postNewuserName=postNewuserName;
        this.postNewsTime= postNewsTime;
        this.HairImg=HairImg;
        this.layout=layout;
    }

    public RecycleViewAdapter(int layout , Context context, String[] countryStyle, String postNewYear[]){
        this.context=context;
        this.countryStyle=countryStyle;
        this.postNewYear=postNewYear;
        this.layout=layout;
    }


    public RecycleViewAdapter(int layout , Context context, String[] postNewYear){
        this.layout=layout;
        this.context=context;
        this.postNewYear=postNewYear;
    }

    public void inserData(List<String> insertList){
      //  postuserNameList = new ArrayList<>();
         bbc=new ArrayList<String>();//Creating arraylist
        bbc.add("Ravi");//Adding object in arraylist
        bbc.add("Vijay");
        bbc.add("Ravi");
        bbc.add("Ajay");
    //    for (int i = 0; i < postNewuserName.length; i++) {
     //       postuserNameList.add(postNewuserName[i]);
      //  }
        Filterlist filterlist=new Filterlist(bbc,insertList);
        DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(filterlist);

        bbc.addAll(insertList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void updateData(List<String> newList){
        Filterlist filterlist=new Filterlist(postuserNameList,newList);
        DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(filterlist);

        postuserNameList.clear();
        postuserNameList.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(this.layout,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        switch (layout){
            case R.layout.post_informantion_layout:
                holder.postNewUserName.setText(postNewuserName [position]);
                holder.postNewUsericon.setImageResource(postNewUserIcon[position]);
                holder.postNewTime.setText(postNewsTime[position]);


            break;

            case R.layout.fliter_list_view:
                holder.fliter_item.setText(countryStyle[position]);

            break;

            case R.layout.fliter_year_list_view:

                holder.fliter_year_item.setText(postNewYear[position]);

                holder.fliter_year_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> list=new ArrayList<String>();//Creating arraylist
                    list.add("Ravi");//Adding object in arraylist
                    list.add("Vijay");
                    list.add("Ravi");
                    list.add("Ajay");
                    inserData(list);
                     setOnClickNumber(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        switch (layout){
            case R.layout.post_informantion_layout:
                this.getCountNumber=postNewuserName.length;
            break;
            case R.layout.fliter_list_view:
               this.getCountNumber=countryStyle.length;

                break;
            case R.layout.fliter_year_list_view:
                this.getCountNumber=postNewYear.length;
                break;

        }
        return this.getCountNumber;
    }

    public void setOnClickNumber(int onClickNumber){
        this.onClickNumber=onClickNumber;
    }

    public int getOnClickNumber(){
        return this.onClickNumber;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fliter_year_item:
                checkWhichFilterYearbtnClicked();

                break;

            case R.id.fliter_item:
                checkWhichStylebtnClicked();

                break;

        }
    }

    public void checkWhichFilterYearbtnClicked(){
        switch (getOnClickNumber()){
            case 0:
                this.filterYearTitle = "2018";
            break;

            case 1:
                this.filterYearTitle = "2017";
            break;

            case 2:
                this.filterYearTitle = "2016";
                break;
        }
    }

    public void checkWhichStylebtnClicked(){
        switch (getOnClickNumber()){
            case 0:
                this.hairStyleTitle="Korea style";
            break;

            case 1:
                this.hairStyleTitle="Americal style";
            break;

            case 2:
                this.hairStyleTitle="China style";
            break;
        }
    }





    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView postNewUsericon;
        TextView postNewUserName;
        TextView postNewTime;
        ImageView plusIcon;
        ImageView postHairImage;
        TextView fliter_item;
        TextView fliter_year_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postNewUsericon =(ImageView)itemView.findViewById(R.id.postNewUserIcon);
            postNewUserName =(TextView) itemView.findViewById(R.id.postNewuserName);
            postNewTime =(TextView) itemView.findViewById(R.id.postNewsTime);
            plusIcon =(ImageView) itemView.findViewById(R.id.plusicon);
            postHairImage =(ImageView) itemView.findViewById(R.id.postHairImage);
            fliter_item=(TextView)itemView.findViewById(R.id.fliter_item);
            fliter_year_item=(TextView)itemView.findViewById(R.id.fliter_year_item);

        }


    }



}
