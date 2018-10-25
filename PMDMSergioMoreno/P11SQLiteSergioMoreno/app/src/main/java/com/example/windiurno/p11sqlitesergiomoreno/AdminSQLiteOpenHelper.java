package com.example.windiurno.p11sqlitesergiomoreno;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //IMPORTANTE!!! ELIMINAR ANOTACIONES "@"
    //@androidx.annotation.Nullable @Nullable
    //@androidx.annotation.Nullable @Nullable
    //@androidx.annotation.Nullable @Nullable
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodos abstractos que deben ser implementados

    //Indicaciones de que se tiene que realizar al crear una base de datos a traves de esta clase
    @Override
    public void onCreate(SQLiteDatabase baseDatos) {
        //TIPOS DE DATOS SQLite
        // int -> numeros
        // text -> texto
        // real -> numero con decimal

        //Crear una tabla en la base de datos con sentencia sql
        baseDatos.execSQL("create table articulos (" +
                "codigo int primary key," +
                "descripcion text, " +
                "precio real)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDatos, int oldVersion, int newVersion) {

    }
}
