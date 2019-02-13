package com.example.practicaasyntasks;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JuegoActivity extends BaseActivity implements D_iniciar.OnD_iniciar {

    TextView tvNombre, tvPuntosJugador;
    ArrayList<ProgressBar> pbs;
    int[] progresos;
    ProgressBar pb1, pb2, pb3, pb4, pb5, pbJugador;
    int progreso1 = 0, progreso2 = 0, progreso3 = 0, progreso4 = 0, progreso5 = 0, progresoJugador = 0;
    Button avanzar;
    int terminado = 0; //-1 ha ganado la maquina // 0 no ha ganado nadie // 1 ha ganado el usuario

    private ControlTask controlTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        tvNombre = findViewById(R.id.tvNombre);

        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        pb3 = findViewById(R.id.pb3);
        pb4 = findViewById(R.id.pb4);
        pb5 = findViewById(R.id.pb5);

        pbs = new ArrayList<>();
        pbs.add(pb1);
        pbs.add(pb2);
        pbs.add(pb3);
        pbs.add(pb4);
        pbs.add(pb5);

        progresos = new int[5];
        progresos[0] = progreso1;
        progresos[1] = progreso2;
        progresos[2] = progreso3;
        progresos[3] = progreso4;
        progresos[4] = progreso5;

        pbJugador = findViewById(R.id.pbJugador);
        tvPuntosJugador = findViewById(R.id.tvPuntosJugador);
        avanzar = findViewById(R.id.bAvanzar);

        setModoInmersivo();
        mostrarDialogo();
    }

    //----------------------------------------------------------------------------------------------

    public void mostrarDialogo(){
        D_iniciar dialogoIniciar = D_iniciar.newInstance();

        dialogoIniciar.setCancelable(false);
        dialogoIniciar.show(getFragmentManager(),"dialogoIniciar");
    }

    //----------------------------------------------------------------------------------------------

    //Metodo que nos devuelve los valores introducidos en el diálogo
    @Override
    public void onDIniciar(String nombre) {
        tvNombre.setText("Carrera de: " + nombre);
        controlTask = new ControlTask();
        controlTask.execute(progreso1, progreso2, progreso3, progreso4, progreso5);
    }

    //----------------------------------------------------------------------------------------------

    //Rellenamos nuestra propia barra
    public void avanzarClick(View v){
        if(terminado == 0){
            progresoJugador +=2;
            tvPuntosJugador.setText(progresoJugador+"%");
            pbJugador.setProgress(progresoJugador);

            if(progresoJugador >= 100){
                terminado = 1;
            }
        }
        comprobarGanador();
    }

    //----------------------------------------------------------------------------------------------
    ///////// Clase interna /////////////////////////////////////////////////////////////////////////

    public class ControlTask extends AsyncTask<Integer, Integer, Integer> {

        // Parametros progreso Resultasdo
        @Override
        protected Integer doInBackground(Integer... integers) {// entran paran salen resultado

            while (terminado != 1 && integers[0] <= 100 && integers[1] <= 100 && integers[2] <= 100 && integers[3] <= 100 && integers[4] <= 100) {

                for (int i = 0; i < integers.length; i++) {

                    //Vamos rellenando las 5 barras cada una con numeros aleatorios
                    integers[i] += (int) (Math.random() * 3 + 1);
                    if (integers[i] >= 100) {
                        terminado = -1;
                        break;
                    }
                }

                //Esto nos pasa al siguiente
                controlTask.publishProgress(integers[0], integers[1], integers[2], integers[3], integers[4]);

                SystemClock.sleep(250);

                if (this.isCancelled())
                    break;


            }
            return 0;
        }

        //------------------------------------------------------------------------------------------

        @Override
        protected void onProgressUpdate(Integer... values) {// progreso
            super.onProgressUpdate(values);

            //Ponemos los valores dentro de las barras
            for(int i = 0; i < pbs.size(); i++){
                //Aparecen en el  39 y la barra se termina al 59
                pbs.get(i).setProgress(values[i]);
            }

        }

        //------------------------------------------------------------------------------------------

        @Override
        protected void onPostExecute(Integer integer) {// resultado
            super.onPostExecute(integer);

            comprobarGanador();
        }

        //------------------------------------------------------------------------------------------
    }

    public void comprobarGanador(){
        if (terminado == 1) {
            new AlertDialog.Builder(this)
                    .setTitle("¡Victoria!")
                    .setMessage("Felicidades, has ganado al 100%!")
                    .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();
        } else {
            if ((terminado == -1)) {
                new AlertDialog.Builder(this)
                        .setTitle("¡Derrota!")
                        .setMessage("Lo sentimos, has perdido al " + progresoJugador + "%!")
                        .setPositiveButton("Volverlo a intentar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
            }
        }
    }

}
