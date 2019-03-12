package com.example.quecomemoshoy;

import android.content.Intent;
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
                Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actualizarLista() {
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, nombresRecetas);
        lvRecetas.setAdapter(arrayAdapter);

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
