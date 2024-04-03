package com.example.myapplicationurbus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainConfiguracion extends AppCompatActivity {
    ImageButton IBtHome;
//https://www.youtube.com/watch?v=_dhFsvEeuCs mapa
    //https://www.youtube.com/watch?v=L6B8LUGp2VA mapa 2
    //degradado :  https://www.youtube.com/watch?v=RzL1PBzUtZk
  //  @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_configuracion);
        IBtHome= findViewById(R.id.IBtHome);
        IBtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(MainConfiguracion.this, MainActivity.class);//agregar el otro
                startActivity(intent);
            }
        });{}
    }
    }
