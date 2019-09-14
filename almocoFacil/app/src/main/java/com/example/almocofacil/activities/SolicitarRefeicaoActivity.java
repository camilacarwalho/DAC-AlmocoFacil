package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SolicitarRefeicaoActivity extends AppCompatActivity {

    private Requisicao requisicao;
    private EditText edDescricao;
    private EditText edDataInicio;
    private EditText edDataFinal;
    private RadioButton rbAlmoco;
    private RadioButton rbJantar;
    private Button btSolAdicionarEstudante;
    private Button btSolicitar;
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
        lvAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                removerAluno(alunos.get(i));
            }
        });

        btSolAdicionarEstudante = findViewById(R.id.btSolAdicionarEstudante);
        btSolAdicionarEstudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarEstudante();
            }
        });

        btSolicitar = findViewById(R.id.btSolicitar);
        btSolicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitar();
            }
        });

        this.requisicao = (Requisicao) getIntent().getSerializableExtra("requisicao");

        progress = new ProgressDialog(this);
        progress.setTitle("Carregando dados...");

        carregarDados();
    }

    private void solicitar() {
        if (!escreverDados())
            return;
        progress.setTitle("Requisitando...");
        progress.show();
        new AcessoRest<Requisicao>(
                this,
                "requisicao/salvar/",
                Requisicao.class){

            @Override
            public void retorno(Requisicao objeto) {
                if (objeto != null) {
                    requisicao = objeto;
                    incluirAlunos();
                } else {
                    Toast.makeText(getApplicationContext(), "Não foi possível realizar a solicitação.", Toast.LENGTH_LONG).show();
                }
                progress.dismiss();
            }
        }.put(requisicao);
    }

    private void incluirAlunos() {
        progress.setTitle("Incluíndo alunos...");
        progress.show();
        List<String> matriculas = new ArrayList<>();
        for (Aluno aluno: alunos)
            matriculas.add(aluno.getMatricula());
        new AcessoRest<String>(
                this,
                "requisicao/listaAlunos/"+ requisicao.getRequisicaoId(),
                String.class){

            @Override
            public void retorno(String objeto) {
                progress.dismiss();
                if (objeto != null) {
                    Toast.makeText(getApplicationContext(), "Solicitação realizada.", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), AcompanharSolicitacaoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Não foi possível realizar a solicitação.", Toast.LENGTH_LONG).show();
                }
            }
        }.put(matriculas);
    }


    private void removerAluno(final Aluno aluno) {

        new AlertDialog.Builder(this)
            .setTitle("Remover aluno.")
            .setMessage("Deseja remover o aluno " + aluno.getNome() + "?")
            .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alunos.remove(aluno);
                    listarAlunos();
                }
            })
            .setNegativeButton("Cancelar",null)
            .create()
            .show();
    }

    private void adicionarEstudante() {

        new DialogBoxInput(this, "Informe a matrícula","Adicionar"){

            @Override
            public void retorno(String valor) {
                adicionarEstudante(valor);
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

        Calendar cal = Calendar.getInstance();
        cal.setTime(requisicao.getDataInicio());
        cal.add(Calendar.DAY_OF_MONTH,1);
        edDataInicio.setText(sdf.format(cal.getTime()));

        cal.setTime(requisicao.getDataFinal());
        cal.add(Calendar.DAY_OF_MONTH,1);
        edDataFinal.setText(sdf.format(cal.getTime()));

        rbAlmoco.setChecked(requisicao.getRefeicaoId() == 1);
        rbJantar.setChecked(requisicao.getRefeicaoId() == 2);
        if(requisicao.getRequisicaoId() != 0) {
            Type listType = new TypeToken<ArrayList<Aluno>>() {
            }.getType();
            new AcessoRest<List<Aluno>>(
                    this,
                    "requisicao/listaAlunos/" + requisicao.getRequisicaoId(),
                    listType) {
                @Override
                public void retorno(final List<Aluno> objeto) {
                    if (objeto != null) {
                        alunos = new ArrayList<>();
                        for (Aluno novoAluno : objeto)
                            alunos.add(novoAluno);
                    } else
                        alunos = new ArrayList<>();
                    listarAlunos();
                }
            }.get();
        } else {
            progress.dismiss();
        }
    }

    private boolean escreverDados() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        requisicao.setDescricao(edDescricao.getText().toString());
        if((!rbAlmoco.isChecked()) && !(rbJantar.isChecked())){
            Toast.makeText(getApplicationContext(),"Selecione uma refeição",Toast.LENGTH_LONG).show();
            return false;
        }
        if(rbAlmoco.isChecked()){
            requisicao.setRefeicaoNome("Almoço");
            requisicao.setRefeicaoId(1);
        } else {
            requisicao.setRefeicaoNome("Jantar");
            requisicao.setRefeicaoId(2);
        }

        try {
            requisicao.setDataInicio(sdf.parse(edDataInicio.getText().toString()));
            requisicao.setDataFinal(sdf.parse(edDataFinal.getText().toString()));
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Data inválida",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
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
