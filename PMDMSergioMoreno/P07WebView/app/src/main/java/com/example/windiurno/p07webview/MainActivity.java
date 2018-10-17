package com.example.windiurno.p07webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etURLm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etURLm = (EditText) findViewById(R.id.etURL);

    }

    //Metodo para click del boton y
    public void irAlSitio(View view){
        Intent i = new Intent(this, Activityweb.class);
        i.putExtra("url", etURLm.getText().toString());
        startActivity(i);

    }

}
