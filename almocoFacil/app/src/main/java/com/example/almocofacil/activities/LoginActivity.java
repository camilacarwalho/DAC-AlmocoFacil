package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.controler.SessionSharedPreferences;
import com.example.almocofacil.domain.Usuario;
import com.example.almocofacil.services.AcessarRest;
import com.example.almocofacil.services.UsuarioService;

public class LoginActivity extends AppCompatActivity {

    private EditText edMatricula;
    private EditText edSenha;
    private Button btEntrar;

    ProgressDialog progress;

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
        final String matricula = edMatricula.getText().toString();
        final String senha = edSenha.getText().toString();

        progress = new ProgressDialog(this);
        progress.setTitle("enviando...");
        progress.show();

        final Usuario usuario = new Usuario(matricula,senha);
        final LoginActivity esta = this;

        new AcessarRest<Usuario,Usuario>(esta, "usuario/login"){
            @Override
            public void retorno(final Usuario objeto) {
                progress.dismiss();
                if(objeto == null){
                    Toast.makeText(getApplicationContext(),"Falha ao autenticar.", Toast.LENGTH_LONG).show();
                } else {
                    if (objeto.getMatricula() == null){
                        Toast.makeText(getApplicationContext(), "Usuário ou senha inválido", Toast.LENGTH_LONG).show();
                    } else {
                        logadoUsuario(UsuarioService.getUsarioService().logar(objeto));
                    }
                }
            }
        }.run(usuario, Usuario.class);

    }

    public void logadoUsuario(Usuario usuario){
        Toast.makeText(getApplicationContext(), "Usuário " + usuario.getCargo().getNome(), Toast.LENGTH_LONG).show();
        Class<?> nomeClasse = null;
        switch (usuario.getCargo()){
            case ALUNO:
                break;
            case CAEST:
                break;
            case GESTOR:
                nomeClasse = RelatorioRefeicaoActivity.class;
                break;
            case PROFESSOR:
                nomeClasse = AcompanharSolicitacaoActivity.class;
                break;
            case REFEITORIO:
                nomeClasse = ListarAlunos.class;
                break;
            default:
                return;
        }

        if(nomeClasse != null) {
            Intent intent = new Intent(this, nomeClasse);
            SessionSharedPreferences ssp = new SessionSharedPreferences(this);
            ssp.login(usuario);
            startActivity(intent);
            this.finish();
        }
    }
}
