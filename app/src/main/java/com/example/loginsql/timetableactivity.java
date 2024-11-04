package com.example.loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.example.loginsql.databinding.ActivityDashboardactivityBinding;
import com.example.loginsql.databinding.ActivityTimetableactivityBinding;

public class timetableactivity extends AppCompatActivity {

    ActivityTimetableactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTimetableactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.FooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(timetableactivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        binding.FooterDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(timetableactivity.this,dashboardactivity.class);
                startActivity(intent);

            }
        });
        binding.FooterSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(timetableactivity.this,schoolactivity.class);
                startActivity(intent);

            }
        });
    }
}