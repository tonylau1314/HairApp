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
    int plusicon[];

    public RecycleViewAdapter(Context context,int postNewUserIcon[],String postNewuserName[],String postNewsTime[],int plusicon[]){
        this.context=context;
        this.postNewUserIcon=postNewUserIcon;
        this.postNewuserName=postNewuserName;
        this.postNewsTime= postNewsTime;
        this.plusicon=plusicon;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.post_informantion_layout,viewGroup,false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.postNewUserName.setText(postNewuserName[position]);
        holder.postNewUsericon.setImageResource(postNewUserIcon[position]);
        holder.postNewTime.setText(postNewsTime[position]);

    }

    @Override
    public int getItemCount() {
        return postNewuserName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView postNewUsericon;
        TextView postNewUserName;
        TextView postNewTime;
        ImageView plusIcon;
        ImageView postHairImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postNewUsericon =(ImageView)itemView.findViewById(R.id.postNewUserIcon);
            postNewUserName =(TextView) itemView.findViewById(R.id.postNewuserName);
            postNewTime =(TextView) itemView.findViewById(R.id.postNewsTime);
            plusIcon =(ImageView) itemView.findViewById(R.id.plusicon);
            postHairImage =(ImageView) itemView.findViewById(R.id.postHairImage);

        }
    }
}
