package com.example.angel.p11sqliteangelsalascalvo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    TextView etMultib;
    String valorEtMultib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etMultib = (TextView) findViewById(R.id.etMulti);
        valorEtMultib = etMultib.getText().toString();

        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Creamos la sentencia SQL para poder coger los datos
        String consulta = "SELECT id, nombre, precio, tipo, origen FROM articulos";

        //Cremaos el cursor para que me referencie los datos devueltos por la consultaSQL
        Cursor fila = BaseDeDatos.rawQuery(consulta, null);
        //El parametro nos indica si queremos coger una cierta columna, con null las coge todas

        //HAcemos una pequeña cabecera para la tabla
        valorEtMultib += ("ID ");
        valorEtMultib += (" Nombre ");
        valorEtMultib += (" Precio ");
        valorEtMultib += (" Tipo ");
        valorEtMultib += (" Origen " + "\n");
        valorEtMultib += ("============================" + "\n");


        //Mover el cursor al principio de los datos, si se puede mover es que hay datos(true), sino false
        if(fila.moveToFirst()){
            //Esto significa que hay al menos 1 dato en la consulta
            //Ponemos el valor que está campturando el cursor en nuestra interfaz
            valorEtMultib += (fila.getString(0)+ "\t\t\t\t\t");
            //Ahora hay que meter el codigo también
            valorEtMultib += (fila.getString(1)+ "\t\t\t\t\t\t\t");
            //0 aquí no es el codigo si no la descripción porque no estamos cogiendo la tabla si no la consulta
            valorEtMultib += (fila.getString(2)+ "\t\t\t\t\t\t\t");
            //Ahí arriba va 1 y ahora el 2 con el color
            valorEtMultib += (fila.getString(3)+ "\t\t\t\t\t\t\t");
            valorEtMultib += (fila.getString(4)+ "\n");

            while(fila.moveToNext()) {
                valorEtMultib += (fila.getString(0)+ "\t\t\t\t\t");
                valorEtMultib += (fila.getString(1)+ "\t\t\t\t\t\t\t");
                valorEtMultib += (fila.getString(2)+ "\t\t\t\t\t\t\t");
                valorEtMultib += (fila.getString(3)+ "\t\t\t\t\t\t\t");
                valorEtMultib += (fila.getString(4)+ "\n");
            }
            etMultib.setText(valorEtMultib);
        } else {
            //Esto significa que no hay ni 1 dato en la consulta(Que el codigo no existe)
            Toast.makeText(this, "No existen datos", Toast.LENGTH_LONG);
        }

        BaseDeDatos.close();
        administracion.close();
    }

    public void atrasClick(View view){
        finish();
    }
}
