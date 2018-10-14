package com.example.windiurno.p03imagebuttonsergiomoreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton imagenLibro;
    private ImageButton imagenMano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonManoClick(View view){
        Toast.makeText(this, "Pulsado el boton maono", Toast.LENGTH_SHORT);
    }

    public void botonLibroClick(View view){
        Toast.makeText(this, "Pulsado el boton libro", Toast.LENGTH_SHORT);
    }
}
