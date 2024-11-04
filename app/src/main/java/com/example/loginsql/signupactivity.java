package com.example.loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginsql.databinding.ActivitySignupactivityBinding;

public class signupactivity extends AppCompatActivity {

    ActivitySignupactivityBinding binding;
    Database_Helper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        databaseHelper = new Database_Helper(this);

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String email = binding.signupEmail.getText().toString();
              String name = binding.signupName.getText().toString();
              String password = binding.signupPassword.getText().toString();
              String confirm_password = binding.signupConfirmPassword.getText().toString();


              if ( email.equals("") || name.equals("") || password.equals("") || confirm_password.equals(""))
              {
                  Toast.makeText(signupactivity.this, "All Fields Are Required", Toast.LENGTH_SHORT).show();
              }
              else {
                  if (password.equals(confirm_password))
                  {
                      Boolean checkUserEmail = databaseHelper.checkEmail(email);
                      if (checkUserEmail == false){
                          Boolean insertData = databaseHelper.insertData(email,name,password);

                          if (insertData == true)
                          {
                              Toast.makeText(signupactivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                              Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                              startActivity(intent);
                          }
                          else {
                              Toast.makeText(signupactivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                          }
                      }else {
                          Toast.makeText(signupactivity.this, "User Already Registered , Please Login", Toast.LENGTH_SHORT).show();
                      }
                  }else {
                      Toast.makeText(signupactivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                  }
              }


            }
        });

        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });


    }
}