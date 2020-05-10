package com.example.proyecto.views.fragments;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.proyecto.Entities.Activity;
import com.example.proyecto.Entities.Event;
import com.example.proyecto.R;
import com.example.proyecto.views.AdapterActivityHomeCardView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ViewPager viewPager;
    AdapterActivityHomeCardView adapter;
    List<Activity> activities;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activities = new ArrayList<>();
        activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Pilonera Mayor", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent tempor ex dui. In maximus vel purus eget aliquam. Vivamus sit amet ultrices nisi. Praesent suscipit orci ut faucibus sollicitudin. Cras rhoncus mauris at porta suscipit. Phasellus et euismod odio, in mollis nulla. Maecenas at lobortis libero. Ut scelerisque maximus metus, et tempus turpis pharetra sed. Aliquam at condimentum ligula, a fringilla felis. Fusce lacus nisi, consectetur egestas tortor non, finibus dapibus sem. "));
        activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Otra Pilonera Mayor", "Es la piloneramayor"));
        activities.add(new Event(R.drawable.monumento_de_la_pilonera_mayor, "Tercera Pilonera Mayor", "Es la piloneramayor"));



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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
