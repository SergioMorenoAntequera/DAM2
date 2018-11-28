package com.example.windiurno.p18actionbarmenuoverflowsergiomoreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lo primero es crearse una nuvo "resource File" con el nombre overflow y en la categoría de Menu
        //y ya ahñi le metemos todas las paridas como "menu items", cambiamos nombre y tal

    }

    // Crear un método para mostrar y ocultar el menú overflow
    // TIENE QUE DEVOLVER TRUE Y LLAMARSE ASÍ Y TENER DE PARAMETERO UN Menu
    //Es sobreescribir un método
    /*
     * En el metodo onCreateOptionMenu creamos un objero de la clase MenuInflater
     * mediante el metodo inflate vinculamos el idetntificados col archico de recursos
     * R.menu.overflow y el objeto de la clase menú que llega como parámetro.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Los paraetros son la clase overflow que se crea al principio y el menú que recibe como parámetro
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //Ahora creamos un metodo para gestionar nosotros cual
    //es el menu que se ha pulsado
    // Método para asignas la fuuncionaldad a cada uno de las opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        //Captura la id del item que hemos pulsado
        int id = item.getItemId();

        //Como son pocas coas lo hacemos con if, se recomienda hacer con switch
        if(id == R.id.miOpcion1){
            Toast.makeText(this, "Opción 1", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.miOpcion2){
            Toast.makeText(this, "Opción 2", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.miOpcion3){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //Como esta aplicación se ha uedao muy fea camos a ponerla mona

}
