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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycleresults);
        //adapterResultList = new AdapterResultList(,R.layout.item_list_result,this);

        String textobuscar = getIntent().getStringExtra("textobuscar");
        String cuando = getIntent().getStringExtra("cuando");
        String donde = getIntent().getStringExtra("donde");
        String interes = getIntent().getStringExtra("interes");
        String Lugar = getIntent().getStringExtra("Lugar");
        String Evento = getIntent().getStringExtra("Evento");
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

    public void cargarlista(final Context context){
        activities = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference("6");
        Query query = mDatabase.child("data");
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
                        activities.add(place);
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
