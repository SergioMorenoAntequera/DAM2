package com.example.p32firebasepruebasergiomoreno;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText etDni, etNombre, etAp1, etAp2, etEdad;

    FirebaseDatabase basededatos;
    DatabaseReference agenda;
    DatabaseReference edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDni = findViewById(R.id.etDANI);
        etNombre = findViewById(R.id.etNombre);
        etAp1 = findViewById(R.id.etAp1);
        etAp2 = findViewById(R.id.etAp2);
        etEdad = findViewById(R.id.etEdad);

        basededatos = FirebaseDatabase.getInstance();
        agenda = basededatos.getReference("TablaAgenda");
    }

    //----------------------------------------------------------------------------------------------

    @Override
    public void onStart(){
        super.onStart();

        edad = agenda.child("54").child("Edad");

        edad.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String valorEdad = dataSnapshot.getValue(String.class);
                etEdad.setText(valorEdad);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });


    }

    //----------------------------------------------------------------------------------------------

    public void registrar(View v){


        DatabaseReference dni;
        dni = agenda.child(etDni.getText().toString());
        dni.child("Nombre").setValue(etNombre.getText().toString());
        dni.child("Apellido1").setValue(etAp1.getText().toString());
        dni.child("Apellido2").setValue(etAp2.getText().toString());
        dni.child("Edad").setValue(etEdad.getText().toString());
    }

    public void modificar(View v){

        //Modificamos la tabla de la base de dattos

    }

}
