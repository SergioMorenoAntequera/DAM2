package com.example.profesor.juegov1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final static String FILAS="nFilas";
    public final static String COLUMNAS="nColumnas";
    public final static String ELEMENTOS="nElementos";
    public final static String VIBRAR="vibrar";
    public final static String SONAR="sonar";
    public final static String NUMEROS="numeros";
    public final static String TOTAL_CLIKS="totalClicks";
    public final static int REQUEST_CODE=-1;

    // ------------------------
    private SeekBar sbFilas, sbColumnas, sbElementos;
    private CheckBox ckSonar, ckVibrar;
    private RadioButton rbNumeros, rbColores;
    private TextView tvFilas, tvColumas, tvElementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-------------------
        sbFilas=(SeekBar)findViewById(R.id.sbFilas);
        sbColumnas=(SeekBar)findViewById(R.id.sbColumnas);
        sbElementos=(SeekBar)findViewById(R.id.sbNumEle);

        ckSonar=(CheckBox)findViewById(R.id.ckSonar);
        ckVibrar=(CheckBox)findViewById(R.id.ckVibrar);

        rbNumeros=(RadioButton)findViewById(R.id.rbNumeros);
        rbColores=(RadioButton)findViewById(R.id.rbColores);

        tvColumas=(TextView)findViewById(R.id.txtColumnas);
        tvFilas=(TextView)findViewById(R.id.txtFilas);
        tvElementos=(TextView)findViewById(R.id.txtElementos);

        // Añadimos listener
        sbFilas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                actualizaFilas(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbColumnas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                actualizaColumnas(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sbElementos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                actualizaElementos(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    //------------------------------------------------------------------------------------
    public void jugar(View v){
        Intent i=new Intent(this, JuegoActivity.class);
        Bundle datos=new Bundle();
        int filas, columnas, elementos, vibrar, sonar, numeros;
        filas=sbFilas.getProgress()+3;
        columnas=sbColumnas.getProgress()+3;
        elementos=sbElementos.getProgress()+2;
        sonar=ckSonar.isChecked() ? 1 : 0;
        vibrar=ckVibrar.isChecked() ? 1 : 0;
        numeros=rbNumeros.isChecked() ? 1 : 0;
        /*
        if(rbNumeros.isChecked()) numeros=1;
        else numeros=0;
         */

        datos.putInt(FILAS, filas);
        datos.putInt(COLUMNAS, columnas);
        datos.putInt(ELEMENTOS, elementos);
        datos.putInt(VIBRAR, vibrar);
        datos.putInt(SONAR, sonar);
        datos.putInt(NUMEROS,numeros);

        i.putExtras(datos);

        startActivityForResult(i, REQUEST_CODE);
    }
    //-------------------------------------------------------------------------------------
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent datos){
        if(reqCode==REQUEST_CODE && resCode==RESULT_OK){
            int totalClicks = datos.getIntExtra(TOTAL_CLIKS, 0);
            Toast.makeText(this, "Finalizaste el juego con un total de: " + totalClicks + "pulsaciones",
                    Toast.LENGTH_SHORT).show();
        }
        if(reqCode==REQUEST_CODE &resCode==RESULT_CANCELED){
            Toast.makeText(this, "El juego ha sido cancelado", Toast.LENGTH_SHORT).show();

        }
        super.onActivityResult(reqCode, resCode, datos);
    }
    //-------------------------------------------------------------------------------------
    public void actualizaFilas(int p){
        tvFilas.setText(""+(p+3));
    }
    public void actualizaColumnas(int p){
        tvColumas.setText(""+(p+3));
    }
    public void actualizaElementos(int p){
        tvElementos.setText(""+(p+2));
    }
    //-------------------------------------------------------------------------------------
    //--------------------------MENU -------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_ayuda:
                mostrarAyuda();
                break;
            case R.id.item_about:
                mostrarAbout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //------------------------------
    public void mostrarAyuda(){
        Intent i=new Intent(this, ayudaActivity.class);
        startActivity(i);
    }
    public void mostrarAbout(){
        Intent i=new Intent(this, aboutActivity.class);
        startActivity(i);
    }
    //--------------------------------------------------------------------------------
}

