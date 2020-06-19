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
import com.example.proyecto.Controller.MunicipalityDetailActivity;
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
                "https://66.media.tumblr.com/7f82737390f529ce71a4d0dd88f0a8ee/35f0097d73643af1-62/s500x750/9444ff3f3634ac0f2d31abdb2b2f97f1ae370f17.jpg",
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
                        "https://66.media.tumblr.com/427318aec8449ed2b719bc06b2e29e32/e2986cdb11a0d600-13/s400x600/ef0375ec5c3367c8f636478fa40b78df2de17d9c.jpg",
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
        activities.add(new Place(
                        "https://66.media.tumblr.com/8eec6910959d24be1793d0b7696eb929/c260f70189efc74b-61/s640x960/59a3cdf63dbbcd55b625c857c9f024f02639b0be.jpg",
                        "La Chichamaya",
                        "Una escultura en bronce situada cerca de la Villa Olímpica. Si indagamos en su origen descubrimos que se refiere a una danza  de la etnia wayuu, " +
                                "oriunda de la Guajira. Esta danza representa una auténtica lucha entre el hombre y la mujer en la cual aparecen muchos elementos de la vida " +
                                "familiar en la Guajira (que hacen referencia a la pareja o la poligamia).",
                        "Monumento",
                        "Direccion",
                        "Valledupar",
                        "10.461907, -73.274079",
                        R.drawable.chimi,
                        "2"
                )
        );
        activities.add(new Place(
                        "https://66.media.tumblr.com/5e82dab7256effa6fd4652d2f5b9743a/c260f70189efc74b-1e/s400x600/d54d6ff22a47540c0f2b2869058e070077ac30c2.jpg",
                        "El Obelisco",
                        "El Obelisco es una estructura de cemento de 30 metros de alto situado a la entrada de Valledupar en la vía que de Barranquilla y Fundación " +
                                "conduce a esta ciudad. Fue diseñado por el arquitecto Carlos García como un \"homenaje a la vida\" y su construcción, a cargo del arquitecto " +
                                "Helcías Castilla, data de 1994, lo cual no obsta para que, pese a su juventud, ya sea considerado como un hito o referente del espacio vital de la ciudad ",
                        "Monumento",
                        "Direccion",
                        "Valledupar",
                        "10.446504, -73.262455",
                        R.drawable.obelisco,
                        "3"
                )
        );
        activities.add(new Place(
                        "https://66.media.tumblr.com/b09b51d885191be58797422521eef772/c260f70189efc74b-10/s540x810/1753ba5a86fe913b1b2e9e86f36b00e66985d48a.jpg",
                        "Las Monedas",
                        "En Patillal, media hora al norte de Valledupar, está el Parque de las Monedas, un sitio en el que se les rinde homenaje a ocho compositores " +
                                "vallenatos nacidos en este pueblo. Se trata de una gliptoteca al aire libre en la que las caras de maestros como Rafael Escalona y Freddy " +
                                "Molina adornan por un lado monedas de cerca de un metro de diámetro; por el otro se lee un pedazo de la letra de una canción",
                        "Monumento",
                        "Direccion",
                        "Patillal",
                        "10.701606, -73.21201",
                        R.drawable.moneda,
                        "4"
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
        LatLng latLng2 = new LatLng( 9.257388, -73.812386);
        MarkerOptions m = new MarkerOptions().
                position(latLng2).
                title("Chimichagua").
                snippet("5");
        map.addMarker(m);



        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.getSnippet().equals("5")){
                    Intent intent = new Intent(getContext(), MunicipalityDetailActivity.class);
                    startActivity(intent);
                    return false;
                }
                else{
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("actividad", activities.get(Integer.parseInt(marker.getSnippet())));
                    startActivity(intent);
                    return false;
                }

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
