package com.example.seran.prcticarepasopeluquerasergiomoreno;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;

public class SecondActivity extends AppCompatActivity {

    //Componentes que hay en el Activity
    private TextView usuario, colorPelo, diaSemana;
    private RadioGroup grupo;
    private RadioButton moreno, rubio, pelirrojo, castaño, calvo;
    private ListView listaSemana;
    private ArrayAdapter<String> adaptador;
    private TextView telefono, observaciones;
    private ImageButton btnAtras, btnGuardar;

    //Variables que tendrán el valor de las cosas
    private String txtColorPelo = "", txtDiaSemana = "", txtTelefono = "", txtObservaciones = "";

    SharedPreferences preferencias;
    String datoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        preferencias = getSharedPreferences("Registros", Context.MODE_PRIVATE);
        final SharedPreferences.Editor objEditor = preferencias.edit();

        //==============================================//
        //************Inicializamos las cosas***********//
        //==============================================//
        usuario = (TextView) findViewById(R.id.etNombre2);
        colorPelo = (TextView) findViewById(R.id.etColorPelo);
        diaSemana = (TextView) findViewById(R.id.etDiaSemana);

        grupo = (RadioGroup) findViewById(R.id.rgGrupo);
        moreno = (RadioButton) findViewById(R.id.rbMoreno);
        rubio = (RadioButton) findViewById(R.id.rbRubio);
        pelirrojo = (RadioButton) findViewById(R.id.rbPelirrojo);
        castaño = (RadioButton) findViewById(R.id.rbCastanio);
        calvo = (RadioButton) findViewById(R.id.rbCalvo);

        listaSemana = (ListView) findViewById(R.id.lSemana);
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

        telefono = (TextView) findViewById(R.id.areaTelefono);
        observaciones = (TextView) findViewById(R.id.multiComentario);
        btnAtras = (ImageButton) findViewById(R.id.bAtras);
        btnGuardar = (ImageButton) findViewById(R.id.bGuardar);


        //==============================================//
        //************Rellenamos las cosas**************//
        //==============================================//
        //Nombre de arriba
        datoRecibido = getIntent().getStringExtra("Usuario");
        usuario.setText("Usuario: " + datoRecibido);

        //Color de pelo de arriba
        grupo.check(preferencias.getInt("pelo"+datoRecibido, moreno.getId()));

        //Lista
        diaSemana.setText(preferencias.getString("dia"+datoRecibido, "Dia de la semana"));
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listaSemana.setAdapter(adaptador);
        adaptador.addAll(dias);
        listaSemana.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //Este metodo te da ya la "i" como position(p), no tienes que hacer ningun for ni nada para recorrerlo
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                //programamos el evento click de los items de la lista
                txtDiaSemana = listaSemana.getItemAtPosition(p).toString();
                diaSemana.setText("Dia: " + txtDiaSemana);

            }
        });


        //Telefono
        telefono.setText(preferencias.getString("telefono" + datoRecibido, ""));

        //Area
        observaciones.setText(preferencias.getString("observaciones" + datoRecibido, ""));
    }

    public void atrasClick(View view){
        finish();
    }

    public void guardarClick(View view){
        preferencias = getSharedPreferences("Registros", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferencias.edit();

        //******************COLOR DEL PELO*******************
        objEditor.putInt("pelo"+datoRecibido, grupo.getCheckedRadioButtonId());

        //******************DIA SEMANA*************************
        objEditor.putString("dia"+datoRecibido, "Dia: " + txtDiaSemana);


        //**********TELEFONO***************
        telefono = (TextView) findViewById(R.id.areaTelefono);
        txtTelefono = telefono.getText().toString();
        objEditor.putString("telefono" + datoRecibido, txtTelefono);
        objEditor.commit();

        //**********AREA***************
        observaciones = (TextView) findViewById(R.id.multiComentario);
        txtObservaciones = observaciones.getText().toString();
        objEditor.putString("observaciones" + datoRecibido, txtObservaciones);
        objEditor.commit();

        finish();
    }
}
