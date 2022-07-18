package com.arust_app.cuencar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String usuario = intent.getStringExtra("usuarioNombre");
        TextView miTexto= findViewById(R.id.Usuario_mail);
        miTexto.setText(usuario);
        //Realizado
    }
}