package com.example.windiurno.examensergiomoreno;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import javax.sql.DataSource;

public class exa2SergioMoreno extends AppCompatActivity {

    String usuario, contrasenia;
    TextView tvUsuario;

    ScrollView scScrollViewm;
    ImageButton[] vectorIb;
    ImageButton ibDisco1m, ibDisco2m, ibDisco3m;

    MediaPlayer[] vectorMp;
    MediaPlayer mpCancion1m, mpCancion2m, mpCancion3m;
    MediaPlayer mpAux;


    WebView wvPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exa2_sergio_moreno);

        usuario = getIntent().getStringExtra("usuario");
        contrasenia = getIntent().getStringExtra("contrasenia");

        //Usuario arriba
        tvUsuario = (TextView) findViewById(R.id.etUsuario2);
        tvUsuario.setText(usuario);

        //ScrollView
        scScrollViewm = (ScrollView) findViewById(R.id.scCancion);
        vectorIb = new ImageButton[3];
        ibDisco1m = (ImageButton) findViewById(R.id.ibDisco1);
        ibDisco2m = (ImageButton) findViewById(R.id.ibDisco2);
        ibDisco3m = (ImageButton) findViewById(R.id.ibDisco3);
        vectorIb[0] = ibDisco1m;
        vectorIb[1] = ibDisco2m;
        vectorIb[2] = ibDisco3m;

        vectorMp = new MediaPlayer[3];




        //Visor pagina web
        wvPaginas = (WebView) findViewById(R.id.wvPagina);
        wvPaginas.setWebViewClient(new WebViewClient());
    }

    public void elegirCancion(View v){
        if(v.getId() == ibDisco1m.getId()){
            wvPaginas.loadUrl("http://www.musicarelajante.es");
        }
        if(v.getId() == ibDisco2m.getId()){
            wvPaginas.loadUrl("https://www.freeaudiolibrary.com/es/");
        }
        if(v.getId() == ibDisco3m.getId()){
            wvPaginas.loadUrl("https://www.freemusicprojects.com/es/");
        }
    }


    public void atrasClick(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
