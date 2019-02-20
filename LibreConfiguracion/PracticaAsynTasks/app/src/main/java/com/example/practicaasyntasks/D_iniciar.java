package com.example.practicaasyntasks;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

public class D_iniciar extends DialogFragment implements DialogInterface.OnClickListener {

    protected EditText etNombre;
    protected String nombre;

    OnD_iniciar miListener;

    public static D_iniciar newInstance(){
        return new D_iniciar();
    }

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
            miListener = (OnD_iniciar) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }


    // Creacion del dialogo ///////////////////////////////////////////////////////
    @Override
    public Dialog onCreateDialog(Bundle bundle){
        //Layout builder
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Layout inflater
        LayoutInflater inf = getActivity().getLayoutInflater();

        // inflate
        builder.setView(inf.inflate(R.layout.d_iniciar,null))
                .setTitle(R.string.nueva_partida)
                .setPositiveButton(R.string.empezar, this)
                .setNegativeButton(R.string.retroceder, this)
                .setCancelable(false);
        return builder.create();
    }


    // interfaz ////////////////////////////////////////////////////////////////
    // interfaz para pasar los parametros a la activity
    public interface OnD_iniciar {
        public void onDIniciar(String nombre);
    }


    // Metodos acciones ////////////////////////////////////////////////////////
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        etNombre = (EditText) ((Dialog)dialogInterface).findViewById(R.id.etNombre);
        nombre = etNombre.getText().toString();

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
