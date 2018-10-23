package com.example.seran.prcticarepasopeluquerasergiomoreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView usuario;
    private ListView listaSemana;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        listaSemana = (ListView) findViewById(R.id.lSemana);
        usuario = (TextView) findViewById(R.id.etNombre2);


        String dato = getIntent().getStringExtra("Usuario");
        usuario.setText(dato);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_second, dias);
        listaSemana.setAdapter(adapter);

    }
}
