package com.example.mobilechatr2s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.mobilechatr2s.Adapter.statusAdapter;
import com.example.mobilechatr2s.Module.statusItem;

import java.util.ArrayList;

public class lv_contact extends AppCompatActivity {

    private Spinner spinnerStatus;
    private ArrayList<statusItem> item;
    private statusAdapter statusadapter;
    private statusItem status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_contact);
        initViewSpiner();
    }
    public void initViewSpiner() {
        item = new ArrayList<statusItem>();
        item.add(new statusItem(R.drawable.tag,"Bookmark"));
        item.add(new statusItem(R.drawable.special,"Special"));
        item.add(new statusItem(R.drawable.traitimii,"Like"));
        item.add(new statusItem(R.drawable.neormals,"Neormals"));
        item.add(new statusItem(R.drawable.block,"Blocker"));
        item.add(new statusItem(R.drawable.none,"Noeznasm"));
        statusadapter = new statusAdapter(this, item);
        spinnerStatus = (Spinner)findViewById(R.id.spiner_status);
        spinnerStatus.setAdapter(statusadapter);
        spinnerStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                status =(statusItem) parent.getItemAtPosition(position);
                spinnerStatus.setBackgroundResource(status.getImageStatus());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //return status;
    }
}
