package com.example.windiurno.p20camarafotossergiomoreno;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView ivVisorm;
    ImageButton ibCamaram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivVisorm = (ImageView) findViewById(R.id.ivVisor);

        //Comparar si se han dado los permisos des escritura y de acceder a la cámara
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);


        }
    }


    String mCurrentPhotoPath;

    //Metodo copiado de la API de android que crea combre unicos para cada foto
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "P20_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    //Metod que hacfe fotos al pulsar el botón
    static final int RESPUESTA_HACER_FOTO = 1;
    public void HacerFotoClick(View v){
        //Se cierra de forma momentanea el actual activity para mostrar lo que se ve en la camara
        //Pa ellos vamos a crear una variable staic final
        Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(fotoIntent.resolveActivity(getPackageManager()) != null){
            //Esto significa que se ha hecho la foto
            //Creamos un fichero para la foto
            File ficheroFoto=null;
            try {
                //Recuperar el nombre y la ruta del fichero
                ficheroFoto.createNewFile();
            } catch (Exception ex){
                Toast.makeText(this, "Error al crear el fichero", Toast.LENGTH_SHORT).show();
            }

            if(ficheroFoto != null){
                Uri fotoUri = FileProvider.getUriForFile(this, "com.example.android.fileprovider", ficheroFoto);
                fotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);

                startActivityForResult(fotoIntent, RESPUESTA_HACER_FOTO);

            }
        } else {
            Toast.makeText(this, "No se ha hecho la foto", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESPUESTA_HACER_FOTO && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivVisorm.setImageBitmap(imageBitmap);
        }
    }
}

