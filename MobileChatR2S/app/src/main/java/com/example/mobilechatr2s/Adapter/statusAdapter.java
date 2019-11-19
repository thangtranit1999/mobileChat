package com.example.mobilechatr2s.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilechatr2s.Module.statusItem;
import com.example.mobilechatr2s.R;

import java.util.ArrayList;

public class statusAdapter extends ArrayAdapter<statusItem> {
        public statusAdapter(@NonNull Context context, ArrayList<statusItem> listStatus) {
        super(context, 0, listStatus);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView,parent);
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView,parent);
    }
    private View initView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spiner_row,parent,false);
        }
        ImageView imageStatus = convertView.findViewById(R.id.imageviewstatus);
        TextView txtStatus = convertView.findViewById(R.id.txtstatus);
        statusItem statusItem = getItem(position);
        if (imageStatus!=null){
            imageStatus.setImageResource(statusItem.getImageStatus());
            txtStatus.setText(statusItem.getNameStatus());
        }
        else {
            return null;
        }
        return convertView;
    }
}
