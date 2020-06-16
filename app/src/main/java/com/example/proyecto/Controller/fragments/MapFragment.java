package com.example.proyecto.Controller.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyecto.Controller.DetailActivity;
import com.example.proyecto.Model.Entities.Activity;
import com.example.proyecto.Model.Entities.Event;
import com.example.proyecto.Model.Entities.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.example.proyecto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends SupportMapFragment implements OnMapReadyCallback {

    List<Activity> activities;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        //View view = inflater.inflate(R.layout.fragment_map, container, false);
        getMapAsync(this);
        return rootView;


    }

    public void cargarLista(){
        activities=new ArrayList<Activity>();
        activities.add(new Place(
                "https://66.media.tumblr.com/4fdfa0eb6cd84dbc748d54b53c9a55b5/bf1cd4815be83dc5-6b/s1280x1920/1dd9e31ba2d2909e68185ab5a20259abe3d96b91.jpg",
                "Pilonera Mayor",
                "Entrando a Valledupar por el puente Hurtado, la Pilonera Mayor es uno de los grandes símbolos que acogen al visitante." +
                        " A pocos metros del Parque de la Leyenda, la estatua da vida a una de las rotondas más espaciosas y bonitas de la ciudad. " +
                        "Un lugar recomendado para tomarse una foto y compartir la grandeza del foclor vallenato. " +
                        "Inaugurada el 18 de marzo del 2010, el monumento rinde homenaje a la “La Cacica” Consuelo Araujonoguera ",
                "Monumento",
                "Direccion",
                 "Valledupar",
                "10.496773,-73.268983",
                 R.drawable.po,
                "0"
                )
        );
        activities.add(new Place(
                        "https://66.media.tumblr.com/4fdfa0eb6cd84dbc748d54b53c9a55b5/bf1cd4815be83dc5-6b/s1280x1920/1dd9e31ba2d2909e68185ab5a20259abe3d96b91.jpg",
                        "La Sirena",
                        "Dorada y erguida sobre un trono, la sirena resplandece. Domina el río Guatapurí y fascina al paseante que la observa desde el puente." +
                                "Ella es uno de los símbolos más representativos de Valledupar. Un monumento radiante en medio de la vegetación, frente a una orilla " +
                                "llena de jóvenes que disfrutan del agua fría y saltan desde las rocas.",
                        "Monumento",
                        "Direccion",
                        "Valledupar",
                        "10.50147, -73.27125",
                         R.drawable.sirena,
                        "1"
                )
        );

    }

    @Override
    public void onMapReady(GoogleMap map) {

        cargarLista();
        // Posicionar el mapa en una localización y con un nivel de zoom
        LatLng latLng = new LatLng( 10.496773, -73.268983);
        // Un zoom mayor que 13 hace que el emulador falle, pero un valor deseado para
        // callejero es 17 aprox.
        float zoom = 13;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,8));

        for ( Activity item: activities
             ) {

            String[] parts = item.Location.split(",");
            double lat = Double.parseDouble((parts[0]));
            double lon = Double.parseDouble((parts[1]));
            LatLng coor =  new LatLng(lat,lon);

            MarkerOptions markerOptions = new MarkerOptions().
                    position(coor).
                    title(item.getName()).
                    snippet(item.id).
                    icon(BitmapDescriptorFactory.fromResource(item.icon));

            Log.i("TAG", "Aqui"+item.id);
            map.addMarker(markerOptions);
        }



        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("actividad", activities.get(Integer.parseInt(marker.getSnippet())));
                startActivity(intent);
                return false;
            }
        });
        // Más opciones para el marcador en:
        // https://developers.google.com/maps/documentation/android/marker
        // http://www.hermosaprogramacion.com/2016/05/google-maps-android-api-v2/
        //https://javiergarciaescobedo.es/desarrollo-android/82-interfaz-de-usuario/433-mapa-de-google-como-fragment-en-aplicacion-android

        // Otras configuraciones pueden realizarse a través de UiSettings
        // UiSettings settings = getMap().getUiSettings();


    }

}
