package com.example.loginsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.content.Intent;

import com.example.loginsql.databinding.ActivitySchoolactivityBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class schoolactivity extends AppCompatActivity implements OnMapReadyCallback {

    ActivitySchoolactivityBinding binding;
    private GoogleMap mymap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySchoolactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.FooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(schoolactivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        binding.FooterDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(schoolactivity.this,dashboardactivity.class);
                startActivity(intent);

            }
        });
        binding.FooterSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(schoolactivity.this,schoolactivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mymap = googleMap;
        LatLng myschool = new LatLng(5.961689998387881,80.5467843203875);
        mymap.addMarker(new MarkerOptions().position(myschool).title("My School PVT Limited"));
        mymap.moveCamera(CameraUpdateFactory.newLatLng(myschool));


    }
}