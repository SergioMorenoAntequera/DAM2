package com.example.windiurno.p09agendasergiomoreno;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etDatos = (EditText) findViewById(R.id.etDatos);
    }

    public void guardarClick(View view){
        //Guarda en preferencces "Agenda" el nombre y los datos asociados a ese nombre
        SharedPreferences preferencias = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferencias.edit();

        objEditor.putString(etNombre.getText().toString(), etDatos.getText().toString());
        objEditor.commit();

        Toast.makeText(this, "El contacto ha sido guardado", Toast.LENGTH_SHORT);
        limpiar(view);
    }

    //Busca una clave que será el nombre y si la encuentra la pone en el edittext datos
    public void buscarClick(View view){
        SharedPreferences preferencias = getSharedPreferences("Agenda", Context.MODE_PRIVATE);
        //
        String datos = preferencias.getString(etNombre.getText().toString(), "");
        //Si no ncuentra la clave nos devuelve ""(Cadena vacia en datos)
        if(datos.length() == 0){
            Toast.makeText(this, "Persona no encontrada", Toast.LENGTH_SHORT);
            limpiar(view);
        } else {
            etDatos.setText(datos);
        }
    }

    public void limpiar(View view){
        etDatos.setText("");
        etNombre.setText("");
    }
}
