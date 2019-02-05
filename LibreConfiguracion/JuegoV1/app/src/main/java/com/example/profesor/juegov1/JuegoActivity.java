package com.example.profesor.juegov1;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JuegoActivity extends AppCompatActivity {
    int [] numeros = new int []{
            R.drawable.ic_1n,
            R.drawable.ic_2n,
            R.drawable.ic_3n,
            R.drawable.ic_4n,
            R.drawable.ic_5n,
            R.drawable.ic_6n
    };
    int [] colores = new int []{
            R.drawable.ic_1c,
            R.drawable.ic_2c,
            R.drawable.ic_3c,
            R.drawable.ic_4c,
            R.drawable.ic_5c,
            R.drawable.ic_6c,
    };
    protected int [] tablero; //seran igual a numeros o a colores
    protected int [][] valoresCeldas; //para los valores que valen los botones
    int [][] idCeldas; //para crear un id a cada celda~boton que guardare aqui
    MatrizJuego miMatriz;
    LinearLayout layoutTablero; //El layout que dejamos sin rellenar
    int filas, columnas, nElelemntos, vibrar, sonar, esnumero, numClicks, altura;
    Chronometer crono1; //el crono
    TextView tvClicks;
    Vibrator vibService;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        //Cogemos del layout
        crono1=(Chronometer)findViewById(R.id.crono1);
        tvClicks=(TextView)findViewById(R.id.tv_Clicks);

        layoutTablero=(LinearLayout)findViewById(R.id.layoutTablero);
        layoutTablero.removeAllViews();

        //------------------------------------------------------------------------------------------

        //Metodo para coger los datos del activity anterior
        cogerDatoJuego();

        //------------------------------------------------------------------------------------------

        //Colocamos los datos recogidoa arriba para configurar la pantalla
        if(vibrar==1)
            //damos permisos con el manifest
            vibService=(Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        if(sonar == 1)
            mp = MediaPlayer.create(this, R.raw.touch);

        //inicializamos la matriz inicial del juego
        miMatriz = new MatrizJuego(filas, columnas, nElelemntos);
        valoresCeldas = miMatriz.getMatriz();

        //Elegimos colores o numeros en funcion de esnumeros
        if(esnumero == 1){
            tablero = numeros;
        } else {
            tablero = colores;
        }

        //Ponemos la pantalla
        //Esto nos deja pintar el activity menos los 180 pixeles que es el menu de arriba
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        altura = (dm.heightPixels-1800)/filas;

        numClicks = 0;

        //-----------------------------------------------------------------------------------------

        iniciaJuego();
    }

    //----------------------------------------------------------------------------------------------

    public void cogerDatoJuego(){
        Bundle datos = getIntent().getExtras();

        filas = datos.getInt(MainActivity.FILAS);
        columnas = datos.getInt(MainActivity.COLUMNAS);
        nElelemntos = datos.getInt(MainActivity.ELEMENTOS);
        esnumero = datos.getInt(MainActivity.NUMEROS);
        vibrar = datos.getInt(MainActivity.VIBRAR);
        sonar = datos.getInt(MainActivity.SONAR);
    }

    //----------------------------------------------------------------------------------------------

    public void iniciaJuego(){
        int iBoton = 0;
        int valor = 0;

        for(int i = 0; i<filas; i++){
            //creamos un layout por fila
            LinearLayout lyFila = new LinearLayout(this);
            lyFila.setOrientation(LinearLayout.HORIZONTAL);

            for(int j = 0; i<columnas; j++){
                valor = valoresCeldas[i][j];

                //Creamos cada uno de los botones dentro de las filas
                //Le paso el fondo y le pongo listener e id
                Celdas celda = new Celdas(this, ++iBoton, nElelemntos, valor, tablero[valor], i, j);
                //Con este le ponemos una ID que queramos para android
                celda.setId(iBoton);
                idCeldas[i][j] = iBoton;

                celda.setLayoutParams(new LinearLayout.LayoutParams(0, altura, 1.0f));

                //Listener a los botones
                celda.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Esto se hace porque como celda lo estoy herexdando de Celda y tengo que tener
                        //un view le hago un casting así (SIEMPRE SE HACE)
                        pulsarCelda(((Celdas)v).fila, ((Celdas)v).columna);
                    }
                });

                //Lo añadimos
                lyFila.addView(celda);
            }

            //Añadimos los botones ya creados con todas sus cosicas al Layout que creamos antes
            layoutTablero.addView(lyFila);
        }
    }

    //----------------------------------------------------------------------------------------------

    public void pulsarCelda(int f, int c){
        crono1.start();

        if (sonar == 1) {
            mp.start();
        }
        if(vibrar == 1){
            vibService.vibrate(80);
        }
        tvClicks.setText(++numClicks+"");

        //Cambio las filas
        for (int i= maximo(0, f-1); i<minimo(f-1, f+1); i++){
            cambiar(i, c);
        }

        //Cambio las columnas
        for (int i = maximo(0, c-1); i<minimo(c-1, c+1); i++){
            if(i == c) continue;
            cambiar(i, c);
        }

        checkGanar();
    }

    //----------------------------------------------------------------------------------------------

    //Esto compara cualquier celda(En este caso la primeera)
    //Con todas las demas, si no lo son no has ganado todavia
    private void checkGanar() {
        int target = valoresCeldas[0][0];
        for(int i = 0; i<filas; i++){
            for(int j = 0; j<columnas; j++){
                if(valoresCeldas[i][j] != target) return;
            }
        }
        //Se llegamos aqui hemos ganado
        Intent i = new Intent();
        i.putExtra(MainActivity.TOTAL_CLIKS, numClicks);
        setResult(RESULT_OK, i);
        finish();
    }

    //----------------------------------------------------------------------------------------------

    private void cambiar(int f, int c) {
        //Cojo la id de la celda que quiero cambiar
        int idCelda = idCeldas[f][c];
        //Recupero la celda
        Celdas celda = (Celdas) findViewById(idCelda);

        //Cojo el nuevo fondo para esa celda
        int nuevoValor = celda.getNuevoFondo();
        //Se actualiza el nuevo valor en el array
        valoresCeldas[f][c] = nuevoValor;
        //Cambio el fondo de la celda
        celda.setBackgroundResource(tablero[nuevoValor]);
        //Para que la pinte sin problemas
        celda.invalidate();
    }

    //----------------------------------------------------------------------------------------------

    public int maximo(int a, int b){
        if(a>b) return a;
        return b;
    }

    public int minimo(int a, int b){
        if(a<b) return a;
        return b;
    }


}
