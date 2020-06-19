package com.example.proyecto.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.Model.Entities.Place;
import com.example.proyecto.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ResultsSearchActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    List<Activity> activities;
    private RecyclerView recyclerView;
    private AdapterResultList adapterResultList;


    String textobuscar;
    String cuando;
    String donde;
    String interes;
    String Lugar;
    String Evento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycleresults);
        //adapterResultList = new AdapterResultList(,R.layout.item_list_result,this);

        textobuscar = getIntent().getStringExtra("textobuscar");
        cuando = getIntent().getStringExtra("cuando");
        donde = getIntent().getStringExtra("donde");
        interes = getIntent().getStringExtra("interes");
        Lugar = getIntent().getStringExtra("Lugar");
        Evento = getIntent().getStringExtra("Evento");
        final Context context = this;
        cargarlista(context);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void filtros(Place place){
        Place placebuscado;
        String cadenaDondeBuscar = place.getName().toUpperCase();
        String loQueQuieroBuscar = textobuscar.toUpperCase();
        String[] palabras = loQueQuieroBuscar.split("\\s+");
        for (String palabra : palabras) {
            if (cadenaDondeBuscar.contains(palabra)) {
                if ( place.getPhone().equals("Cualquier cosa") || place.getPhone().equals(interes) ){
                    placebuscado=place;
                    activities.add(placebuscado);
                }

            }
        }

    }

    public void cargarlista(final Context context){
        activities = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference("6");
        Query query = mDatabase.child("data");
        if ( !donde.isEmpty() && !donde.equals("Donde sea")){
            query = query.orderByChild("state").equalTo(donde);
        }


        //query.addValueEventListener(valueEventListener);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for ( DataSnapshot ds : dataSnapshot.getChildren()
                    ) {
                        String name = ds.child("name").getValue().toString();
                        String image = ds.child("image").getValue().toString();
                        String desc = ds.child("description").getValue().toString();
                        String categoria = ds.child("category").getValue().toString();
                        String web = ds.child("web").getValue().toString();
                        String ciudad = ds.child("state").getValue().toString();
                        String direccion = ds.child("address").getValue().toString();

                        Log.i("AQUI",name);
                        Log.i("AQUI", desc);
                        Log.i( "AQUI", image);

                        Place place = new Place();
                        place.Name = name;
                        place.Image = image;
                        place.Description = desc;
                        place.State=ciudad;
                        place.setWeb(web);
                        place.setPhone(categoria);
                        place.setType(direccion);

                        filtros(place);

                    }


                    recyclerView.setHasFixedSize(true);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    AdapterResultList adapterResultList = new AdapterResultList(activities,context);
                    adapterResultList.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, DetailActivity.class);
                            intent.putExtra("actividad", activities.get(recyclerView.getChildAdapterPosition(v)));
                            context.startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(adapterResultList);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
