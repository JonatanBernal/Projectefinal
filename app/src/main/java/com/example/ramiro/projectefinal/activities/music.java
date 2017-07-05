package com.example.ramiro.projectefinal.activities;

import android.os.Bundle;
import android.view.Menu;

import com.example.ramiro.projectefinal.R;

public class music extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        super.setItemChecked();
        toolbar.setTitle("MÚSICA");
    }

    @Override
    protected int whatIsMyId() {
        return R.id.nav_music;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_extra,menu);
        setTitle("MUSIC");
        return true;
    }

}
