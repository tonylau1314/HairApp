package com.example.besthairstyleapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.besthairstyleapp.R;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{
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


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(this.layout,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
                break;
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
