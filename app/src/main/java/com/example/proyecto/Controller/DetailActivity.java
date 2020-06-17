package com.example.proyecto.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailActivity extends AppCompatActivity {

    ImageView imagen;
    TextView titulo, descripcion, categoria, ciudad, direccion,webt;
    CardView address,phone,web,horario,fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_detailactivity);
        imagen = findViewById(R.id.imagedetail);
        titulo = findViewById(R.id.titulodetail);
        descripcion = findViewById(R.id.desription);
        categoria = findViewById(R.id.category);
        ciudad = findViewById(R.id.country);
        webt =findViewById(R.id.webtext);
        direccion = findViewById(R.id.addressdetail);
        address = findViewById(R.id.lineaaddress);
        phone = findViewById(R.id.lineaphone);
        web = findViewById(R.id.lineaweb);
        horario = findViewById(R.id.lineahorario);
        fecha = findViewById(R.id.lineafecha);


        Activity activity = (Activity) getIntent().getSerializableExtra("actividad");

        titulo.setText(activity.getName());
        descripcion.setText(activity.getDescription());
        categoria.setText(activity.getPhone());
        ciudad.setText(activity.getState());
        direccion.setText(activity.getType());
        webt.setText(activity.getWeb());



        if (activity.getType() == ""){
            address.setVisibility(View.GONE);
        }

        phone.setVisibility(View.GONE);
        if (activity.getWeb() == ""){
            web.setVisibility(View.GONE);
        }
        horario.setVisibility(View.GONE);
        fecha.setVisibility(View.GONE);



        Glide.with(this).
                load(activity.getImage()).
                centerCrop().
                diskCacheStrategy(DiskCacheStrategy.ALL).
                into(imagen);






    }
}
