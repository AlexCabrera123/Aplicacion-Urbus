package com.example.myapplicationurbus;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myapplicationurbus.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Polyline polyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);}

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap; //= googleMap;

       // LocationManager locationManager = (LocationManager) MainActivity.this.getSystemService(Context.LOCATION_SERVICE);

      //  LocationManager locationManager1=(LocationManager) MainActivity.
       // LocationManager locationManager = (LocationManager) MainActivity.getSystemService(Context.LOCATION_SERVICE);


        // Add a marker in mercado independencia and move the camera
        LatLng mercadoIndependencia = new LatLng(19.69644755, -101.188638758171);
        mMap.addMarker(new MarkerOptions().position(mercadoIndependencia).title("Terminal de paloma azul")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_bus_estation_foreground)).anchor(0.0f,0.0f));
       // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mercadoIndependencia,15f));
        mMap.setTrafficEnabled(true); //para ver trafico

        LatLng base =new LatLng(19.639102795919722,-101.24055977680356);
     //   LatLng base =new LatLng(19.444622846679844,-99.12894382484005);
        mMap.addMarker(new MarkerOptions().position(base).title(("Base de paloma azul")));

        List<LatLng> points = new ArrayList<>();
        points.add(new LatLng(19.639154924277335, -101.24037434296697)); // Punto 1
        points.add(new LatLng(19.642201117485364, -101.24028973788336)); // Punto 2
        points.add(new LatLng(19.64209616015904, -101.23950081410067)); // Punto 3
        points.add(new LatLng(19.64257107251638, -101.23910384717341)); // Punto 4
        points.add(new LatLng(19.643056087923036, -101.23908238950112)); // Punto 5
        points.add(new LatLng(19.643098351874595, -101.23807903674378)); // Punto 6
        points.add(new LatLng(19.64247727287841, -101.23785972931495)); // Punto 7
        points.add(new LatLng(19.643220342449595, -101.23549332740113)); // Punto 8
        points.add(new LatLng(19.64162250871999, -101.23492882210368)); // Punto 9
        points.add(new LatLng(19.642681697266326, -101.23398945474642)); // Punto 10
        points.add(new LatLng(19.639030549573178, -101.23068469851151)); // Punto 11
        points.add(new LatLng(19.640351831951683, -101.22902467996393)); // Punto 12
        points.add(new LatLng(19.641176034746167, -101.22846081497354)); // Punto 13
        points.add(new LatLng(19.643202536017558, -101.22885326496294)); // Punto 14
        points.add(new LatLng(19.645337199786333, -101.22994247383265)); // Punto 15
        points.add(new LatLng(19.645943458396452, -101.23008731314107)); // Punto 16
        points.add(new LatLng(19.646504245555874, -101.22270050962646)); // Punto 17
        points.add(new LatLng(19.646989249077624, -101.22149351566716)); // Punto 18
        points.add(new LatLng(19.64695893639986, -101.22088197190786)); // Punto 19
        points.add(new LatLng(19.645237128525853, -101.2204415886325)); // Punto 20
        points.add(new LatLng(19.645228631826484, -101.21935896794598)); // Punto 21
        points.add(new LatLng(19.644249041658224, -101.21909464276615)); // Punto 22
        points.add(new LatLng(19.645228631826484, -101.21935896794598)); // Punto 21
        points.add(new LatLng(19.645237128525853, -101.2204415886325)); // Punto 20
        points.add(new LatLng(19.64695893639986, -101.22088197190786)); // Punto 19
        points.add(new LatLng(19.646989249077624, -101.22149351566716)); // Punto 18
        points.add(new LatLng(19.646504245555874, -101.22270050962646)); // Punto 17
        points.add(new LatLng(19.645943458396452, -101.23008731314107)); // Punto 16
        points.add(new LatLng(19.645958347201265, -101.23011849548503)); // SALIDA TEC Punto 23
        points.add(new LatLng(19.651802654856056, -101.2310745500926)); // Punto 24
        points.add(new LatLng(19.65243948333678, -101.23106817068903)); // Punto 25
        points.add(new LatLng(19.654837535299837, -101.23019270274511)); // Punto 26
        points.add(new LatLng(19.655299780310656, -101.22983865116944)); // Punto 27
        points.add(new LatLng(19.655746868487448, -101.22929148051118)); // Punto 28
        points.add(new LatLng(19.656177536991237, -101.22883818718027)); // Punto 29
        points.add(new LatLng(19.656678929654802, -101.22867323132587)); // Punto 30
        points.add(new LatLng(19.657497884316182, -101.22850034904583)); // Punto 31
        points.add(new LatLng(19.658451563100165, -101.22818232917511)); // Punto 32
        points.add(new LatLng(19.664824237165327, -101.22510534763751)); // Punto 33
        points.add(new LatLng(19.665476742697134, -101.22520813403757)); // Punto 34
        points.add(new LatLng(19.66611612428527, -101.22460501260882)); // Punto 35
        points.add(new LatLng(19.66809565737153, -101.22354341331162)); // Punto 36
        points.add(new LatLng(19.692147638272264, -101.21214557179282)); // Punto 37
        points.add(new LatLng(19.70026078368498, -101.20823186290477)); // Punto 38
        points.add(new LatLng(19.700588341263536, -101.20799040866721)); // Punto 39
        points.add(new LatLng(19.702226044574743, -101.20598244710698)); // Taqueria el infierno Punto 40
        points.add(new LatLng(19.702333371707212, -101.20454570932817));
        points.add(new LatLng(19.70235682304216, -101.20427293075788));
        points.add(new LatLng(19.702113432891792, -101.20391699071959));
        points.add(new LatLng(19.70207110413219, -101.20382332228847));
        points.add(new LatLng(19.69869412963577, -101.20141719705228));
        points.add(new LatLng(19.69766320675985, -101.1973898531212));
        points.add(new LatLng(19.697365284465906, -101.19683231834578));
        points.add(new LatLng(19.697115067606518, -101.19615082385717));
        points.add(new LatLng(19.69689789455046, -101.19531665685838));
        points.add(new LatLng(19.696238797802735, -101.19514767769014));
        points.add(new LatLng(19.695914201899484, -101.19103219265511));
        points.add(new LatLng(19.695939454746785, -101.18895884508701));

        drawRoute(points);

    }

    private void drawRoute(List<LatLng> points) {
        PolylineOptions polylineOptions = new PolylineOptions()
                .addAll(points)
                .color(Color.BLUE)
                .width(5);
        polyline = mMap.addPolyline(polylineOptions);

        // Mueve la cámara para mostrar toda la ruta
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng point : points) {
            builder.include(point);
        }
       mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 100)); }


    private void calcRealDistance(LatLng location) {
        double distance = SphericalUtil.computeDistanceBetween(location, MapUtils.getDestitationDelivery());
        binding.tvDistance.setText(getString(R.string.tracking_distance, MapUtils.formatDistance(distance)));
        binding.btnFinish.setEnabled(distance < 60);
    }

    private fun getEstimate() {
        lifecycleScope.launch {
            val remoteDataAccess = RemoteDataAccess()
            val origen = com.example.myapplicationurbus.common_kotlin.utils.MapUtils.getOrigen()
            val destino =
                    com.example.myapplicationurbus.common_kotlin.utils.MapUtils.getDestitation()
            val result = remoteDataAccess.getMedidas(
                    "metric",
                    "${origen.latitude},${origen.longitude}",
                    "${destino.latitude},${destino.longitude}",
                    constantes.KEY_DISTANCE_MATRIX
            )
        }

    }

    private fun setupDeliveryInfoToUi(info: DeliveryInfo){
        with(binding){
            tvTime.setText(info.rows[0].elements[0].duration.text)
            tvOrigen.setText(getString(R.string.tracking_origin))
            tvDestitation.setText(getString(R.string.tracking_destitation, info.destitation_addresses[0]))
            tvTotalDistance.setText(getString(R.string.tracking_total_distance,
                    info.rows[0].elements[0].distance.text))

        }
    }


    /*
    *  //funcion para tener una aproximacion del tiempo y dstancia ?

    private fun getEstimate() {
        lifecycleScope.launch {
            val remoteDataAccess = RemoteDataAccess()
            val origen = com.example.myapplicationurbus.common_kotlin.utils.MapUtils.getOrigen()
            val destino =
                com.example.myapplicationurbus.common_kotlin.utils.MapUtils.getDestitation()
            val result = remoteDataAccess.getMedidas(
                "metric",
                "${origen.latitude},${origen.longitude}",
                "${destino.latitude},${destino.longitude}",
                constantes.KEY_DISTANCE_MATRIX
            )
        }

    }

   *
    */
}