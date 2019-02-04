package com.example.practicajuego2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JuegoActivity extends BaseActivity{

    int danio, dinero;
    int vidaEnemigo, numeroClicks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        setModoInmersivo();

        recogerDatoJuego();
        vidaEnemigo = (int) (Math.random() * (danio*10)) + danio*5;
    }

    public void recogerDatoJuego(){
        Bundle datos = getIntent().getExtras();

        danio = datos.getInt(MainActivity.DANIO);
        dinero = datos.getInt(MainActivity.DINERO);
    }

    public void atacar(View v){
        if(vidaEnemigo > 0){
            vidaEnemigo -= danio;
            numeroClicks++;
        } else {
            dinero += (int) (Math.random() * 15) + 8;
            Intent i = new Intent();
            i.putExtra(MainActivity.DINERO, dinero);
            i.putExtra(MainActivity.NUMCLIKS, numeroClicks);
            setResult(RESULT_OK);
            finish();
        }


    }
}
