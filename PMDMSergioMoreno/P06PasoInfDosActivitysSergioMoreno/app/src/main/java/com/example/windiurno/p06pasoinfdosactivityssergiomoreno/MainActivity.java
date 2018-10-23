package com.example.windiurno.p06pasoinfdosactivityssergiomoreno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNombrem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombrem = (EditText) findViewById(R.id.etNombre);
    }

    //Metodo que manda informacion al segundo activity
    public void enviarClick(View view){
        Intent i = new Intent(this, SegundoActivity.class);

        //Creamos una variable tipo String y se la pasamos
        i.putExtra("nombre", etNombrem.getText().toString());
        startActivity(i);
    }
}
