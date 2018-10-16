package com.example.seran.p06aplicacionrepaso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    private ListView lista;
    private TextView resultado;
    private Button siguiente;
    private RadioButton enero, febrero, marzo, abril;
    private String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        lista = (ListView) findViewById(R.id.lLista);
        resultado = (TextView) findViewById(R.id.tvResultado);
        siguiente = (Button) findViewById(R.id.bAtras);

        enero = (RadioButton) findViewById(R.id.rbEnero);
        febrero = (RadioButton) findViewById(R.id.rbFebrero);
        marzo = (RadioButton) findViewById(R.id.rbMarzo);
        abril = (RadioButton) findViewById(R.id.rbAbril);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_layout, dias);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                //Buscar el seleccionado
                String mes = "";
                if(enero.isSelected()){
                    mes = enero.getText().toString();
                }
                if(febrero.isSelected()){
                    mes = febrero.getText().toString();
                }
                if(marzo.isSelected()){
                    mes = marzo.getText().toString();
                }
                if(abril.isSelected()){
                    mes = abril.getText().toString();
                }
                //programamos el evento click de los items de la lista
                resultado.setText("Hoy es " + lista.getItemAtPosition(p) + " de " + mes);
            }
        });
    }

    public void atras(View view){
        Intent anteriorActivity = new Intent(this, MainActivity.class);
        startActivity(anteriorActivity);
    }
}
