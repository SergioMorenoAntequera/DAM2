package com.example.windiurno.p08almacenamientodedatospreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView email;
    String men = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.etEmail);

        //Primero recuperamos de nuestra clase preferencias el valor del email
        //Para eso primero creamos un objeto SharedPrefences
        SharedPreferences preferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
    }

    public void guardar(View view){
        men = email.getText().toString();
    }

}
