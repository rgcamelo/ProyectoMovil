package com.example.proyecto.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.R;
import com.example.proyecto.Controller.fragments.HomeFragment;

import java.util.List;

public class AdapterActivityHomeCardView extends PagerAdapter {

    private List<Activity> activities;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterActivityHomeCardView(List<Activity> models, Context context) {
        this.activities = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return activities.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_homeactivity, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);


        imageView.setImageResource(activities.get(position).getImage());
        title.setText(activities.get(position).getName());
        desc.setText(activities.get(position).getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("actividad", activities.get(position));
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
