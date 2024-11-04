package com.example.loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.loginsql.databinding.ActivityMycourcesBinding;

public class MycourcesActivity extends AppCompatActivity {

    ActivityMycourcesBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMycourcesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.FooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MycourcesActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        binding.FooterDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MycourcesActivity.this,timetableactivity.class);
                startActivity(intent);

            }
        });
        binding.FooterSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MycourcesActivity.this, myfile.class);
                startActivity(intent);

            }
        });


    }
}