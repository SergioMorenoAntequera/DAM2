package com.example.windiurno.p15reproductordemusica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton ibPlaym, ibRepetirm;
    MediaPlayer mp;
    ImageView ivPortadam;

    int repetir = 2, posicion = 0;
    //Crear un array para contener las canciones
    MediaPlayer[] vectorMp = new MediaPlayer[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibPlaym = (ImageButton) findViewById(R.id.ibPlay);
        ibRepetirm = (ImageButton) findViewById(R.id.ibRepetir);
        ivPortadam = (ImageView) findViewById(R.id.ivPortada);

        //Crear un array de identificadores de las pistas
        vectorMp[0] = MediaPlayer.create(this, R.raw.race);
        vectorMp[1] = MediaPlayer.create(this, R.raw.sound);
        vectorMp[2] = MediaPlayer.create(this, R.raw.tea);

    }

    //METODOS PARA LOS BOTONES
    public void PlayPauseClick(View v){
        //PAra saber si se esta repoidciendo uso el metodo .isPlaying
        if(vectorMp[posicion].isPlaying()){

            vectorMp[posicion].pause();
            ibPlaym.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "CANCION PAUSADA", Toast.LENGTH_LONG);

        } else { //En este caso está en pausa
            vectorMp[posicion].start();
            ibPlaym.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "CANCION EN MARCHA", Toast.LENGTH_LONG);
        }
    }

    public void stopClick(View v){
        vectorMp[posicion].stop();
        ibPlaym.setBackgroundResource(R.drawable.reproducir);
        posicion = 0;

        Toast.makeText(this, "TODO PARADO", Toast.LENGTH_LONG);
    }

    public void siguienteClick(View v){
        if(posicion < vectorMp.length-1){
            if(vectorMp[posicion].isPlaying()){
                vectorMp[posicion].stop();
                posicion++;
                vectorMp[posicion].start();
            } else {
                posicion++;
            }
            cambiarPortada();
        } else{
            Toast.makeText(this, "NO HAY NA MÁS(y esto es mu cutre pa que te develva a la primera)", Toast.LENGTH_LONG).show();
        }

    }

    public void anteriorClick(View v){
        if(posicion > 0){
            if(vectorMp[posicion].isPlaying()){
                vectorMp[posicion].stop();
                posicion--;
                vectorMp[posicion].start();
            } else {
                posicion--;
            }
            cambiarPortada();
        } else{
            Toast.makeText(this, "NO HAY NA MÁS(y esto es mu cutre pa que te develva a la ultima)", Toast.LENGTH_LONG).show();
        }

    }

    public void repetirClick(View v){
        if(repetir == 1){ //No repetir
            Toast.makeText(this, "Repetir: OFF", Toast.LENGTH_LONG).show();
            ibRepetirm.setBackgroundResource(R.drawable.no_repetir);
            vectorMp[posicion].setLooping(false);
            repetir = 2;

        } else {
            Toast.makeText(this, "Repetir: ON", Toast.LENGTH_LONG).show();
            ibRepetirm.setBackgroundResource(R.drawable.repetir);
            vectorMp[posicion].setLooping(true);
            repetir = 1;
        }
    }

    //METODOS A PARTE
    private void cambiarPortada() {
        if(posicion == 0){
            ivPortadam.setImageResource(R.drawable.portada1);
        }
        if(posicion == 1){
            ivPortadam.setImageResource(R.drawable.portada2);
        }
        if(posicion == 2){
            ivPortadam.setImageResource(R.drawable.portada3);
        }
    }
}
