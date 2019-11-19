package com.example.mobilechatr2s.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilechatr2s.Module.Contact;
import com.example.mobilechatr2s.Module.statusItem;
import com.example.mobilechatr2s.R;
import com.example.mobilechatr2s.lv_contact;

import java.util.ArrayList;
import java.util.List;

public class contactAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int layout;
    private ArrayList<Contact> listContact;
    private ArrayList<statusItem> listStatus;

    public contactAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> contacts) {
        super(context, resource,contacts);
        this.context = context;
        this.layout = resource;
        this.listContact = contacts;
        //this.listStatus = item;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder view;
        if(convertView==null){
            view = new viewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_lv_contact,parent,false);
            view.imageViewAvatar = (ImageView)convertView.findViewById(R.id.imageContact);
            view.spinnerViewStatus = (Spinner)convertView.findViewById(R.id.spiner_status);
            view.name = (TextView) convertView.findViewById(R.id.lv_name);
            view.note = (TextView) convertView.findViewById(R.id.lv_note);
            convertView.setTag(view);
        }
        else {
            view =(viewHolder) convertView.getTag();
        }
        Contact contact = listContact.get(position);
        view.name.setText(contact.getmName());
        view.note.setText(contact.getmPhone());
        if(contact.getmAvatar()!=null){
            view.imageViewAvatar.setImageBitmap(contact.getmAvatar());
        }
        else {
            view.imageViewAvatar.setImageResource(R.drawable.logocontact);
        }
        //view.spinnerViewStatus.setBackgroundResource(contact.getmStatus().getImageStatus());

        return convertView;
    }
    public class viewHolder{
        ImageView imageViewAvatar;
        TextView name,note;
        Spinner spinnerViewStatus;
    }

}
