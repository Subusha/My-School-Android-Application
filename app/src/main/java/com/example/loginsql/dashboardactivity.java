package com.example.loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.example.loginsql.databinding.ActivityDashboardactivityBinding;
public class dashboardactivity extends AppCompatActivity {

   ActivityDashboardactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.FooterHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardactivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
        binding.FooterDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardactivity.this,dashboardactivity.class);
                startActivity(intent);

            }
        });
        binding.FooterSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dashboardactivity.this,schoolactivity.class);
                startActivity(intent);

            }
        });




    }
}