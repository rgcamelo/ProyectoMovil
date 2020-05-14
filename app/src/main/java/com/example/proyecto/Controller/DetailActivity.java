package com.example.proyecto.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailActivity extends AppCompatActivity {

    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_detailactivity);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar_detail);
        Activity activity = (Activity) getIntent().getSerializableExtra("actividad");
        collapsingToolbarLayout.setTitle(activity.getName());



    }
}
