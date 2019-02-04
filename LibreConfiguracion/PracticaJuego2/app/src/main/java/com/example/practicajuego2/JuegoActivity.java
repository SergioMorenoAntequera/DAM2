package com.example.practicajuego2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JuegoActivity extends BaseActivity {

    int danio, dinero;
    int vidaEnemigo, numeroClicks;

    Button bCorazon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        bCorazon = findViewById(R.id.bCorazon);

        setModoInmersivo();

        recogerDatoJuego();

        vidaEnemigo = (int) (Math.random() * (danio*10)) + danio*5;
        bCorazon.setText(vidaEnemigo+"");

    }

    public void recogerDatoJuego(){
        Bundle datos = getIntent().getExtras();

        danio = datos.getInt(MainActivity.DANIO);
        dinero = datos.getInt(MainActivity.DINERO);
        numeroClicks = datos.getInt(MainActivity.NUMCLIKS);
    }

    public void atacar(View v){
        vidaEnemigo -= danio;
        if(vidaEnemigo >= 1){
            numeroClicks++;
            int vidaREstante = Integer.parseInt(bCorazon.getText().toString());
            bCorazon.setText(vidaREstante-danio+"");
        }

        if(vidaEnemigo <= 0){
            bCorazon.setText(0+"" );

            //Añadimos el dinero y lo ponemos en el Intent
            dinero += (int) (Math.random() * 15) + 8;
            Intent i = new Intent();
            i.putExtra(MainActivity.DINERO, dinero);
            i.putExtra(MainActivity.NUMCLIKS, numeroClicks);
            setResult(RESULT_OK);

            //Dialog que sale al final
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
