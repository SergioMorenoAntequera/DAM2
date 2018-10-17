package com.example.windiurno.p06pasoinfdosactivityssergiomoreno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private TextView tvInfom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tvInfom = (TextView) findViewById(R.id.tvInfo);

        //Los objetos de tipo Intent nos permiten comunicarnos entre los distintos Activitys
        //Recupero en una variable "dato" la informacion de la variable del primer artículo
        String dato = getIntent().getStringExtra("nombre");
        tvInfom.setText("Hola " + dato);
    }

    public void regresarClick(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
