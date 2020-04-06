package com.example.besthairstyleapp.Model;

import androidx.recyclerview.widget.DiffUtil;

public class DiffUtilCallback extends DiffUtil.Callback {

    private String oldList[];
    private String newList[];

    public DiffUtilCallback(String oldList[], String newList[]){
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize(){
        return oldList.length;
    }

    @Override
    public int getNewListSize(){
        return newList.length;
    }

    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition){
        return oldPosition == newPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition){
        return oldList.length == newList.length ;
    }
}
