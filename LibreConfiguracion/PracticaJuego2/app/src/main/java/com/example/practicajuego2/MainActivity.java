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

    public final static int REQUEST_CODE = 1;

    int danio = 3;
    int dinero = 30;
    int dineroMejora = 5;
    private int numeroClicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDanio = findViewById(R.id.tvDanio);
        tvDinero = findViewById(R.id.tvDinero);
        bMejorar = findViewById(R.id.bMejorar);
        bLuchar = findViewById(R.id.bLuchar);

        setModoInmersivo();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onResume() {
        super.onResume();

        setModoInmersivo();
        //Para que cada vez que vuelva al primer activity se actualicen los valores
        colocarValores();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent datos){
        if(requestCode == REQUEST_CODE) {
            //Comprobar el tipo de resultado (resultCode)
            if(resultCode == RESULT_OK) {

                //Recogemos los datos---------------------------------------------------------------
                //int totalClicks = datos.getIntExtra(NUMCLIKS, 0);
                Bundle bundle = datos.getExtras();

                danio  = bundle.getInt(MainActivity.DANIO);
                //Este dinero ya tiene sumado la victoria del anterior activity
                dinero  = bundle.getInt(MainActivity.DINERO);
                numeroClicks  = bundle.getInt(MainActivity.NUMCLIKS);

                Toast.makeText(this, "Enemigo derrotado en " + numeroClicks + " ataques", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Los que se rinden no se merecen nada!", Toast.LENGTH_SHORT).show();
                dinero = 0;
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    //Metodos variados
    //Iniciar el Activity 2 y pasarle los datos-----------------------------------------------------
    public void jugar(View v){
        Intent i = new Intent(this, JuegoActivity.class);
        Bundle datos = new Bundle();

        datos.putInt(DANIO, this.danio);
        datos.putInt(DINERO, this.dinero);
        datos.putInt(NUMCLIKS, this.numeroClicks);

        i.putExtras(datos);

        startActivityForResult(i, REQUEST_CODE);
    }

    //Cambia dinero por daño------------------------------------------------------------------------
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

    //Coloca danio y dinero-------------------------------------------------------------------------
    public void colocarValores(){
        tvDanio.setText(danio+"");
        tvDinero.setText(dinero + " / " + dineroMejora);
    }
}
