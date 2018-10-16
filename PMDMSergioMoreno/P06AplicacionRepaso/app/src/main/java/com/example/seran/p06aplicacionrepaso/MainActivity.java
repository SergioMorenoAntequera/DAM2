package com.example.seran.p06aplicacionrepaso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, pass;
    private Button siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conseguimos objetos de la interfaz
        usuario = (EditText) findViewById(R.id.ptUsuario);
        pass = (EditText) findViewById(R.id.pContrasenia);
        siguiente = (Button) findViewById(R.id.bSiguiente);
    }

    public void comprobar(View view){
        //if(usuario.getText().toString() == "Maria" && pass.getText().toString() == "maria2018"){
            Intent siguienteActivity = new Intent(this, Activity2.class);
            startActivity(siguienteActivity);
        //}
    }
}
