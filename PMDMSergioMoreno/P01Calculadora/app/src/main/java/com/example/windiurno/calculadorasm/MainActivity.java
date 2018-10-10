package com.example.windiurno.calculadorasm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etOp1;
    private EditText etOp2;
    private TextView tvResultado, tvTit;
    private Button bCalcular;
    private RadioButton rbEspanol, rbAleman, rbJap, rbKurdo;
    private Spinner spOpci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conseguimos los objetos de la interfaz
        etOp1 = findViewById(R.id.etOperando1);
        etOp2 = findViewById(R.id.etOperando2);
        tvResultado = findViewById(R.id.tvResultado);

        rbEspanol = findViewById(R.id.rbEspa);
        rbAleman = findViewById(R.id.rbAle);
        rbJap = findViewById(R.id.rbJapo);
        rbKurdo = findViewById(R.id.rbKurdo);

        tvTit = findViewById(R.id.tvTitulo);
        bCalcular = (Button) findViewById(R.id.bCalcular);

        //*****Parameter opciones dentro de un desplegable como este se hace así*****
        spOpci = (Spinner) findViewById(R.id.spOpciones);
        String[] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_opciones, opciones);
        spOpci.setAdapter(adapter);
    }

    public void sumar(View view){
        //Sumar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 + n2;

        tvResultado.setText(resultado+"");
    }

    public void restar(View view){
        //restar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 - n2;

        tvResultado.setText(resultado+"");
    }

    public void multiplicar(View view){
        //restar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 * n2;

        tvResultado.setText(resultado+"");
    }

    public void dividir(View view){
        //restar los numero
        int n1 = Integer.parseInt(etOp1.getText().toString());
        int n2 = Integer.parseInt(etOp2.getText().toString());
        int resultado = n1 / n2;

        tvResultado.setText(resultado+"");
    }

    public void traducir(View view){

        if(rbEspanol.isChecked()){
            tvTit.setText(getResources().getString(R.string.sETitulo));
            etOp1.setHint(getResources().getString(R.string.sEOperando1));
            etOp2.setHint(getResources().getString(R.string.sEOperando2));
            bCalcular.setText(getResources().getString(R.string.sECalcular));
            tvResultado.setText(getResources().getString(R.string.sEResultado));
        }

        if(rbAleman.isChecked()){
            tvTit.setText(getResources().getString(R.string.sAtitulo));
            etOp1.setHint(getResources().getString(R.string.sAOperando1));
            etOp2.setHint(getResources().getString(R.string.sAOperando2));
            bCalcular.setText(getResources().getString(R.string.sECalcular));
            tvResultado.setText(getResources().getString(R.string.sAResultado));
        }

        if(rbJap.isChecked()){
            tvTit.setText(getResources().getString(R.string.sJtitulo));
            etOp1.setHint(getResources().getString(R.string.sJOperando1));
            etOp2.setHint(getResources().getString(R.string.sJOperando2));
            bCalcular.setText(getResources().getString(R.string.sECalcular));
            tvResultado.setText(getResources().getString(R.string.sJResultado));
        }

        if(rbKurdo.isChecked()){
            tvTit.setText(getResources().getString(R.string.sKTitulo));
            etOp1.setHint(getResources().getString(R.string.sKOperando1));
            etOp2.setHint(getResources().getString(R.string.sKOperando2));
            bCalcular.setText(getResources().getString(R.string.sECalcular));
            tvResultado.setText(getResources().getString(R.string.sKResultado));
        }
    }

    public void Calcular (View view){
        String seleccion = spOpci.getSelectedItem().toString();

        if(seleccion.equals("Sumar")){
            sumar(view);
        }
        if(seleccion.equals("Restar")){
            restar(view);
        }
        if(seleccion.equals("Multiplicar")){
            multiplicar(view);
        }
        if(seleccion.equals("Dividir")){
            dividir(view);
        }
    }

    /*
    Spinner.setOnItemSelectedListener(new OnItemSelectedListener()){
        public void onItemSelected(AdapterView)
    }
    */
}
