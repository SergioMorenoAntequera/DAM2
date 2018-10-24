package com.example.windiurno.p07webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Activityweb extends AppCompatActivity {

    private WebView wvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityweb);

        //Capturamos el objeto
        wvm = (WebView) findViewById(R.id.webView);

        //Recuperamoa la URL del parametro que psamos en el priemr activity
        String URLDestino = getIntent().getStringExtra("url");

        //Cofiguramos el objeto WebView
        wvm.setWebViewClient(new WebViewClient());

        //Indicamos a que URL tiene que navegar
        wvm.loadUrl(URLDestino);

        //No olvidarse de solicitar permiso en AndroidManifest
        //Para poder acceder a internet (La carpeta de la izquierda)
        //<uses-permission android:name="android.permission.INTERNET"/>
    }

    public void cerrar(View view){
        //Como funciona el boton de echar patras
        finish();
    }


}
