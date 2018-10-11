package com.example.windiurno.p05dosactivitysergiomoreno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
    }

    //Metodo que cambia al segundo activiti
    public void AnteriorClick(View view){
        //Para comunicar acftivitys necesiamos hacerlo a traves de la clase Intent(como intento)

        //Cremao el objeto intent
        Intent anteriorActivity = new Intent(this, MainActivity.class);

        //Iniciamos el activity que queremos
        startActivity(anteriorActivity);
        //no ilvidarese de asignar al boton este metodo desde el .xml
    }
}
