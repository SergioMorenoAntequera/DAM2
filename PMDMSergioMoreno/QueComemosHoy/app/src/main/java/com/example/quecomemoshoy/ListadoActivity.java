package com.example.quecomemoshoy;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quecomemoshoy.Objetos.FirebaseReferences;
import com.example.quecomemoshoy.Objetos.Receta;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    ListView lvRecetas;
    ArrayList<Receta> recetas;
    ArrayList<String> nombresRecetas;

    FirebaseDatabase database;
    DatabaseReference recetasRef;
    FirebaseAuth fAuth;
    ArrayAdapter arrayAdapter;
    Intent pasarAReceta;

    // Todo lo relacionado con sensores
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        // View
        lvRecetas = findViewById(R.id.lvRecetas);
        //recetas = new ArrayList<>();
        //nombresRecetas = new ArrayList<>();

        // Lista
        database = FirebaseDatabase.getInstance();
        recetasRef = database.getReference(FirebaseReferences.RECETAS_REFERENCE);
        fAuth = FirebaseAuth.getInstance();

        recetasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recetas = new ArrayList<>();
                nombresRecetas = new ArrayList<>();
                for(DataSnapshot d: dataSnapshot.getChildren()){
                    Receta rec = d.getValue(Receta.class);
                    recetas.add(rec);
                    nombresRecetas.add(rec.getNombre());

                    actualizarLista();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        lvRecetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pasarAReceta = new Intent(getApplicationContext(), RecetaActivity.class);

                pasarAReceta.putExtra("receta", parent.getItemAtPosition(position)+"");
                startActivity(pasarAReceta);
            }
        });
    }

    private void actualizarLista() {
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, nombresRecetas);
        lvRecetas.setAdapter(arrayAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Sensores
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensor == null){
            Toast.makeText(getApplicationContext(), "Su dispositivo no dispone de Acelerómetro", Toast.LENGTH_SHORT).show();
        } else {
            sensorEventListener = new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    float x = event.values[0];
                    if(x>15){
                        int elegido = (int) (Math.random() * recetas.size()-1);
                        pasarAReceta = new Intent(getApplicationContext(), RecetaActivity.class);
                        pasarAReceta.putExtra("receta", recetas.get(elegido).getNombre()+"");
                        startActivity(pasarAReceta);
                        sound();
                    }
                }
                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {}
            };
        }
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(sensorEventListener );
    }

    private void sound(){
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dados);
        mediaPlayer.start();
    }

    //----------------------------------------------------------------------------------------------
    // Menu ----------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.registrarReceta) {
            //return true;
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "ingresar!");
            Intent i = new Intent(getApplicationContext(), RegistrarRecetaActivity.class);
            startActivity(i);
            return true;
        }

        if(id == R.id.cerrarSesion){
            Log.i("Usuario desconectado", "USUARIO SE HA DESCONECTADO");
            fAuth.signOut();

            Log.i("ActionBar", "Cerrar sesion!");
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //----------------------------------------------------------------------------------------------
    // Métodos variados ----------------------------------------------------------------------------
    @Override
    public void onBackPressed() {
        fAuth.signOut();
        super.onBackPressed();
    }
}
