package com.example.windiurno.p14reporductoraudiosergiomoreno;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bSoundPoolm, bMediaPlayerm;
    SoundPool sp;
    int sonidoReproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SoundPool = Sonido cortos(Max 1 MB)
        //MediaPlayer = Sonidos Largos

        bSoundPoolm = (Button) findViewById(R.id.bSoundPool);
        bMediaPlayerm = (Button) findViewById(R.id.bMediaPlayer);

        //PARA APIS MENOOS QUE 21(menor que android 5.0)
        //Vamos a tener que hacer un objeto soundPool para poder reproducir un sonido de ese tipo
        //parametros // Másximo de reproducciones seguidas, Tipo de stream de audio, calidad de reprodución
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonidoReproduccion = sp.load(this, R.raw.sonidocorto,  1);
        //Con ese metodo conseguimos un ID que después nos hará falta
    }

    public void SoundPoolClick(View v){
        sp.play(sonidoReproduccion, 1, 1, 1, 1, 0);
    }

    public void AudioMediaPlayerClick(View v){
        //Crear un objeto MediaPlayer(contexto, sonido de R.raw, t)
        //evento Start para empezar el sonido
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sonidolargo);
        mp.start();
    }
}
