package com.example.quecomemoshoy;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quecomemoshoy.Objetos.FirebaseReferences;
import com.example.quecomemoshoy.Objetos.Receta;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RecetaActivity extends AppCompatActivity {

    String nombreReceta;
    TextView tvNombreReceta, tvTiempo, tvPropietario;
    Button bEliminar;
    ListView lvIngredientes, lvInstrucciones;


    FirebaseDatabase database;
    DatabaseReference recetasRef, recetaRef;
    FirebaseAuth fAuth;
    ArrayAdapter arrayAdapterIng;

    Receta recetaElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        recetaElegida = new Receta();

        // Views
        tvNombreReceta = findViewById(R.id.tvNombreReceta);
        nombreReceta = getIntent().getExtras().getString("receta");
        tvNombreReceta.setText(nombreReceta);
        tvTiempo = findViewById(R.id.tvTiempo);
        tvPropietario = findViewById(R.id.tvPropietario);
        bEliminar = findViewById(R.id.bEliminar);
        bEliminar.setVisibility(View.GONE);
        lvIngredientes = findViewById(R.id.lvIngredientes);
        lvInstrucciones = findViewById(R.id.lvInstrucciones);

        // Base de datos
        database = FirebaseDatabase.getInstance();
        recetasRef = database.getReference(FirebaseReferences.RECETAS_REFERENCE);
        //Aqui obtenermos la receta en particular que queremos.
        recetaRef = recetasRef.child(nombreReceta);


        recetasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d: dataSnapshot.getChildren()){
                    Receta rec = d.getValue(Receta.class);
                    if(rec.getNombre().equalsIgnoreCase(nombreReceta)){
                        recetaElegida = rec;
                        // Aqui le damos valor a los view
                        tvNombreReceta.setText(recetaElegida.getNombre());
                        tvTiempo.setText(recetaElegida.getTiempo());
                        tvPropietario.setText(recetaElegida.getPropietario());
                        formarListV();

                        fAuth = FirebaseAuth.getInstance();
                        if(recetaElegida.getPropietario().equalsIgnoreCase(fAuth.getCurrentUser().getEmail())){
                            bEliminar.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }
    public void eliminarReceta(View v){
        finish();
        recetaRef.removeValue();
        Toast.makeText(getApplicationContext(), "Receta eliminada satisfactoriamente", Toast.LENGTH_SHORT).show();
    }

    public void abrirInternet(View v){
        Uri uri = Uri.parse("https://www.google.es/search?client=opera&q=receta+de+"+nombreReceta+"&sourceid=opera&ie=UTF-8&oe=UTF-8");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void formarListV() {
        if(recetaElegida == null){
            return;
        }
        final ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, recetaElegida.getInstrucciones());
        final ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, recetaElegida.getIngredientes());
        lvInstrucciones.setAdapter(arrayAdapter1);
        lvIngredientes.setAdapter(arrayAdapter2);
    }
}
