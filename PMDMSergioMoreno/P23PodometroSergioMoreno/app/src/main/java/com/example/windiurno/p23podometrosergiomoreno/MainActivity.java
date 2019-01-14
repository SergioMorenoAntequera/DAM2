package com.example.windiurno.p23podometrosergiomoreno;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private SensorEventListener andar;
    private Sensor sensor;

    EditText etPasosADar;
    Button bEmpezar, bRendirse;
    TextView tvPasos, tvObjetivo;
    ImageView ivPersona;

    int pasosActuales, objetivo;

    SoundPool sp;
    int sonidoReproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------------------------

        //Variables
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        etPasosADar = (EditText) findViewById(R.id.etPasosADar);
        bEmpezar = (Button) findViewById(R.id.bEmpezar);
        bRendirse= (Button) findViewById(R.id.bRendirse);
        tvPasos = (TextView) findViewById(R.id.tvPasos);
        tvObjetivo = (TextView) findViewById(R.id.tvObjeivo);
        ivPersona = (ImageView) findViewById(R.id.ivPersona);

        //------------------------------------------------------------------------------------------

        //Con esto comprobamos si el teléfono tiene podómetro
        if(sensor == null){
            Toast.makeText(this, "No tienes podómetro", Toast.LENGTH_LONG).show();
            bEmpezar.setEnabled(false);
        }

        //------------------------------------------------------------------------------------------

        //Listener del podometro
        andar = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event) {
                //Sie hemos llegao nos termina y si no suma y sigue
                if(pasosActuales == objetivo){
                    terminar();
                } else {
                    pasosActuales++;
                    tvPasos.setText(pasosActuales+"");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

    }

    //----------------------------------------------------------------------------------------------

    public void empezar(View v){
        //Reiniciamos las cosas
        pasosActuales = 0;
        tvPasos.setText(0+"");
        bEmpezar.setEnabled(false);
        bRendirse.setEnabled(true);

        //Controlamos la excepcon de que si no hay nada no lo pone
        if(etPasosADar.getText().toString().length() != 0){
            //Cogemos los pasos que hemos puesto arriba, los pasamos al objetivo y limpiamos arriba
            objetivo = Integer.parseInt(etPasosADar.getText().toString());
            tvObjetivo.setText(objetivo+"");
            etPasosADar.setText("");

            //Activamos el sensor y limitamos los pasos al objetivo
            //Lo segundo se hace dentro del EventListener
            sensorManager.registerListener(andar, sensor, SensorManager.SENSOR_DELAY_GAME);
        } else {
            Toast.makeText(this, "Introduce un objetivo arriba", Toast.LENGTH_LONG).show();
            bEmpezar.setEnabled(true);
            bRendirse.setEnabled(false);
        }
    }

    //----------------------------------------------------------------------------------------------

    public void rendirse(View v){
        //reiniciar
        sensorManager.unregisterListener(andar);
        Toast.makeText(this, "¿Ya te has cansado?", Toast.LENGTH_LONG).show();
        bRendirse.setEnabled(false);
        bEmpezar.setEnabled(true);

        //Sonidos
        sonidoReproduccion = sp.load(this, R.raw.grito,  1);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sp.play(sonidoReproduccion, 1, 1, 1, 1, 0);
    }

    //----------------------------------------------------------------------------------------------

    public void terminar(){
        sensorManager.unregisterListener(andar);
        Toast.makeText(this, "FELICICADES POR LA CAMINATA", Toast.LENGTH_LONG).show();

        sonidoReproduccion = sp.load(this, R.raw.matasuegras,  1);
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sp.play(sonidoReproduccion, 1, 1, 1, 1, 0);

        bEmpezar.setEnabled(true);
        bRendirse.setEnabled(false);
    }

    //----------------------------------------------------------------------------------------------

    public void moverPersona(){

        int porcentajeRecorrido = ((pasosActuales * 100) / objetivo);
        //Hay que conseguir los parametros del XML para cambiar la posicion
    }


}