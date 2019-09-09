package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.serializer.AlunoSerializer;
import com.example.almocofacil.threads.AlunoRequest;

public class LoginActivity extends AppCompatActivity {

    private EditText edMatricula;
    private EditText edSenha;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edMatricula = findViewById(R.id.login_etMatricula);
        edSenha = findViewById(R.id.login_etSenha);

        btEntrar = findViewById(R.id.login_btnEntrar);
        btEntrar.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {btnEntrarOnClick(view);}});
    }

    public void btnEntrarOnClick(View v){
        String matricula = edMatricula.getText().toString();
        String senha = edSenha.getText().toString();
        Toast.makeText(this,"Clicou!",Toast.LENGTH_LONG).show();
        if(matricula.equals("111")){
            Intent intent = new Intent(this, RelatorioRefeicaoActivity.class);
            startActivity(intent);
        }

        //  EXEMPLO DE USO DA API REST
        AlunoSerializer alunoSerializer = new AlunoSerializer("123456", "Alann Rodrigues");
        Thread thread = new Thread(new AlunoRequest(alunoSerializer));
        thread.start();

        // TODO: Autenticar usuario

        // TODO: Redirecionar para tela principal
    }

}
