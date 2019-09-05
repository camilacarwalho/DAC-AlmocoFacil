package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.almocofacil.R;

public class LoginActivity extends AppCompatActivity {

    private EditText matricula;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        matricula = findViewById(R.id.login_etMatricula);
        senha = findViewById(R.id.login_etSenha);
    }

    public void btnEntrarOnClick(View v){
        // TODO: Autenticar usuario

        // TODO: Redirecionar para tela principal
    }

}
