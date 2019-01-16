package com.example.profesor.juegov1;
import android.content.Context;

public class Celdas extends android.support.v7.widget.AppCompatButton{

    int idBoton, numeroElementos, contenidoCelda, fondo, fila, columna;
    public Celdas (Context context, int idButton, int ne, int cc, int fondo, int fila, int columna){

        super(context);
        this.idBoton = idBoton;
        this.numeroElementos = ne;
        this.contenidoCelda = cc;
        this.fondo = fondo;
        this.fila = fila;
        this.columna = columna;

        this.setBackgroundResource(fondo);

    }

    public int getNuevoFondo(){
        contenidoCelda++;
        if(contenidoCelda == numeroElementos) contenidoCelda = 1;
        return contenidoCelda;
    }


}