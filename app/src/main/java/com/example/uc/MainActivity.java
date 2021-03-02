package com.example.uc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Converter buttons
        ImageButton temp_button = findViewById(R.id.temperature);
        temp_button.setOnClickListener((v) -> {
            Intent intent = new Intent(this, Temperature.class);
            startActivity(intent);
        });

        ImageButton cooking_button = findViewById(R.id.cooking);
        cooking_button.setOnClickListener((v) -> {
            Intent intent = new Intent(this, Cooking.class);
            startActivity(intent);
        });


        ImageButton fuel_button = findViewById(R.id.fuel);
        fuel_button.setOnClickListener((v) -> {
            Intent intent = new Intent(this, Fuel.class);
            startActivity(intent);
        });


        ImageButton speed_button = findViewById(R.id.speed);
        speed_button.setOnClickListener((v) -> {
            Intent intent = new Intent(this, Speed.class);
            startActivity(intent);
        });



        //Implicit Intent
        ImageButton camera_button = findViewById(R.id.camera);
        camera_button.setOnClickListener((v) -> {
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        });



    }
}