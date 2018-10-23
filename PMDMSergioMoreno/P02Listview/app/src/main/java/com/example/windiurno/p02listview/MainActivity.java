package com.example.windiurno.p02listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInformacion;
    private ListView lvLista;

    private String[] nombres = {"Miguel", "Julian", "Javier", "Alicia", "Angel", "Sergio", "Juan"};
    private String[] edades = {"22", "20", "20", "33", "19", "18", "20"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInformacion = (TextView) findViewById(R.id.tvInfo);
        lvLista = (ListView) findViewById(R.id.lvNombres2DAM);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_nombres, nombres);
        lvLista.setAdapter(adapter);

        //Hacer lo mismo en el spiner
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //Programamos el evennto click de los items de la lista
            //Este metodo te da ya la "i" como position(p), no tienes que hacer ningun ni nada para recorrerlo
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
            //programamos el evento click de los items de la lista
            tvInformacion.setText("La edad de " + lvLista.getItemAtPosition(p) + " es " + edades[p] + " años");
            }
        });
    }
}
