package com.example.windiurno.p24giroscopiosergiomoreno;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.service.autofill.FieldClassification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor giroscopio;
    SensorEventListener escucharGiros;

    ImageView ivImagen;
    TextView tvGrados;
    Switch swInterruptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        tvGrados = (TextView) findViewById(R.id.tvGrados);
        swInterruptor = (Switch) findViewById(R.id.swInterruptor);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);

        //------------------------------------------------------------------------------------------

        //Comprobación de que el telefono tiene giroscopio
        if(giroscopio == null){
            Toast.makeText(this, "El dispositivo no tiene giroscopio", Toast.LENGTH_LONG).show();
            swInterruptor.setEnabled(false);
        }

        //------------------------------------------------------------------------------------------

        //Esto lo que hace es obtener la inclinación del dispositivo
        escucharGiros = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                //Obtenermos
                float[] rotationMatrix = new float[16];
                SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values);

                float[] remapped = new float[16];
                SensorManager.remapCoordinateSystem(rotationMatrix, sensorManager.AXIS_X,
                        SensorManager.AXIS_Z, remapped);

                float[] orientations = new float[3];
                SensorManager.getOrientation(remapped, orientations);

                //Convertimos la inclinación de radianes a grados
                for(int i = 0; i<3; i++) {
                    orientations[i] = (float) (Math.toDegrees(orientations[i]));
                }
                //Giramos la imagen em el sentido opuesto al cual giramos el telefono
                ivImagen.setRotation(orientations[2]*-1);
                //Cambiamos el texto que  nos indica la rotación
                tvGrados.setText((int) orientations[2] + "º");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        };
    }

    public void interruptorClick(View v){
        if(swInterruptor.isEnabled()){
            sensorManager.registerListener(escucharGiros, giroscopio, SensorManager.SENSOR_DELAY_GAME);
        } else {
            sensorManager.unregisterListener(escucharGiros);
            ivImagen.setRotation(0);
            tvGrados.setText("0º");
        }
    }
}
