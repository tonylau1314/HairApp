package com.example.besthairstyleapp.Model;



import com.example.besthairstyleapp.R;

public class HairService {
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


}
