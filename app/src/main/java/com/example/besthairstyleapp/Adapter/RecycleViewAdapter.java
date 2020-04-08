package com.example.besthairstyleapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.besthairstyleapp.Controller.HairServiceController;
import com.example.besthairstyleapp.R;

import java.util.HashMap;
import java.util.Map;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>  {
    @NonNull

    private Context context;
    String[] countryStyle ;
    String postNewYear[];
    int layout;
    int getCountNumber;
    int onClickNumber;
    String filterYearTitle;
    String hairStyleTitle;

    static Map<Integer,Map<String, Object>> postNews =new HashMap<Integer,Map<String, Object>>() ;

    static Map<Integer,Map<String, Object>> oldNews =new HashMap<Integer,Map<String, Object>>() ;


    boolean onClickChange;

    static RecyclerView.Adapter postinformantionlayoutAdapter ;

    int onClickNumberCountryStyle;

    HairServiceController hairServiceController= new HairServiceController();

    private int onclickplusNumber;

    public RecycleViewAdapter(){

    }


    public RecycleViewAdapter(int layout , Context context, String[] countryStyle,String country){
        this.context=context;
        this.countryStyle=countryStyle;
        this.layout=layout;
    }


   public RecycleViewAdapter(int layout , Context context, String[] postNewYear){
        this.layout=layout;
        this.context=context;
        this.postNewYear=postNewYear;

    }



    public RecycleViewAdapter(int layout , Context context, Map<Integer, Map<String, Object>> postNews){
        this.layout=layout;
        this.context=context;
        this.postNews.putAll(postNews);
        this.oldNews.putAll(postNews);
    }




    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(this.layout,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        switch (layout){
            case R.layout.post_informantion_layout:
                 holder.postNewUserName.setText(postNews.get(position).get("Email").toString());
            //    holder.postNewUsericon.setImageResource(postNewUserIcon[position]);
                holder.postNewTime.setText(postNews.get(position).get("UploadHours").toString());

                holder.plusIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        recordUserInterestService(position);
                    }
                });

                setPostInformantionLayoutAdapter(this);

            break;

            case R.layout.fliter_list_view:
                holder.fliter_item.setText(countryStyle[position]);
                holder.fliter_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setCountryStyleOnClickNumber(position);
                        checkWhichStylebtnClicked();
                        postNewsFilter(filterYearTitle,hairStyleTitle);
                    }
                });
            break;

            case R.layout.fliter_year_list_view:

                holder.fliter_year_item.setText(postNewYear[position]);

                holder.fliter_year_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setOnClickNumber(position);
                        System.out.println("checkPostion"+position);
                        checkWhichFilterYearbtnClicked();
                        postNewsFilter(filterYearTitle,hairStyleTitle);
                    }
                });
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



    public void setPostInformantionLayoutAdapter(RecyclerView.Adapter adapter){
        postinformantionlayoutAdapter=adapter;
        System.out.println("CheckNullOrNot123"+postinformantionlayoutAdapter);
    }

    public void postNewsFilter(String filterYearTitle,String filterCountryStyle){
        removeitem(filterYearTitle,filterCountryStyle);
    }

    public void removeitem(String filterYearTitle,String filterCountryStyle){
        System.out.println("tony1234"+filterYearTitle);
        postNews.putAll(oldNews);
        for (int counter = 0; counter < postNews.size(); counter++) {
                if (filterYearTitle.equals(postNews.get(counter).get("UpLoadYear").toString())){
                    System.out.println("ifCondition");
                    postNews.remove(counter);
                    this.postinformantionlayoutAdapter.notifyItemRemoved(counter);

                }else {
                    System.out.println("checkPostNews"+postNews);
                    this.postinformantionlayoutAdapter.notifyItemRemoved(counter);
                    this.postinformantionlayoutAdapter.notifyDataSetChanged();

                }
            }

    }

    public void recordUserInterestService(int userInterestService){
        onclickplusNumber++;
        hairServiceController.getRecordUserInterestService().put(userInterestService,postNews.get(userInterestService));
     }

    @Override
    public int getItemCount() {
        switch (layout){
            case R.layout.post_informantion_layout:
                  this.getCountNumber=postNews.size();

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


    public void setCountryStyleOnClickNumber(int onClickNumberCountryStyle){
        this.onClickNumberCountryStyle=onClickNumberCountryStyle;
    }

    public int setCountryStyleOnClickNumber(){
        return this.onClickNumberCountryStyle;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView postNewUsericon;
        TextView postNewUserName;
        TextView postNewTime;
        ImageView plusIcon;
        ImageView postHairImage;
        TextView fliter_item;
        TextView fliter_year_item;
        SwipeRefreshLayout refreshHairPost;
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
