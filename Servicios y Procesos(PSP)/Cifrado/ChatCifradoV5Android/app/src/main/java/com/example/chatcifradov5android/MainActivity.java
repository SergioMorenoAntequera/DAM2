
package com.example.chatcifradov5android;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatcifradov5android.cifrado.Cifrar;
import com.example.chatcifradov5android.cifrado.DesCifrar;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends BaseActivity implements DConexion.OnDConexion {

    InetAddress direccionIP;
    int puerto;
    Socket conexion;

    TextView tvChat;
    EditText etMensaje;
    Button bEnviar;

    BufferedReader flujoEntrada;
    PrintWriter flujoSalida;
    String mensajeLlegadoCifrado;
    Cifrar cifrar;
    DesCifrar descifrar;

    private ControlTask controlTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setModoInmersivo();

        setViews();

        mostrarDialogo();
    }

    private void setViews() {
        tvChat = findViewById(R.id.tvChat);
        etMensaje = findViewById(R.id.etMensaje);
        bEnviar = findViewById(R.id.bEnviar);

    }

    public void mostrarDialogo(){
        DConexion dialogoConexion = DConexion.newInstance();

        dialogoConexion.setMiListener(this);
        dialogoConexion.setCancelable(false);
        dialogoConexion.show(getFragmentManager(),"dialogoConexion");
    }

    public void hablarClick(View v){
        try {
            flujoSalida = new PrintWriter(conexion.getOutputStream(), true);
            String mensajeAEnviar = etMensaje.getText().toString();


            cifrar = new Cifrar(mensajeAEnviar);
            flujoSalida.println(cifrar.getFraseCifrada());

            etMensaje.setText("");
            tvChat.append("[Yo]> " + mensajeAEnviar);
        } catch (IOException ex) {}
    }

    @Override
    public void OnConectar(String ip, String puerto) {
        try {
            this.direccionIP = InetAddress.getByName(ip);
            this.puerto = Integer.parseInt(puerto);

            this.conexion = new Socket(this.direccionIP, this.puerto);

            this.flujoEntrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            this.flujoSalida = new PrintWriter(conexion.getOutputStream(), true);

            controlTask = new ControlTask();
            controlTask.execute();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("tag", "Error: " + e.toString());
            Toast.makeText(null, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    // AsynTask ////////////////////////////////////////////////////////////////////////////////////
    //Esto hace las de hiloEscuchar
    public class ControlTask extends AsyncTask<Void, String, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            //Aqui escuchamos por mensajes y luego con el publish los hacemos visibles en la caja
            while(true){
                try {
                    //El error salta en la siguiente linea
                    mensajeLlegadoCifrado = flujoEntrada.readLine();

                    descifrar = new DesCifrar(mensajeLlegadoCifrado);

                    controlTask.publishProgress(descifrar.getFrase());

                } catch (IOException ex) {
                    System.err.println("Error en Leer Cliente: " + ex.getMessage());
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            tvChat.append(values[0]+"\n");
        }

        //----------------------------------------------------------------------------------------------

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            try {
                flujoEntrada.close();
                flujoSalida.close();
                conexion.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();

            try {
                flujoEntrada.close();
                flujoSalida.close();
                conexion.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


