package com.example.quecomemoshoy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quecomemoshoy.Objetos.FirebaseReferences;
import com.example.quecomemoshoy.Objetos.Usuario;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText etEmail, etPass;
    Button bRegistrase, bLogin;

    FirebaseDatabase database;
    DatabaseReference usuariosRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initThings();

    }

    private void initThings() {
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        bRegistrase = findViewById(R.id.bRegistrarse);
        bLogin = findViewById(R.id.bLogin);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        usuariosRef = database.getReference(FirebaseReferences.USUARIOS_REFERENCE);
    }

    //----------------------------------------------------------------------------------------------
    // Comprbamos si el usuario ha accedido anteriormente para un login automatico -----------------
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    //----------------------------------------------------------------------------------------------
    // Metodos variados ----------------------------------------------------------------------------
    public void crearUsuario(View v) {
        final String email = etEmail.getText().toString();
        final String pass = etPass.getText().toString();

        if (pass.length() < 6) {
            Toast.makeText(getApplicationContext(), "La contraseña debe tener minimo 6 caracteres", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAGGGGG", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                Toast.makeText(getApplicationContext(), "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                                String[] aux = email.split("@");
                                usuariosRef.child(user.getUid()).setValue(new Usuario(email, pass));

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAGGGGG", "createUserWithEmail:failure", task.getException());
                                if(task.getException().toString().contains("The email address is badly formatted.")){
                                    Toast.makeText(getApplicationContext(), "Error al introducir el correo.", Toast.LENGTH_SHORT).show();
                                }
                                if(task.getException().toString().contains("The email address is already in use by another account.")){
                                    Toast.makeText(getApplicationContext(), "Correo ya registrado.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }
}
