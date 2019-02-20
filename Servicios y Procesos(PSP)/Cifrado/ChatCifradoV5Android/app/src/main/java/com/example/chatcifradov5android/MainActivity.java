package com.example.chatcifradov5android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    InetAddress direccionIP;
    int puerto;
    Socket conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mostrarDialogo();

        try {
            direccionIP = InetAddress.getByName("localhost");
            puerto = 15000;

            conexion = new Socket(direccionIP, puerto);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("tag", "Error: " + e.toString());
            Toast.makeText(null, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarDialogo(){
        DConexion dialogoConexion = DConexion.newInstance();

        dialogoConexion.setCancelable(false);
        dialogoConexion.show(getFragmentManager(),"dialogoConexion");
    }
}
