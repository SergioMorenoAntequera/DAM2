package com.example.windiurno.p21podometrosergiomoreno;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager SensorManager;
    private SensorEventListener andar;
    private Sensor podometro;

    TextView tvPasos;
    Button bEmpezar;

    int pasos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------------------------

        //Variables
        SensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        podometro = SensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        tvPasos = (TextView) findViewById(R.id.tvPasos);
        bEmpezar = (Button) findViewById(R.id.bEmpezar);

        //------------------------------------------------------------------------------------------

        //Con esto comprobamos si el teléfono tiene podómetro
        if(podometro == null){
            Toast.makeText(this, "No tienes podómetro", Toast.LENGTH_LONG).show();
            bEmpezar.setEnabled(false);
        }

        //------------------------------------------------------------------------------------------

        //Listener del podometro
        andar = new SensorEventListener() {

            @Override
            public void onSensorChanged(SensorEvent event) {
                
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };

        //------------------------------------------------------------------------------------------
    }


}
