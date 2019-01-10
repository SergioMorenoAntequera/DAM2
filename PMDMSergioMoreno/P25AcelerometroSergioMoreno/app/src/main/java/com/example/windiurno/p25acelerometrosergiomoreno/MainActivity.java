package com.example.windiurno.p25acelerometrosergiomoreno;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Button btJugar;
    private TextView tvResultado;
    final float  PUNTUACION = 1.123f;

    private SoundPool sp;
    private int rep;

    SensorManager manager;
    Sensor acSensor;

    //----------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cosas de la activity
        btJugar = (Button) findViewById(R.id.btJugar);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        //Cosas de sonido
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        rep = sp.load(this, R.raw.grito, 1);

        //Cosas del sensor
        manager = (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        acSensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    //----------------------------------------------------------------------------------------------

    public void onJugar(View v){
        tvResultado.setText("DALE UN BUEN MENEO");
        btJugar.setEnabled(false);
        manager.registerListener(this, acSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Capturamos el valor
        //En este caso lo sacamos de este array donde estás las 3 cordenadas
        //El valor 0 es el x || 1 el y || y el 2 la z
        int valor = Math.round(event.values[2]);
        //Los datos devueltos son de m/s de la aceleración
        //a la que se ha movido el movil

        //Comprobación del resultado
        if(valor >= 15 || valor <= -15){
            //Formateo de la salida
            int puntuacion = (int)(valor* PUNTUACION);
            String resultado = "";

            //--------------------------------------------------------------------------------------

            resultado += "La acelleracion ha sido: " + valor + "\n";
            resultado += "La puntuacion es: " + puntuacion;
            tvResultado.setText(resultado);
            //Reproducimos el sonido
            sp.play(rep, 1, 1, 1, 0, 0);

            //--------------------------------------------------------------------------------------

            //Finalizar la escucha
            manager.unregisterListener(this);
            btJugar.setEnabled(true);

        } else {
            if(valor >=13 && valor <=-13 || valor <-13 && valor > -15){
                tvResultado.setText("CON MAS FUERZA");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
