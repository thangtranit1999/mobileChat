package com.example.mobilechatr2s.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobilechatr2s.Module.Contact;
import com.example.mobilechatr2s.Module.statusItem;
import com.example.mobilechatr2s.R;

import java.util.ArrayList;

public class adapterListContact extends BaseAdapter {
    private ArrayList<Contact> mLisContacts;
    private ArrayList<statusItem> mListItem;
    private Context mContext;

    public adapterListContact(ArrayList<Contact> lisContacts, ArrayList<statusItem> listItem, Context context){
        this.mContext = context;
        this.mLisContacts = lisContacts;
        this.mListItem = listItem;
    }
    @Override
    public int getCount() {
        return mLisContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return mLisContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder view;
        if(convertView==null){
            view = new viewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_lv_contact,parent,false);
            view.imageViewAvatar = (ImageView)convertView.findViewById(R.id.imageContact);
            view.spinnerViewStatus = (Spinner)convertView.findViewById(R.id.spiner_status);
            view.name = (TextView) convertView.findViewById(R.id.lv_name);
            view.note = (TextView) convertView.findViewById(R.id.lv_note);
            convertView.setTag(view);
        }
        else {
            view =(viewHolder) convertView.getTag();
        }
        Contact contact = mLisContacts.get(position);
        view.name.setText(contact.getmName());
        view.note.setText(contact.getmPhone());
        if(contact.getmAvatar()!=null){
            view.imageViewAvatar.setImageBitmap(contact.getmAvatar());
        }
        else {
            view.imageViewAvatar.setImageResource(R.drawable.logocontact);
        }
        //view.spinnerViewStatus.setBackgroundResource(contact.getmStatus().getImageStatus());
        statusAdapter statusadapter = new statusAdapter(mContext,mListItem);
        view.spinnerViewStatus.setAdapter(statusadapter);
        return convertView;
    }
    public class viewHolder{
        ImageView imageViewAvatar;
        TextView name,note;
        Spinner spinnerViewStatus;
    }
}
