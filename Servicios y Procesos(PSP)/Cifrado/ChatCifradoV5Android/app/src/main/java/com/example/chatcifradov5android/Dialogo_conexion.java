package com.example.chatcifradov5android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Dialogo_conexion extends DialogFragment implements DialogInterface.OnClickListener {

    private EditText etIp, etPuerto;
    private String puertoCad, ipCad;

    InetAddress direccionIP;
    int puerto;

    OnDialogo_conexion miListener;

    //----------------------------------------------------------------------------------------------

    public static Dialogo_conexion newInstance(){
        return new Dialogo_conexion();
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = null;
        if(context instanceof Activity){
            activity = (Activity)context;
        }

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            miListener = (OnDialogo_conexion) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }

    // Creacion del dialogo ///////////////////////////////////////////////////////
    @Override
    public Dialog onCreateDialog(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Layout inflater
        LayoutInflater inf = getActivity().getLayoutInflater();

        //Inflate
        builder.setView(inf.inflate(R.layout.dialogo_conexion,null))
                .setTitle("Configuracion de la conexion")
                .setPositiveButton("Aceptar", this)
                .setNegativeButton("Retroceder", this)
                .setCancelable(false);
        return builder.create();
    }

    //----------------------------------------------------------------------------------------------

    // interfaz para pasar los parametros a la activity
    public interface OnDialogo_conexion {
        public void OnDialogo_conexion(String ip, String puerto);
    }


    //-----------------------------------------

    //Acciones
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        etIp = ((Dialog)dialogInterface).findViewById(R.id.etIP);
        etPuerto = ((Dialog)dialogInterface).findViewById(R.id.etPuerto);

         ipCad = etIp.getText().toString();
         puertoCad = etPuerto.getText().toString();

        try {
            direccionIP = InetAddress.getByName(ipCad);
            puerto = Integer.parseInt(puertoCad);

        } catch (UnknownHostException e) {
            Toast.makeText(null, "Error al introducir los datos", Toast.LENGTH_SHORT).show();
        }


        switch(i){
            case DialogInterface.BUTTON_POSITIVE:
                miListener.onDIniciar(nombre);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                getActivity().finish();
                break;
        }
    }
}
