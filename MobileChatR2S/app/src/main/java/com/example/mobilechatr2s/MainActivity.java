package com.example.mobilechatr2s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobilechatr2s.Adapter.statusAdapter;
import com.example.mobilechatr2s.Module.statusItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerStatus;
    private ArrayList<statusItem> item;
    private statusAdapter statusadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerStatus = (Spinner)findViewById(R.id.spiner_status_test);
        initViewSpiner();
        spinnerStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statusItem status =(statusItem) parent.getItemAtPosition(position);
                spinnerStatus.setBackgroundResource(status.getImageStatus());
                Toast.makeText(MainActivity.this, status.getImageStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void initViewSpiner() {
        item = new ArrayList<statusItem>();
        item.add(new statusItem(R.drawable.tag,"Bookmark"));
        item.add(new statusItem(R.drawable.special,"Special"));
        item.add(new statusItem(R.drawable.traitimii,"Like"));
        item.add(new statusItem(R.drawable.neormals,"Neormals"));
        item.add(new statusItem(R.drawable.block,"Blocker"));
        item.add(new statusItem(R.drawable.none,"Noeznasm"));
        statusadapter = new statusAdapter(this, item);
        spinnerStatus.setAdapter(statusadapter);
    }
}
