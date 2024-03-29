package com.example.almocofacil.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Aluno;
import com.example.almocofacil.domain.Requisicao;
import com.example.almocofacil.services.AcessoRest;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SolicitarRefeicaoFechadaActivity extends AppCompatActivity {

    private Requisicao requisicao;
    private TextView tvStatus;
    private TextView tvDescricao;
    private TextView tvDataInicio;
    private TextView tvDataFinal;
    private TextView tvRefeicao;
    private ListView lvAlunos;
    private ProgressDialog progress;

    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_refeicao_fechada);

        alunos = new ArrayList<>();
        tvStatus = findViewById(R.id.tvStatus);
        tvDescricao = findViewById(R.id.tvDescricao);
        tvDataInicio = findViewById(R.id.tvDataInicio);
        tvDataFinal = findViewById(R.id.tvDataFinal);
        tvRefeicao = findViewById(R.id.tvRefeicao);

        lvAlunos = findViewById(R.id.lvSolAlunos);

        this.requisicao = (Requisicao) getIntent().getSerializableExtra("requisicao");

        progress = new ProgressDialog(this);
        progress.setTitle("Carregando dados...");

        carregarDados();
    }



    private void carregarDados(){
        progress.show();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tvStatus.setText(requisicao.getStatus().getNome());
        tvDescricao.setText(requisicao.getDescricao());

        Calendar cal = Calendar.getInstance();
        cal.setTime(requisicao.getDataInicio());
//        cal.add(Calendar.DAY_OF_MONTH,1);
        tvDataInicio.setText(sdf.format(cal.getTime()));

        cal.setTime(requisicao.getDataFinal());
//        cal.add(Calendar.DAY_OF_MONTH,1);
        tvDataFinal.setText(sdf.format(cal.getTime()));

        tvRefeicao.setText(requisicao.getRefeicaoNome());
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


    private void listarAlunos() {
        ListAlunoAdapter adapter = new ListAlunoAdapter(alunos,this);
        lvAlunos.setAdapter(adapter);
        progress.dismiss();
    }


}
