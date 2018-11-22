package com.example.seran.repaso4sergiomoreno;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton ibPlaym, ibRepetirm, ibGrabarm;
    boolean repetir = false;

    MediaRecorder mr;
    MediaPlayer mp;
    String nombreGrabacion = null;
    int posicion = 0;


    ArrayList<MediaPlayer> vectorMp = new ArrayList<MediaPlayer>(0);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibPlaym = (ImageButton) findViewById(R.id.ibPlay);
        ibRepetirm = (ImageButton) findViewById(R.id.ibRepetir);
        ibGrabarm = (ImageButton) findViewById(R.id.ibGrabar);


        vectorMp.add(MediaPlayer.create(this, R.raw.race));
        vectorMp.add(MediaPlayer.create(this, R.raw.sound));
        vectorMp.add(MediaPlayer.create(this, R.raw.tea));
        vectorMp.add(MediaPlayer.create(this, R.raw.race));
        /*try {
            vectorMp.add(MediaPlayer.create(mp.setDataSource(nombreGrabacion), this);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

   public void ElegirCancion(View v){

       if(vectorMp.get(0).isPlaying()){
            vectorMp.get(0).stop();
       }
       if(vectorMp.get(1).isPlaying()){

           vectorMp.get(1).stop();
       }
       if(vectorMp.get(2).isPlaying()){

           vectorMp.get(2).stop();
       }
       if(vectorMp.get(3).isPlaying()){

           vectorMp.get(3).stop();
       }

       switch (v.getId()) {
           case R.id.ibCancion1: {
               posicion = 0;
               vectorMp.get(posicion).start();
           }
           break;
           case R.id.ibCancion2: {
               posicion = 1;
               vectorMp.get(posicion).start();
           }
           break;
           case R.id.ibCancion3: {
               posicion = 2;
               vectorMp.get(posicion).start();
           }
           break;
           case R.id.ibCancion4: {
               posicion = 3;
               vectorMp.get(posicion).start();
           }
           break;
       }
       ibPlaym.setBackgroundResource(R.drawable.pausa);
   }

    public void PlayPauseClick(View v){
        //PAra saber si se esta repoidciendo uso el metodo .isPlaying
        if(vectorMp.get(posicion).isPlaying()){

            vectorMp.get(posicion).pause();
            ibPlaym.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "CANCION PAUSADA", Toast.LENGTH_LONG);

        } else { //En este caso está en pausa
            vectorMp.get(posicion).start();
            ibPlaym.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "CANCION EN MARCHA", Toast.LENGTH_LONG);
        }
    }

    public void stopClick(View v){
        vectorMp.get(posicion).stop();
        ibPlaym.setBackgroundResource(R.drawable.reproducir);
        posicion = 0;

        Toast.makeText(this, "TODO PARADO", Toast.LENGTH_LONG);
    }

    public void siguienteClick(View v){
        if(posicion < vectorMp.size()-1){
            if(vectorMp.get(posicion).isPlaying()){
                vectorMp.get(posicion).stop();
                posicion++;
                vectorMp.get(posicion).start();
            } else {
                posicion++;
            }
        } else{
            Toast.makeText(this, "NO HAY NA MÁS", Toast.LENGTH_LONG).show();
        }

    }

    public void anteriorClick(View v){
        if(posicion > 0){
            if(vectorMp.get(posicion).isPlaying()){
                vectorMp.get(posicion).stop();
                posicion--;
                vectorMp.get(posicion).start();
            } else {
                posicion--;
            }
        } else{
            Toast.makeText(this, "NO HAY NA MÁS", Toast.LENGTH_LONG).show();
        }

    }

    public void repetirClick(View v){
        if(repetir){ //No repetir
            Toast.makeText(this, "Repetir: OFF", Toast.LENGTH_LONG).show();
            ibRepetirm.setBackgroundResource(R.drawable.no_repetir);
            vectorMp.get(posicion).setLooping(false);
            repetir = false;

        } else {
            Toast.makeText(this, "Repetir: ON", Toast.LENGTH_LONG).show();
            ibRepetirm.setBackgroundResource(R.drawable.repetir);
            vectorMp.get(posicion).setLooping(true);
            repetir = true;
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
}
