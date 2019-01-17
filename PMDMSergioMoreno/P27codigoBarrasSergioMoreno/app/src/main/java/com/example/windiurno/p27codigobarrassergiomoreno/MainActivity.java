package com.example.windiurno.p27codigobarrassergiomoreno;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private Button bEscanear;

    //En este ejemplo en lugar de crear un objeto de esult handler ha hecho quela clase sea el
    //Mismo result handler y oir eso se ahorra el crear un objeto de la misma y pone el this.
    private ZXingScannerView zxsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------

        //Pedimos los permisos
        if(ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1000);
        }


    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void handleResult(Result result) {
        //Opcion 1
        MediaPlayer mp = MediaPlayer.create(this, R.raw.roadrunner);
        mp.start();

        //Creamos caja de dialogo
        AlertDialog.Builder aviso = new AlertDialog.Builder(this);

        //tITULOO DE LA CAJA DE dialogo
        aviso.setTitle("Resultado");

        if(result.getText().equals("8480000725646")){
            aviso.setMessage("Enorabuena has escaneado la pasión floral");
            MediaPlayer mp2 = MediaPlayer.create(this, R.raw.pasion);
            mp2.start();
        } else {
            if(result.getText().contains("http")) {
                //Prepara un intent para abrir el navegador de una url
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getText()));
                //Abre eñ navegador
                startActivity(i);

            } else {
                aviso.setMessage(result.getText());
            }
        }

        AlertDialog mensaje = aviso.create();
        mensaje.show();

        //Obligatorio
        zxsv.resumeCameraPreview(this);
        zxsv.stopCamera();
        setContentView(R.layout.activity_main );

    }

    //----------------------------------------------------------------------------------------------

    //Metodo para escanear que se le asigna al boton
    public void scanear(View v){

        //Iniciaos variables
        zxsv = new ZXingScannerView(getApplicationContext());
        setContentView(zxsv);

        //Activar la camara con el scaner
        zxsv.setResultHandler(this);
        zxsv.startCamera();
    }
}
