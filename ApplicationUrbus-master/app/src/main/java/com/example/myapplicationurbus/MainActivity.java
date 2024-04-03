package com.example.myapplicationurbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
    //https://www.youtube.com/watch?v=1rheNzlihus cambiar de pestaña
    //https://www.youtube.com/watch?v=B_MQEzYnZ9A imagenes
    //https://www.youtube.com/watch?v=Df_CruIKxFc vista pequeña del mapa
    // https://www.youtube.com/watch?v=XOF8aFU03ew permisos de ubicacion
    // https://www.youtube.com/watch?v=_6EeTp4GxLo rutas
    //ubicacion //https://www.youtube.com/watch?v=xwsq76TlB4Q
    // icono app https://www.youtube.com/watch?v=jPz-Z0dhDOQ


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageButton IBtConfiguracion; //id funcion del bton de configuracion
    Button BtBotonMapa ; //id para agrandar el mapa
    GoogleMap map; //servicios del mapa
    LocationManager locationManager; //sericios de ubicacion en tiempo real
    MapsActivity mapsActivity = new MapsActivity();

    private void getLocalizacion(){  //permisos de localizacion , si no hay permiso de ubicacion se pide el permiso
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permission== PackageManager.PERMISSION_DENIED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
            }else {
 //se pide el permiso de ubicacion
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); //locacion
        IBtConfiguracion = findViewById(R.id.IBtConfiguracion);
        BtBotonMapa= findViewById(R.id.BtBotonMapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map); //fragment de mapa
        mapFragment.getMapAsync(this);
        getLocalizacion(); //pide localizacion


        IBtConfiguracion.setOnClickListener(new View.OnClickListener() { //botono configuracion
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainConfiguracion.class);//manda a otra pantalla
                startActivity(intent);

            }
        });

        BtBotonMapa.setOnClickListener(new View.OnClickListener() { //pantalla del mapa
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);//agregar el otro
                startActivity(intent);
            }
        });

    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mapsActivity.onMapReady(googleMap); //funcion del mapa, mostrar puntos
        map = googleMap;

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        !=PackageManager.PERMISSION_GRANTED)
        { //si no hay permiso de locacion ?

            return;
        }

        map.setMyLocationEnabled(true); //cambiar para no porblema
        map.getUiSettings().setMyLocationButtonEnabled(false);
        LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                //muestra la ubicacion en tiempo real
                LatLng ubicacionReal = new LatLng(location.getLatitude(),location.getLongitude());

                map.addMarker(new MarkerOptions().position(ubicacionReal));
                map.moveCamera(CameraUpdateFactory.newLatLng(ubicacionReal));
                CameraPosition cameraPosition =new CameraPosition.Builder()
                        .target(ubicacionReal)
                        .zoom(14f)
                        .build();
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);


    }
}