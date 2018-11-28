package com.example.windiurno.p19botonesaccionsergiomoreno;

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



    }

    //mostrar y ocultar le menú contextual
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuacciones, menu);
        return true;
    }

    //Metodo para agregar opcciones a nuestros botones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id){
            case R.id.miCompartir: {
                Toast.makeText(this, "Compartiendo... xd", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.miBuscar: {
                Toast.makeText(this, "Buscando... xd", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.miSalir: {
                finish();
                Toast.makeText(this, "Pa fuera tol mundo", Toast.LENGTH_SHORT).show();
            }
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
