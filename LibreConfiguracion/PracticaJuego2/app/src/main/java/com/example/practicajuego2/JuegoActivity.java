package com.example.practicajuego2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JuegoActivity extends BaseActivity {

    int danio, dinero, numeroClicks;
    int vidaEnemigo;

    Button bCorazon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        //Inicializamos
        bCorazon = findViewById(R.id.bCorazon);
        numeroClicks = 0;
        //Pantalla Completa
        setModoInmersivo();
        //Cogemos los datos del bundle que hay en el intent
        recogerDatos();

        vidaEnemigo = (int) (Math.random() * (danio*10)) + danio*5;
        bCorazon.setText(vidaEnemigo+"");
    }

    //----------------------------------------------------------------------------------------------

    public void recogerDatos(){
        Bundle datos = getIntent().getExtras();

        danio = datos.getInt(MainActivity.DANIO);
        dinero = datos.getInt(MainActivity.DINERO);
    }

    public void atacar(View v){

        vidaEnemigo -= danio;

        if(vidaEnemigo >= 1){
            numeroClicks++;
            int vidaRestante = Integer.parseInt(bCorazon.getText().toString());
            bCorazon.setText(vidaRestante - danio + "");
        }

        if(vidaEnemigo <= 0){
            bCorazon.setText(0 + "");

            //Añadimos el dinero y lo ponemos en el Intent
            dinero += (int) (Math.random() * 15) + 8;
            Intent i = getIntent();

            Bundle bundle = i.getExtras();
            bundle.putInt(MainActivity.DINERO, dinero);
            bundle.putInt(MainActivity.NUMCLIKS, numeroClicks);

            i.putExtras(bundle);
            setResult(RESULT_OK, i);

            //Dialog que sale al final--------------------------------------------------------------
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Victoria!");
            builder.setMessage("Has derrotado a tu enemigo y conseguido dinero!");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    finish();
                }
            });
            builder.show();
        }


    }
}
