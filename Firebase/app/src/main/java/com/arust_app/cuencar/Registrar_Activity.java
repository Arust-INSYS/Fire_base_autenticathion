package com.arust_app.cuencar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registrar_Activity extends AppCompatActivity {
    EditText email, pass;
    Button botonRegistro;
    AwesomeValidation awesomeValidation;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        firebaseAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.EmailEditView);
        pass = findViewById(R.id.EditPassword);
        botonRegistro = findViewById(R.id.Resgistro_button);
        inicio_Cotrol();


    }

    private void inicio_Cotrol(){


        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String clave = pass.getText().toString();
                if(!mail.isEmpty()&&!clave.isEmpty()){
                    firebaseAuth.createUserWithEmailAndPassword(mail,clave).addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Registro correcto",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(),"Registro incorrecto",Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                    );
                }




            }
        });

    }

}