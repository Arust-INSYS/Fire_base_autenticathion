package com.arust_app.cuencar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText email, pass;
    Button botonIngreso, botonRegistro;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.EdiTxtEmail);
        pass = findViewById(R.id.ediTxtPassword);
        botonRegistro=findViewById(R.id.Registrar_button);
        botonIngreso =  findViewById(R.id.Ingresarbutton);
       inicio_Cotrol();


    }

    private void inicio_Cotrol(){


        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), Registrar_Activity.class);
                startActivity(i);

            }
        });

        botonIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String clave = pass.getText().toString();
                if(!mail.isEmpty()&&!clave.isEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(mail,clave).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Acceso correcto",Toast.LENGTH_LONG).show();
                                    ir_home();

                                    }else{
                                        Toast.makeText(getApplicationContext(),"Acceso incorrecto",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                    );
                }
            }
        });


    }

    private void ir_home() {
        botonIngreso.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String usuario = email.getText().toString();
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                intent.putExtra("usuarioNombre", usuario);
                startActivity(intent);
            }
        });
    }


}