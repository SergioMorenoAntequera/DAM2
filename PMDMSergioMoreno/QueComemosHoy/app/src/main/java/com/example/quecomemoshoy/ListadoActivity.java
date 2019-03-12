package com.example.quecomemoshoy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.quecomemoshoy.Objetos.FirebaseReferences;
import com.example.quecomemoshoy.Objetos.Receta;
import com.example.quecomemoshoy.Objetos.Usuario;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    ListView lvRecetas;

    ArrayList recetas;

    Usuario usuario;
    String email;
    String pass;

    FirebaseDatabase database;
    DatabaseReference recetasRef;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        // View
        lvRecetas = findViewById(R.id.lvRecetas);

        //Usuario del que es la cuenta en la que estamos
        email = getIntent().getExtras().getString("email");
        pass = getIntent().getExtras().getString("pass");
        usuario = new Usuario(email, pass);

        database = FirebaseDatabase.getInstance();
        recetasRef = database.getReference(FirebaseReferences.RECETAS_REFERENCE);

        recetasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Receta receta = dataSnapshot.getValue(Receta.class);
                Log.d("TAAAAG", receta.getNombre());
                Log.d("TAAAAG", receta.getTiempo());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
