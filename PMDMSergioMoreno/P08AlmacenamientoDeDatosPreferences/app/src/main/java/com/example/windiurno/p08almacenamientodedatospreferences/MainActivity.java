package com.example.windiurno.p08almacenamientodedatospreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView etMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail = (TextView) findViewById(R.id.etEmail);

        //Primero recuperamos de nuestra clase preferencias el valor del email
        //Para eso primero creamos un objeto SharedPrefences
        SharedPreferences preferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
        etMail.setText(preferences.getString("mail", ""));
    }

    //Guarda el email en el SharePreferences Dato con la etiqueta email
    public void guardarClick(View view){
        SharedPreferences preferences = getSharedPreferences("dato", Context.MODE_PRIVATE);
        //Como vamos a editar las preferences creamos un objeto editor
        SharedPreferences.Editor objetoEditor = preferences.edit();
        //Escribir en el campo mail
        objetoEditor.putString("mail", etMail.getText().toString());
        //Confirmar que queremos guardar los cambios
        objetoEditor.commit();
        //Finalizamos automaticamente para probar más rapido la aplicacion
        finish();
    }

}
