package com.example.windiurno.holamundosergiomoreno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "evento onCrate", Toast.LENGTH_SHORT).show();

    }

    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "evento onStart", Toast.LENGTH_SHORT).show();
    }

}
