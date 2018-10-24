package com.example.windiurno.p10ficherosdetextosergiomoreno;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    //Antes de empezar a programar hemos:
        //Solicutar permisos de escritura manifest >> AndroidManifest >> <uses-permission>

    EditText etNombreFichm, etContenidom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombreFichm = (EditText) findViewById(R.id.etNombreFich);
        etContenidom = (EditText) findViewById(R.id.etContenido);
    }

    public void guardarClick(View view){

        String nombre = etNombreFichm.getText().toString();
        String contenido = etContenidom.getText().toString();

        //Como lo vamos a guardar en la SD y puede que no tenga y la ruta no sea válida
        //Lo tenemos que meter en un try catch
        try {

            //Resuperamos la ruta de la tarjeta SD con la clase Enviroment
            //Para ello creamos un fichero auxiliar

            File tarjetaSD = Environment.getExternalStorageDirectory(); //Y por qué no un string? Tío yo que se, esto es asi
            Toast.makeText(this, "Ruta valida: " + tarjetaSD.getPath(), Toast.LENGTH_SHORT).show();

            //Cremaos un fichero con el nombre que el usuario ha elegido
            File archivoUsuario = new File(tarjetaSD.getPath(), nombre);

            //Abrimos el archivo pero para ESCRIBIR
            OutputStreamWriter miArchivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            //Pasamos el texto de mi EditText al archivo
            miArchivo.write(contenido);

            //Limpiamos el Buffer
            miArchivo.flush();
            miArchivo.close();

            //Dejamos sin nada las cosas del Cativity
            etNombreFichm.setText("");
            etContenidom.setText("");

        } catch (IOException e) {
            Toast.makeText(this, "Erro al guardar el archivo", Toast.LENGTH_LONG).show();
        }


    }

    public void leerClick(View view){

        String nombre = etNombreFichm.getText().toString();

       try {

           File tarjetaSD = Environment.getExternalStorageDirectory(); //Y por qué no un string? Tío yo que se, esto es asi
           Toast.makeText(this, "Ruta: " + tarjetaSD.getPath(), Toast.LENGTH_LONG).show();

           //Abrir el dichero para lectura modo privado
           InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

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

            etContenidom.setText(contenidoCompleto);
           Toast.makeText(this, "Todo ok makei", Toast.LENGTH_LONG).show();

       } catch (Exception e){
           Toast.makeText(this, "La liaste John Lancaster", Toast.LENGTH_LONG).show();
       }
    }

}
