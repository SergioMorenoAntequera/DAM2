package com.example.practicajuego2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private TextView tvDanio, tvDinero;
    private Button bMejorar, bLuchar;

    public final static String DANIO="nDanio";
    public final static String DINERO="nDinero";
    public final static String NUMCLIKS="nClicks";

    public final static int REQUEST_CODE=-1;

    int dinero = 30;
    int dineroMejora = 5;
    int danio = 3;
    private int numeroClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDanio = findViewById(R.id.tvDanio);
        tvDinero = findViewById(R.id.tvDinero);
        bMejorar = findViewById(R.id.bMejorar);
        bLuchar = findViewById(R.id.bLuchar);
    }

    //----------------------------------------------------------------------------------------------

    public void recogerDatoJuego(){
        Bundle datos = getIntent().getExtras();

        danio = datos.getInt(MainActivity.DANIO);
        dinero = datos.getInt(MainActivity.DINERO);
        numeroClicks = datos.getInt(MainActivity.NUMCLIKS);
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onStart() {
        super.onStart();

        //Pantalla completa y rellenar los distintos campos
        setModoInmersivo();

        //Colocamos los valores recogidos en la parte de arriba
        colocarValores();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent datos){
        super.onActivityResult(requestCode, resultCode, datos);
        // check if the request code is same as what is passed  here it is 2
            dinero = datos.getExtras().getInt(MainActivity.DINERO);
            colocarValores();
    }

    //----------------------------------------------------------------------------------------------

    public void jugar(View v){
        Intent i=new Intent(this, JuegoActivity.class);
        Bundle datos=new Bundle();

        int danio, dinero;
        danio=this.danio;
        dinero=this.dinero;

        datos.putInt(DANIO, danio);
        datos.putInt(DINERO, dinero);

        i.putExtras(datos);

        startActivityForResult(i, REQUEST_CODE);
    }

    public void mejorarArma(View v){
        if(dinero >= dineroMejora){
            dinero -= dineroMejora;
            dineroMejora += dineroMejora/2;
            int danioAumentado = (int) (Math.random() * 5) + 1;
            danio += danioAumentado;

            colocarValores();

            Toast.makeText(this, "Tu fuerza ha aumentado "+ danioAumentado +" puntos!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Necesitas " + dineroMejora + " para mejorar tu arma", Toast.LENGTH_SHORT).show();
        }
    }

    public void colocarValores(){

        tvDanio.setText(danio+"");
        tvDinero.setText(dinero + " / " + dineroMejora);

    }
}
