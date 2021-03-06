package com.example.proyecto.Controller.fragments;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.proyecto.Controller.AdapterlistOptionSearch;
import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.Model.Entities.Event;
import com.example.proyecto.Model.Entities.Place;
import com.example.proyecto.R;
import com.example.proyecto.Controller.AdapterActivityHomeCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ViewPager viewPager;
    AdapterActivityHomeCardView adapter;
    List<Activity> activities;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private DatabaseReference mDatabase;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Pilonera Mayor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tempor ex dui. In maximus vel purus eget aliquam. Vivamus sit amet ultrices nisi. Praesent suscipit orci ut faucibus sollicitudin. Cras rhoncus mauris at porta suscipit. Phasellus et euismod odio, in mollis nulla. Maecenas at lobortis libero. Ut scelerisque maximus metus, et tempus turpis pharetra sed. Aliquam at condimentum ligula, a fringilla felis. Fusce lacus nisi, consectetur egestas tortor non, finibus dapibus sem. "));
        //activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Otra Pilonera Mayor", "Es la piloneramayor"));
        //activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Tercera Pilonera Mayor", "Es la piloneramayor"));
        cargarlista();


        //adapter = new AdapterActivityHomeCardView(activities, getContext());



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void cargarlista(){
        activities = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference("6");
        Query query = mDatabase.child("data")
                .orderByChild("category").equalTo("Evento");

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

                    adapter = new AdapterActivityHomeCardView(activities, getContext());
                    viewPager =  getView().findViewById(R.id.Pager);
                    viewPager.setAdapter(adapter);
                    viewPager.setPadding(5, 43, 5, 0);

                    Integer[] colors_temp = {
                            ContextCompat.getColor(getContext(), R.color.color1),
                            ContextCompat.getColor(getContext(), R.color.color2),
                            ContextCompat.getColor(getContext(), R.color.color3),

                    };

                    colors = colors_temp;

                    viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                            if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                                viewPager.setBackgroundColor(

                                        (Integer) argbEvaluator.evaluate(
                                                positionOffset,
                                                colors[position],
                                                colors[position + 1]
                                        )
                                );
                            }

                            else {
                                viewPager.setBackgroundColor(colors[colors.length - 1]);
                            }
                        }

                        @Override
                        public void onPageSelected(int position) {

                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
