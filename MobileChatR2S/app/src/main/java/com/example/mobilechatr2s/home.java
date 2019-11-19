package com.example.mobilechatr2s;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobilechatr2s.Adapter.adapterListContact;
import com.example.mobilechatr2s.Adapter.contactAdapter;
import com.example.mobilechatr2s.Adapter.statusAdapter;
import com.example.mobilechatr2s.Module.Contact;
import com.example.mobilechatr2s.Module.statusItem;

import java.io.IOException;
import java.util.ArrayList;

public class home extends AppCompatActivity {
    private ArrayList<Contact> listContact;
    private Contact contact;
    private Cursor cursor;
    private contactAdapter contactAdapter;
    private ListView lvContact;
    private static final int Request = 1;

    private adapterListContact test;


    private Spinner spinnerStatus;
    private ArrayList<statusItem> item;
    private statusAdapter statusadapter;
    private statusItem status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvContact = (ListView)findViewById(R.id.lvcontact);
        listContact = new ArrayList<Contact>();
        ActivityCompat.requestPermissions(home.this,new String[]{Manifest.permission.READ_CONTACTS},Request);//yeu cau cho phép quyen
        itemSpiner();
    }

    private void itemSpiner() {
        item = new ArrayList<statusItem>();
        item.add(new statusItem(R.drawable.tag,"Bookmark"));
        item.add(new statusItem(R.drawable.special,"Special"));
        item.add(new statusItem(R.drawable.traitimii,"Like"));
        item.add(new statusItem(R.drawable.neormals,"Neormals"));
        item.add(new statusItem(R.drawable.block,"Blocker"));
        item.add(new statusItem(R.drawable.none,"Noeznasm"));
    }

    private ArrayList getArrayContact() {

        listContact = new ArrayList<Contact>();
        String[] doiTuong = {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_URI
        };
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,doiTuong,null,null,null);
        cursor.moveToFirst();
        while (cursor.moveToNext()){
            contact = new Contact();
            contact.setmName(cursor.getString(cursor.getColumnIndex(doiTuong[0])));
            contact.setmPhone(cursor.getString(cursor.getColumnIndex(doiTuong[1])));
            contact.setmAvatar(getBitmap(cursor.getString(cursor.getColumnIndex(doiTuong[2]))));
            listContact.add(contact);
        }
        cursor.close();
        return listContact;
    }
    public Bitmap getBitmap(String uri){
        if(uri != null){
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),Uri.parse(uri));
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                return  null;
            }
        }
        return null;
    }
    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
        switch (RC) {
            case Request:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(home.this,"Read Contacts đã được cấp quyền đọc ứng dụng", Toast.LENGTH_LONG).show();
                    listContact.clear();
                    listContact = getArrayContact();
                    test = new adapterListContact(listContact,item,this);
                    lvContact.setAdapter(test);
                } else {

                    Toast.makeText(home.this,"Read contacts chỉ hoạt động khi được cấp quyền", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}
