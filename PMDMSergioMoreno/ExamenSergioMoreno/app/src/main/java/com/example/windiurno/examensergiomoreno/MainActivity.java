package com.example.windiurno.examensergiomoreno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {
    TextView etUsuariom, etContram;
    Button bEntrar;

    String usuario="usu", contrasenia="123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuariom = (TextView) findViewById(R.id.etUsuario2);
        etContram = (TextView) findViewById(R.id.etContra);
        bEntrar = (Button) findViewById(R.id.bEntrar);

        //si el archivo no exite lo creamos
        File archivo = new File("claves.txt");
        if(!archivo.exists() || archivo.length() == 0){
            try (PrintWriter pw = new PrintWriter((new FileWriter(archivo)))) {

                //Rellenamos las 2 primera lineas con los datos
                archivo.createNewFile();
                pw.println("usu");
                pw.println("123");

            } catch (IOException e) { }
        } else {
            try(BufferedReader fl = new BufferedReader(new FileReader(archivo))){

                //Recogemos los datos que hemos escrito arriba linea a linea
                usuario = fl.readLine();
                contrasenia = fl.readLine();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void pasarInfo(View v){

        Intent i = new Intent(this, exa2SergioMoreno.class);

        if(etUsuariom.getText().toString().equalsIgnoreCase(usuario) && etContram.getText().toString().equalsIgnoreCase(contrasenia)){

            i.putExtra("usuario", usuario);
            i.putExtra("contrasenia", contrasenia);

            startActivity(i);

        } else {


            Toast.makeText(this, "Usuario/contraseña mal", Toast.LENGTH_LONG).show();
        }
    }
}
