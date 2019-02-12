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

    TextView tvNombre;
    ArrayList<ProgressBar> pbs;
    int[] progresos;
    ProgressBar pb1, pb2, pb3, pb4, pb5, pbJugador;
    int progreso1 = 0, progreso2 = 0, progreso3 = 0, progreso4 = 0, progreso5 = 0;
    Button avanzar;

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
        for(int i = 0; i < pbs.size(); i++){
            pbs.get(i).setScaleX(6f);
            pbs.get(i).setScaleY(6f);
            pbs.get(i).setMax(100);
            pbs.get(i).incrementProgressBy(2);
        }
        progresos = new int[5];
        progresos[0] = progreso1;
        progresos[1] = progreso2;
        progresos[2] = progreso3;
        progresos[3] = progreso4;
        progresos[4] = progreso5;

        pbJugador = findViewById(R.id.pbJugador);
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
    } //Preguntale a Paco

    //----------------------------------------------------------------------------------------------
    ///////// Clase interna /////////////////////////////////////////////////////////////////////////

    public class ControlTask extends AsyncTask<Integer, Integer, Integer> {

        // Parametros progreso Resultasdo
        @Override
        protected Integer doInBackground(Integer... integers) {// entran paran salen resultado
            //SystemClock.sleep(2000);
            boolean control = true;
            while (control && integers[0] <= 100 && integers[1] <= 100 && integers[2] <= 100 && integers[3] <= 100 && integers[4] <= 100) {

                for(int i = 0; i < integers.length; i++){
                    //integers[i] += (int)(Math.random()*10+1);
                    integers[i] += 1;
                    //tvNombre.setText(integers[i]+"");
                    Log.d("BARRA--------> ["+i+"]=", ""+integers[i]);
                    if(integers[i]>=100) {
                        control=false;
                        break;
                    }

                }

                //Esto nos pasa al siguiente
                controlTask.publishProgress(integers[0], integers[1], integers[2], integers[3], integers[4]);
                if(!control)
                    break;

                SystemClock.sleep(500);

                if (this.isCancelled())
                    break;
            }
            return 1;
        }

        //------------------------------------------------------------------------------------------

        @Override
        protected void onProgressUpdate(Integer... values) {// progreso
            super.onProgressUpdate(values);

            //Ponemos los valores dentro de las barras
            for(int i = 0; i < pbs.size(); i++){
                tvNombre.setText(values[i]+"");
                //Aparecen en elñ 39
                pbs.get(i).setProgress(values[i]);
            }
        }

        //------------------------------------------------------------------------------------------

        @Override
        protected void onPostExecute(Integer integer) {// resultado
            super.onPostExecute(integer);

            new AlertDialog.Builder(JuegoActivity.this)
                    .setTitle("Final de la partida")
                    .setMessage("Has perdido")
                    .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(JuegoActivity.this, "Boton acept pulsado", Toast.LENGTH_SHORT).show();
                            /*tvNombre.setText("Test");
                            mostrarDialogo();
                            numerarBotones(desordenarBotones());*/
                        }
                    })
                    .setNegativeButton("Volver", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
        }

        //------------------------------------------------------------------------------------------

        /*@Override
        protected void onCancelled() {
            super.onCancelled();
            if(contador==5){
                controlTask=new ControlTask();
                numerarBotones(desordenarBotones());
                tvFrase.setText(getString(R.string.fase,String.valueOf(++numFase)));
                contador = 1;
                progreso = 0;
                proBar.setProgress(0);
                // aumentar la velocidad
                velocidad = velocidad-5 <= 0?1:velocidad-5;
                controlTask.execute(velocidad,progreso);
            }
        }*/
    }

}
