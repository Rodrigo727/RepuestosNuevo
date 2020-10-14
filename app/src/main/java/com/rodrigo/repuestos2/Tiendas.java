package com.rodrigo.repuestos2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Tiendas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agrega un marcador en Sydney y mueve la cámara
        LatLng TresB = new LatLng(-36.935148, -73.021362);
        mMap.addMarker(new MarkerOptions().position(TresB).title("Repuestos Tres BBB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TresB,5));

        LatLng ATresB = new LatLng(-36.935592, -73.020667);
        mMap.addMarker(new MarkerOptions().position(ATresB).title("Accesorios Tres BBB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ATresB,5));

        LatLng Cipreces = new LatLng(-36.925909, -73.024576);
        mMap.addMarker(new MarkerOptions().position(Cipreces).title("Los Cipreces"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Cipreces,5));

        LatLng Hualki = new LatLng(-36.971864, -72.937978);
        mMap.addMarker(new MarkerOptions().position(Hualki).title("Repuestos Hualqui"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hualki,5));

    }
}