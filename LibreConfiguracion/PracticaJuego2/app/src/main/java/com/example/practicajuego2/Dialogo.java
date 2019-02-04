package com.example.practicajuego2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
/*
public class Dialogo extends DialogFragment implements DialogInterface.OnClickListener {

    //Esto sustituye al constructor(Lo recomendable es hacerlo asi)
    public static Dialogo newInstance(){
        return new Dialogo();
    }

    //----------------------------------------------------------------------------------------------

    //Cuando el dialogo se junta con un contexto
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Activity activity = null;
        if(context instanceof Activity){
            activity = (Activity) context;
        }

        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            miListener = (OnDialogNombreNivel) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // layout inflater
        LayoutInflater inf = getActivity().getLayoutInflater();
        // inflate
        builder.setView(inf.inflate(R.layout.dialogo,null))
                .setTitle(R.string.dialog_titulo)
                .setPositiveButton(R.string.dialog_aceptar,this)
                .setNegativeButton(R.string.dialog_rechazar,this)
                .setCancelable(false);
        return builder.create();
    }

    //----------------------------------------------------------------------------------------------

    //Metodo heredados de la interfaz OnClikkListener
    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
*/