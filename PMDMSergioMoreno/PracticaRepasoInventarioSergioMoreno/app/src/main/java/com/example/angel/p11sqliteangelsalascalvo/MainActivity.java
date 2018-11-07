package com.example.angel.p11sqliteangelsalascalvo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etIDm, etNombrem, etPreciom, etTipom, etOrigenm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar componentes
        etIDm = (EditText) findViewById(R.id.etIDComida);
        etNombrem = (EditText) findViewById(R.id.etNombreComida);
        etPreciom = (EditText) findViewById(R.id.etPrecioComida);
        etTipom = (EditText) findViewById(R.id.etTipoComida);
        etOrigenm = (EditText) findViewById(R.id.etOrigenComida);

        Toast.makeText(this, "Se Busca/Modifica/Elmina con el campo Nombre", Toast.LENGTH_SHORT).show();
    }

    //No olvidar crear la clase .java para poder administrar y poder crear nuestra base de datos SQLite
    public void registrarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String codigoValor = etIDm.getText().toString();
        String descripcionValor = etNombrem.getText().toString();
        String precioValor = etPreciom.getText().toString();
        String colorValor = etTipom.getText().toString();
        String origenValor = etOrigenm.getText().toString();

        //Comprobamos que los campos de texto no se encuentren vacios
        if (codigoValor.isEmpty()||descripcionValor.isEmpty()||precioValor.isEmpty() || colorValor.isEmpty() || origenValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe completar todos los datos del producto", Toast.LENGTH_SHORT).show();
        }else{
            //Si no estan vacios
            //Creamos la fila que vamos a añadir, la instanciamos y añadimos los valores a cada una de sus columnas
            ContentValues fila = new ContentValues();
            fila.put("id", codigoValor);
            fila.put("nombre", descripcionValor);
            fila.put("precio", precioValor);
            fila.put("tipo", colorValor);
            fila.put("origen", origenValor);
            //Insertar fila en una tabla
            BaseDeDatos.insert("articulos", null, fila);

            //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
            BaseDeDatos.close();
        }

        //Limpiar los campos de texto
        etIDm.setText("");
        etNombrem.setText("");
        etPreciom.setText("");
        etTipom.setText("");
        etOrigenm.setText("");

        //Indicar al usuario que se ha añadido el producto
        Toast.makeText(this, "Comida añadida correctamente!", Toast.LENGTH_SHORT).show();
    }

    //Buscar un registro por codigo
    public void buscarClick(View view) {
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Cogemos el nombre de la comida ya que vamos a buscar por él
        String nombre = etNombrem.getText().toString();

        //Comprbar que no esté vacío el código del producto
        if(!nombre.isEmpty()){
            //Creamos la sentencia SQL para poder coger los datos juntando la misma con nuestros datos(nombre)
            String consulta = "SELECT id, nombre, precio, tipo, origen FROM articulos WHERE nombre = " + nombre;

            //Cremaos el cursor para que me referencie los datos devueltos por la consultaSQL
            Cursor fila = BaseDeDatos.rawQuery(consulta, null);
            //El parametro nos indica si queremos coger una cierta columna, con null las coge todas
            //Mover el cursor al principio de los datos, si se puede mover es que hay datos(true), sino false
            if(fila.moveToFirst()){
                //Esto significa que hay al menos 1 dato en la consulta
                etIDm.setText(fila.getString(0));
                etNombrem.setText(fila.getString(1));
                etPreciom.setText(fila.getString(2));
                etTipom.setText(fila.getString(3));
                etOrigenm.setText(fila.getString(4));
            } else {
                //Esto significa que no hay ni 1 dato en la consulta(Que el nombre no existe)
                Toast.makeText(this, "No existe la comida", Toast.LENGTH_LONG).show();
            }

            BaseDeDatos.close();
            administracion.close();

        //Si está vacio le decimos que meta un código del producto
        } else {
            Toast.makeText(null, "Debes introducir el nombre de la comida", Toast.LENGTH_LONG);
        }
    }

    //Modificamos un registro
    public void modificarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String idValor = etIDm.getText().toString();
        String nombreValor = etNombrem.getText().toString();
        String precioValor = etPreciom.getText().toString();
        String tipoValor = etTipom.getText().toString();
        String origenValor = etOrigenm.getText().toString();

        //Comprobamos que los campos de texto no se encuentren vacios
        if (idValor.isEmpty() || nombreValor.isEmpty() || precioValor.isEmpty() || tipoValor.isEmpty() || origenValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe completar todos los datos de la comida", Toast.LENGTH_SHORT).show();
        }else{
            //Si no estan vacios
            //Creamos la fila que vamos a añadir, la instanciamos y añadimos los valores a cada una de sus columnas
            ContentValues fila = new ContentValues();
            fila.put("id", idValor);
            fila.put("nombre", nombreValor);
            fila.put("precio", precioValor);
            fila.put("tipo", tipoValor);
            fila.put("origen", origenValor);
            //Modificar una fila en la tabla(La descripcion, el precio o el color)
            //Parametros necesarios           Tabla // La fila nueva // Parte Where de una consulta SQL // null
            int nFilas = BaseDeDatos.update("articulos", fila, "nombre = " + nombreValor, null);
            //Esto nos devuelve el numero de filas modificadas por eso es bueno guardar esto en una variable(nFilas)
            if(nFilas > 0){
                Toast.makeText(this, "Comida modificada correctamente", Toast.LENGTH_LONG).show();
            } else {
                if(nFilas <= 0){
                    Toast.makeText(this, "Comida no encontrado, no modoficado", Toast.LENGTH_LONG).show();
                }
            }

            //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
            BaseDeDatos.close();
        }

        //Limpiar los campos de texto
        etIDm.setText("");
        etNombrem.setText("");
        etPreciom.setText("");
        etTipom.setText("");
        etOrigenm.setText("");
    }

    //Eliminar un registro de la tabla
    public void eliminarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String nombreValor = etNombrem.getText().toString();
        //Aquí solo ponemos el nombre porque es lo unico que necesitamos para BORRAR la fila

        //Comprobamos que los campos de texto no se encuentren vacios
        if (nombreValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe introducir el nombre de la comida a borrar", Toast.LENGTH_SHORT).show();
        }else{
            //Modificar una fila en la tabla(La descripcion o el precio)
            //Parametros necesarios                     Tabla       // La condicion del codigo          // null
            int nFilas = 0;
            nFilas = BaseDeDatos.delete("articulos", "nombre = " + nombreValor, null);
            //Esto nos devuelve el numero de filas modificadas por eso es bueno guardar esto en una variable(nFilas)
            if(nFilas > 0){
                //Limpiar los campos de texto
                etIDm.setText("");
                etNombrem.setText("");
                etPreciom.setText("");
                etTipom.setText("");
                etOrigenm.setText("");
                Toast.makeText(this, "Comida borradas correctamente", Toast.LENGTH_LONG);

            } else Toast.makeText(this, "Comida no encontrado, no borradas", Toast.LENGTH_LONG);
        }
        //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
        BaseDeDatos.close();
    }

    public void visualizarClick(View view){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
