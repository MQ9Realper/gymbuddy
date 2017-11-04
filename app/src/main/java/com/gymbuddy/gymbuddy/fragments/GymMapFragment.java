package com.gymbuddy.gymbuddy.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gymbuddy.gymbuddy.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GymMapFragment extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    private  ArrayList<LatLng> locations;
    private ArrayList<String> locationTitles;

    public GymMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        locations = new ArrayList<>();
        locations.add(new LatLng(25.1574695,55.2865913)); //Body & Soul Health Club, Dubai
        locations.add(new LatLng(25.174511,55.2773351)); // Fitness 360
        locations.add(new LatLng(25.1504601,55.2170611)); // CrossFit Sands
        locations.add(new LatLng(25.0995362,55.1860818)); // Gold's Gym
        locations.add(new LatLng(25.0905654,55.1523546)); // Target Gym
        locations.add(new LatLng(25.1274057,55.1761759)); //Train Strength & Fitness

        locationTitles = new ArrayList<>();
        locationTitles.add("Body & Soul Health Club");
        locationTitles.add("Fitness 360");
        locationTitles.add("CrossFit Sands");
        locationTitles.add("Gold's Gym");
        locationTitles.add("Target Gym");
        locationTitles.add("Train Strength & Fitness");

        return inflater.inflate(R.layout.fragment_gym_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        try {
            SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);

        for (int i = 0; i < locations.size();i++) {
            MarkerOptions markerOptions = new MarkerOptions().position(locations.get(i)).icon(bitmapDescriptor);
            markerOptions.title(locationTitles.get(i));
            mMap.addMarker(markerOptions);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations.get(0), 11));

        mMap.setTrafficEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
