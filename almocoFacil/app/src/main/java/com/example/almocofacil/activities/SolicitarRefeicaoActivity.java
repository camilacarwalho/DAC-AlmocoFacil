package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Aluno;
import com.example.almocofacil.domain.Requisicao;
import com.example.almocofacil.domain.RequisicaoMatricula;
import com.example.almocofacil.services.AcessoRest;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolicitarRefeicaoActivity extends AppCompatActivity {

    private Requisicao requisicao;
    private EditText edDescricao;
    private EditText edDataInicio;
    private EditText edDataFinal;
    private RadioButton rbAlmoco;
    private RadioButton rbJantar;
    private Button btSolAdicionarEstudante;
    private ListView lvAlunos;
    private ProgressDialog progress;

    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_refeicao);

        alunos = new ArrayList<>();

        edDescricao = findViewById(R.id.etDescricao);
        edDataInicio = findViewById(R.id.edSolDataInicio);
        edDataFinal = findViewById(R.id.edSolDataFinal);
        rbAlmoco = findViewById(R.id.rbAlmoco);
        rbJantar = findViewById(R.id.rbJantar);

        lvAlunos = findViewById(R.id.lvSolAlunos);

        btSolAdicionarEstudante = findViewById(R.id.btSolAdicionarEstudante);

        btSolAdicionarEstudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarEstudante();
            }
        });

        this.requisicao = (Requisicao) getIntent().getSerializableExtra("requisicao");

        progress = new ProgressDialog(this);
        progress.setTitle("Carregando dados...");

        carregarDados();
    }

    private void adicionarEstudante() {

        new DialogBoxInput(this, "Informe a matrícula","Buscar"){

            @Override
            public void retorno(String valor) {
                adicionarEstudante(valor);
                //carregarAlunos();
                this.cancel();
            }

            @Override
            public void cancelar() {
                this.cancel();
            }
        }.show();
    }

    private void carregarDados(){
        progress.show();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        edDescricao.setText(requisicao.getDescricao());
        edDataInicio.setText(sdf.format(requisicao.getDataInicio()));
        edDataFinal.setText(sdf.format(requisicao.getDataFinal()));
        rbAlmoco.setChecked(requisicao.getRefeicaoId() == 1);
        rbJantar.setChecked(requisicao.getRefeicaoId() == 2);
        Type listType = new TypeToken<ArrayList<Aluno>>(){}.getType();
        new AcessoRest<List<Aluno>>(
                this,
                "requisicao/listaAlunos/"+ requisicao.getRequisicaoId(),
                listType){
            @Override
            public void retorno(final List<Aluno> objeto) {
                if (objeto != null) {
                    alunos = new ArrayList<>();
                    for (Aluno novoAluno : objeto)
                        alunos.add(novoAluno);
                }else
                    alunos = new ArrayList<>();
                listarAlunos();
            }
        }.get();
    }

    private void listarAlunos() {
        ListAlunoAdapter adapter = new ListAlunoAdapter(alunos,this);
        lvAlunos.setAdapter(adapter);
        progress.dismiss();
    }

    private void adicionarEstudante(String matricula){
        progress.show();
        String url = "aluno/"+matricula;
        new AcessoRest<Aluno>(this,url,Aluno.class){
            @Override
            public void retorno(Aluno objeto) {
                if (objeto != null) {
                    Toast.makeText(getApplicationContext(),"Aluno " + objeto.getNome() +" adicionado(a) com sucesso.",Toast.LENGTH_LONG).show();
                    alunos.add(objeto);
                    listarAlunos();
                }else {
                    Toast.makeText(getApplicationContext(),"Não foi possível adicionar aluno.",Toast.LENGTH_LONG).show();
                    progress.dismiss();
                }
            }
        }.get();

    }
}
