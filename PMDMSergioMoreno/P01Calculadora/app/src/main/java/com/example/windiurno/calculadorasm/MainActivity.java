package com.example.windiurno.calculadorasm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etOp1;
    private EditText etOp2;
    private TextView tvResult;
    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conseguimos los objetos de la interfaz
        etOp1 = findViewById(R.id.etOperando1);
        etOp2 = findViewById(R.id.etOperando2);
        tvResult = findViewById(R.id.tvResultado);

    }

    public void sumar(View view){
        //Sumar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 + n2;

        tvResult.setText(resultado);
    }

    public void restar(View view){
        //restar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 - n2;

        tvResult.setText(resultado);
    }


}
