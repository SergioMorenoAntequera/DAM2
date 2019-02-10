package com.example.practicaasyntasks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JuegoActivity extends BaseActivity {

    TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        // pantalla completa
        setModoInmersivo();

        // agarramos todos los elemenstos
        tvNombre = findViewById(R.id.tvNombre);

        // mostramos dialogo de inicio
        mostrarDialogo();

    }

    public void mostrarDialogo(){
        D_iniciar miDialogoNombreNivel = D_iniciar.newInstance();

        miDialogoNombreNivel.setCancelable(false);
        miDialogoNombreNivel.show(getFragmentManager(),"D_iniciar");
    }

}
