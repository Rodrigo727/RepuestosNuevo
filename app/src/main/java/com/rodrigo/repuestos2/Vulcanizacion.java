package com.rodrigo.repuestos2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Vulcanizacion extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulcanizacion);
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
        LatLng NegroB = new LatLng(-36.958267, -73.012321);
        mMap.addMarker(new MarkerOptions().position(NegroB).title("JEM HNOS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NegroB,5));

        LatLng Negro = new LatLng(-36.958154, -73.012371);
        mMap.addMarker(new MarkerOptions().position(Negro).title("Negro Bueno"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Negro,5));

        LatLng Jr = new LatLng(-36.949379, -73.015155);
        mMap.addMarker(new MarkerOptions().position(Jr).title("Negro Bueno Junior"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Jr,5));

    }
}