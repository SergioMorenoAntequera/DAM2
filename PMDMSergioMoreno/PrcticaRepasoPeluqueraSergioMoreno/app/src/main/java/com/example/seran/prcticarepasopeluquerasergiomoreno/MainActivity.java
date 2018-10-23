package com.example.seran.prcticarepasopeluquerasergiomoreno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoUsuario, campoPass;



    SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoUsuario = (EditText) findViewById(R.id.ptUsuario);
        campoPass = (EditText) findViewById(R.id.ptPass);
    }

    public void registrarClick (View view){
        //Guarda en preferencces "Registros" el nombre y los datos asociados a ese nombre
        preferencias = getSharedPreferences("Registros", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferencias.edit();

        String datoUsuario = campoUsuario.getText().toString();
        String datoPass = campoPass.getText().toString();

        if(!preferencias.contains(datoUsuario)){

            objEditor.putString(datoUsuario, datoPass);
            objEditor.commit();
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Usuario ocupado", Toast.LENGTH_SHORT).show();

        }
    }

    public void entrarClick(View view){
        preferencias = getSharedPreferences("Registros", Context.MODE_PRIVATE);

        String datoUsuario = campoUsuario.getText().toString();
        String datoPass = campoPass.getText().toString();

        if(datoPass.equalsIgnoreCase(preferencias.getString(datoUsuario, datoPass))){

            //Toast.makeText(this, "BINGO", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, SecondActivity.class);
            //Creamos una variable tipo String y se la pasamos
            i.putExtra("Usuario", datoUsuario);
            startActivity(i);

        } else {
            Toast.makeText(this, "Contraseña equivocada", Toast.LENGTH_SHORT).show();
        }

    }

    public void limpiar(View view){
        campoUsuario.setText("");
        campoPass.setText("");
    }
}
