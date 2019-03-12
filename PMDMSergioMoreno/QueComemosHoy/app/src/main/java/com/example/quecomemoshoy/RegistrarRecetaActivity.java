package com.example.quecomemoshoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quecomemoshoy.Objetos.FirebaseReferences;
import com.example.quecomemoshoy.Objetos.Receta;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarRecetaActivity extends AppCompatActivity {

    EditText etNombreReceta, etIngrediente, etInstrucciones, etTiempo;
    Button bAniadir, bAniadir2;
    ListView lvIngredientes, lvInstrucciones;
    ArrayAdapter arrayAdapter, arrayAdapter2;

    FirebaseDatabase database;
    DatabaseReference recetasRef;
    FirebaseAuth fAuth;

    Receta receta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarreceta);

        initThings();
        //String s = (String)lvIngredientes.getAdapter().getItem(0);

    }

    //----------------------------------------------------------------------------------------------
    // Botones de la app ---------------------------------------------------------------------------

    public void ingresarIngrediente(View v){
        String ingrediente = etIngrediente.getText().toString();
        receta.getIngredientes().add(ingrediente);

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, receta.getIngredientes());
        lvIngredientes.setAdapter(arrayAdapter);
        etIngrediente.setText("");
    }

    //----------------------------------------------------------------------------------------------

    public void ingresarInstrucciones(View v){
        String instruccion = etInstrucciones.getText().toString();
        receta.getInstrucciones().add(instruccion);

        arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, receta.getInstrucciones());
        lvInstrucciones.setAdapter(arrayAdapter2);
        etInstrucciones.setText("");
    }

    //----------------------------------------------------------------------------------------------

    public void ingresarReceta(View v){
        String nombreReceta = etNombreReceta.getText().toString();
        String tiempo = etTiempo.getText().toString();
        if(nombreReceta.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "La receta necesita un nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(tiempo.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Introduce el tiempo que se tarda en hacer la receta", Toast.LENGTH_SHORT).show();
            return;
        }
        if(receta.getIngredientes().size() == 0){
            Toast.makeText(getApplicationContext(), "Introduce ingredientes", Toast.LENGTH_SHORT).show();
            return;
        }
        if(receta.getInstrucciones().size() == 0){
            Toast.makeText(getApplicationContext(), "Introduce instrucciones", Toast.LENGTH_SHORT).show();
            return;
        }

        recetasRef.child(nombreReceta).setValue(new Receta(nombreReceta, receta.getIngredientes(), receta.getInstrucciones(), tiempo, fAuth.getCurrentUser().getEmail()));
        Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

        reset();
    }

    //----------------------------------------------------------------------------------------------

    private void reset() {
        etNombreReceta.setText("");
        receta.getInstrucciones().clear();
        receta.getIngredientes().clear();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, receta.getIngredientes());
        lvIngredientes.setAdapter(arrayAdapter);
        etIngrediente.setText("");

        arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, receta.getInstrucciones());
        lvInstrucciones.setAdapter(arrayAdapter2);
        etInstrucciones.setText("");

        etTiempo.setText("");
    }

    //----------------------------------------------------------------------------------------------
    // Inicializamos los cosos ---------------------------------------------------------------------
    private void initThings(){
        //Objetos
        receta = new Receta();
        //Este objeto se llena con la info que le llega del activity de login

        //Cosas de la ventana
        etNombreReceta = findViewById(R.id.etNombreReceta);
        etIngrediente = findViewById(R.id.etIngrediente);
        etInstrucciones = findViewById(R.id.etInstruccion);
        etTiempo = findViewById(R.id.etTiempo);
        bAniadir = findViewById(R.id.bAniadirIng);
        bAniadir2 = findViewById(R.id.bAniadirInst);
        lvIngredientes = findViewById(R.id.lvIngredientes);
        lvInstrucciones = findViewById(R.id.lvInstrucciones);

        //Cosas de la base de datos
        database = FirebaseDatabase.getInstance();
        //usuariosRef = database.getReference(FirebaseReferences.USUARIOS_REFERENCE);
        recetasRef = database.getReference(FirebaseReferences.RECETAS_REFERENCE);
        fAuth = FirebaseAuth.getInstance();
    }
}
