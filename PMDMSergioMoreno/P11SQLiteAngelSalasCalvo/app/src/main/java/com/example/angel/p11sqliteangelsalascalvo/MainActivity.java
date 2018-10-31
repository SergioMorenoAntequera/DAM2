package com.example.angel.p11sqliteangelsalascalvo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigom, etDescripcionm, etPreciom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar componentes
        etCodigom = (EditText) findViewById(R.id.etCodigoProd);
        etDescripcionm = (EditText) findViewById(R.id.etDescripcionProd);
        etPreciom = (EditText) findViewById(R.id.etPrecioProd);
    }

    //No olvidar crear la clase .java para poder administrar y poder crear nuestra base de datos SQLite
    public void registrarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String codigoValor = etCodigom.getText().toString();
        String descripcionValor = etDescripcionm.getText().toString();
        String precioValor = etPreciom.getText().toString();

        //Comprobamos que los campos de texto no se encuentren vacios
        if (codigoValor.isEmpty()||descripcionValor.isEmpty()||precioValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe completar todos los datos del producto", Toast.LENGTH_SHORT).show();
        }else{
            //Si no estan vacios
            //Creamos la fila que vamos a añadir, la instanciamos y añadimos los valores a cada una de sus columnas
            ContentValues fila = new ContentValues();
            fila.put("codigo", codigoValor);
            fila.put("descripcion", descripcionValor);
            fila.put("precio", precioValor);
            //Insertar fila en una tabla
            BaseDeDatos.insert("articulos", null, fila);

            //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
            BaseDeDatos.close();
        }

        //Limpiar los campos de texto
        etCodigom.setText("");
        etDescripcionm.setText("");
        etPreciom.setText("");

        //Indicar al usuario que se ha añadido el producto
        Toast.makeText(this, "Producto insertado!", Toast.LENGTH_SHORT).show();
    }

    //Buscar un registro por codigo
    public void buscarClick(View view) {
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Cogemos la etiqueta del producto ya que vamos a buscar por él
        String codigo = etCodigom.getText().toString();

        //Comprbar que no esté vacío el código del producto
        if(!codigo.isEmpty()){
            //Creamos la sentencia SQL para poder coger los datos juntando la misma con nuestros datos(codigo)
            String consulta = "SELECT descripcion, precio FROM articulos WHERE codigo = " + codigo;

            //Cremaos el cursor para que me referencie los datos devueltos por la consultaSQL
            Cursor fila = BaseDeDatos.rawQuery(consulta, null);
            //El parametro nos indica si queremos coger una cierta columna, con null las coge todas

            //Mover el cursor al principio de los datos, si se puede mover es que hay datos(true), sino false
            if(fila.moveToFirst()){
                //Esto significa que hay al menos 1 dato en la consulta
                //Ponemos el valor que está campturando el cursor en nuestra interfaz
                etDescripcionm.setText(fila.getString(0));
                //0 aquí no es el codigo si no la descripción porque no estamos cogiendo la tabla si no la consulta
                etPreciom.setText(fila.getString(1));
                //Recordamos que la tabla era:  Codigo // Descripcion // Precio
                //Pero nuestra consulta es :    Descripcion // Precio (Select descripcion, precio)

            } else {
                //Esto significa que no hay ni 1 dato en la consulta(Que el codigo no existe)
                Toast.makeText(this, "No existe el artículo", Toast.LENGTH_LONG);
            }

            BaseDeDatos.close();
            administracion.close();

        //Si está vacio le decimos que meta un código del producto
        } else {
            Toast.makeText(null, "Debes introducir un codigo del articulo", Toast.LENGTH_LONG);
        }
    }

    //Modificamos un registro
    public void modificarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String codigoValor = etCodigom.getText().toString();
        String descripcionValor = etDescripcionm.getText().toString();
        String precioValor = etPreciom.getText().toString();

        //Comprobamos que los campos de texto no se encuentren vacios
        if (codigoValor.isEmpty() || descripcionValor.isEmpty() || precioValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe completar todos los datos del producto", Toast.LENGTH_SHORT).show();

        }else{
            //Si no estan vacios
            //Creamos la fila que vamos a añadir, la instanciamos y añadimos los valores a cada una de sus columnas
            ContentValues fila = new ContentValues();
            fila.put("codigo", codigoValor);
            fila.put("descripcion", descripcionValor);
            fila.put("precio", precioValor);
            //Modificar una fila en la tabla(La descripcion o el precio)
            //Parametros necesarios Tabla // La fila nueva // Parte Where de una consulta SQL // null
            int nFilas = BaseDeDatos.update("articulos", fila, "codigo = " + codigoValor, null);
            //Esto nos devuelve el numero de filas modificadas por eso es bueno guardar esto en una variable(nFilas)
            if(nFilas > 0){
                Toast.makeText(this, "Articulo modificado correctamente", Toast.LENGTH_LONG);
                Toast.makeText(this, "Filas modificadas: " + nFilas, Toast.LENGTH_LONG);
            } else {
                if(nFilas <= 0){
                    Toast.makeText(this, "Articulo no encontrado, no modoficado", Toast.LENGTH_LONG);
                }
            }

            //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
            BaseDeDatos.close();
        }

        //Limpiar los campos de texto
        etCodigom.setText("");
        etDescripcionm.setText("");
        etPreciom.setText("");
    }

    //Eliminar un registro de la tabla
    public void eliminarClick(View view){
        //Crear la base de datos con los datos correspondientes
        AdminSQLiteOpenHelper administracion = new AdminSQLiteOpenHelper(this, "administracion",null, 1);
        //Abrir base de datos
        SQLiteDatabase BaseDeDatos = administracion.getWritableDatabase();

        //Almacenamos los datos introducidos por pantalla
        String codigoValor = etCodigom.getText().toString();
        //Aquí solo ponemos el codigo porque es lo unico que necesitamos para BORRAR la fila

        //Comprobamos que los campos de texto no se encuentren vacios
        if (codigoValor.isEmpty()) {
            //Cerramos la base de datos para no dejarla abierta
            BaseDeDatos.close();
            Toast.makeText(this, "Debe introducir el codigo del producto a borrar", Toast.LENGTH_SHORT).show();
        }else{
            //Modificar una fila en la tabla(La descripcion o el precio)
            //Parametros necesarios                     Tabla             // La fila nueva            // null
            int nFilas = BaseDeDatos.delete("articulos", "codigo = " + codigoValor, null);
            //Esto nos devuelve el numero de filas modificadas por eso es bueno guardar esto en una variable(nFilas)
            if(nFilas > 0){

                //Limpiar los campos de texto
                etCodigom.setText("");
                etDescripcionm.setText("");
                etPreciom.setText("");
                Toast.makeText(this, "Articulo eliminado correctamente", Toast.LENGTH_LONG);

            } else Toast.makeText(this, "Articulo no encontrado, no modoficado", Toast.LENGTH_LONG);
        }
        //Cerramos la base de datos para no dejarla abierta, realizando su commit correspondiente
        BaseDeDatos.close();
    }



}
