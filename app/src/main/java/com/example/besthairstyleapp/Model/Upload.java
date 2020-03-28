package com.example.besthairstyleapp.Model;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload(){

    }

    public Upload(String name,String imageUrl){
        if (name.trim().equals("")){
            name ="No Name";
        }

        mName=name;
        mImageUrl=imageUrl;
    }


    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName=name;
    }

    public String getImageUrl() {
        return this.mName;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl=mImageUrl;
    }
}
