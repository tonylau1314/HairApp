package com.example.besthairstyleapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.besthairstyleapp.R;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private final String[] text;
    private final int[] imageId;


    public GridAdapter(Context context, String[] text, int[] imageId) {
        this.context = context;
        this.text = text;
        this.imageId = imageId;
    }

    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Context 動態放入mainActivity
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.hair_type_icon_title, null);
            // 將grid_single 動態載入(image+text)
            final TextView textView = convertView.findViewById(R.id.hair_type_title);
            final ImageView imageView = convertView.findViewById(R.id.hair_type_icon);
            textView.setText(text[position]);
            imageView.setImageResource(imageId[position]);


        }

        return convertView;

    }



}