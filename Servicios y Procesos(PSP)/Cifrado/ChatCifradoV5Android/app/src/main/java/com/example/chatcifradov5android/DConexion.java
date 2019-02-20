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

public class DConexion extends DialogFragment implements DialogInterface.OnClickListener {

    private EditText etIp, etPuerto;
    private String puertoCad, ipCad;

    private OnDConexion miListener;

    //----------------------------------------------------------------------------------------------

    public static DConexion newInstance() {
        return new DConexion();
    }

    //----------------------------------------------------------------------------------------------

    //Esto sucede cuando le añadimos un dialogo al Activity ////////////////////////////////////////
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
            miListener = (OnDConexion) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }

    //----------------------------------------------------------------------------------------------

    // Esto sucede cuando se llama al Dialogo, para crearlo ////////////////////////////////////////
    @Override
    public Dialog onCreateDialog(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Layout inflater
        LayoutInflater inf = getActivity().getLayoutInflater();

        //Inflate
        builder.setView(inf.inflate(R.layout.d_conexion,null))
                .setTitle("Configuracion de la conexion")
                .setPositiveButton("Aceptar", this)
                .setNegativeButton("Retroceder", this)
                .setCancelable(false);
        return builder.create();
    }

    //----------------------------------------------------------------------------------------------

    // interfaz para pasar los parametros a la activity
    public interface OnDConexion {
        public void OnConectar(String ip, String puerto);
    }

    //-----------------------------------------

    //Acciones
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

        etIp = ((Dialog)dialogInterface).findViewById(R.id.etIP);
        etPuerto = ((Dialog)dialogInterface).findViewById(R.id.etPuerto);

         ipCad = etIp.getText().toString();
         puertoCad = etPuerto.getText().toString();

        switch(i){
            case DialogInterface.BUTTON_POSITIVE:
                miListener.OnConectar(ipCad, puertoCad);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                getActivity().finish();
                break;
        }
    }

    public void setMiListener(OnDConexion miListener) {
        this.miListener = miListener;
    }
}
