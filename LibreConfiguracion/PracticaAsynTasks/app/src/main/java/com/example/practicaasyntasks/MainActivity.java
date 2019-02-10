package com.example.practicaasyntasks;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private Button bInstrucciones, bIniciar;
    private EditText etNombre;

    Dialog dInstrucciones, dIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bInstrucciones = findViewById(R.id.bInstrucciones);
        bIniciar = findViewById(R.id.bIniciar);
        etNombre = findViewById(R.id.etNombre);

        setModoInmersivo();
    }

    //----------------------------------------------------------------------------------------------

    //Metodos boton de instrucciones
    public void mostrarInstrucciones(View v){
        dInstrucciones = new Dialog(this);
        dInstrucciones.setContentView(R.layout.d_instrucciones);
        dInstrucciones.show();
    }
    public void cerrarInstrucciones(View v){
        dInstrucciones.dismiss();
        setModoInmersivo();
    }

    //Metodos boton Iniciar
    public void iniciarJuego(View v) {
        Intent i = new Intent(this, JuegoActivity.class);
        startActivity(i);
    }
}