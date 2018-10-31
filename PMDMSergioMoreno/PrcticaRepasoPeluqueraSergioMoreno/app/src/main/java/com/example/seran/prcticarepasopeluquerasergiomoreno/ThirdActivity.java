package com.example.seran.prcticarepasopeluquerasergiomoreno;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.prefs.Preferences;

public class ThirdActivity extends AppCompatActivity {

    Button bAtras2;
    TextView multiDatos;
    String datoRecibido;
    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        preferencias = getSharedPreferences("Registros", Context.MODE_PRIVATE);

        bAtras2 = (Button) findViewById(R.id.bAtras2);
        multiDatos = (TextView) findViewById(R.id.multiDatos);

        datoRecibido = getIntent().getStringExtra("nombre");
        try {
            File tarjetaSD = Environment.getExternalStorageDirectory(); //Y por qué no un string? Tío yo que se, esto es asi
            //Toast.makeText(this, "Ruta: " + tarjetaSD.getPath(), Toast.LENGTH_LONG).show();

            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(datoRecibido));

            //Crea el buffer
            BufferedReader contenedor = new BufferedReader(abrirArchivo);

            //Para leer de un fichero de texto vamos a hacerlo linea por linea
            String linea = contenedor.readLine();
            //Creo una variable en la cual voy a almacenar cada linea
            String contenidoCompleto = "";

            //Bucle lara recorrer el archivo leyendo cada linea
            while(linea != null) {
                contenidoCompleto += linea + "\n";
                linea = contenedor.readLine();
            }
            contenedor.close();
            abrirArchivo.close();

            multiDatos.setText(contenidoCompleto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Toast.makeText(this, "Dato " + datoRecibido, Toast.LENGTH_SHORT).show();
    }

    public void atrasClick(View view){
        finish();
    }
}
