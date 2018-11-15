package com.example.windiurno.p16grabadorasonidossergiomoreno;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaRecorder mr;
    MediaPlayer mp;
    String nombreGrabacion = null;
    ImageButton ibGrabarm, ibReproducirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pedir los permisos para poder usar el microfono y guardar archivos
        ibGrabarm = (ImageButton) findViewById(R.id.ibGrabar);
        ibReproducirm = (ImageButton) findViewById(R.id.ibReproducir);

        //Esto comprueba si tenemos los permisos
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            //Si no las tenemos lo piden
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);

        }

    }

    public void grabarClick(View v) {
        if (mr == null) {
            nombreGrabacion = Environment.getExternalStorageDirectory().getAbsolutePath() + "/miGrabacion.mp3";
            mr = new MediaRecorder();
            //""No, si es que cada uno lo hace como más le guste""
            //Conectar el micrófono
            mr.setAudioSource(MediaRecorder.AudioSource.MIC);
            //Formato de salida de audio
            mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            //Codificador de salida
            mr.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            //Asignnamos el nombre de fichero de salida al objeto mr
            mr.setOutputFile(nombreGrabacion);

            //Empezar a grabar
            try {
                mr.prepare();
                //Comenzamos la grabacion
                mr.start();
            } catch (Exception e) {
                Toast.makeText(this, "LA liaste john lancaster", Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this, "Grabación iniciada", Toast.LENGTH_LONG).show();
            ibGrabarm.setBackgroundResource(R.drawable.rec);

        } else {
            //Existe y está confiigurado lo que quiere el usuario es grabar la grabacion
            mr.stop();
            mr.release();
            mr = null;

            Toast.makeText(this, "Grabación finalizada", Toast.LENGTH_LONG).show();
            ibGrabarm.setBackgroundResource(R.drawable.stop_rec);
        }
    }

    public void playClick(View v){

        mp = new MediaPlayer();

        try {
            mp.setDataSource(nombreGrabacion);
            mp.prepare();
        } catch (Exception e){

        }
        mp.start();
        Toast.makeText(this, "Reproducion audio", Toast.LENGTH_LONG).show();
    }
}
