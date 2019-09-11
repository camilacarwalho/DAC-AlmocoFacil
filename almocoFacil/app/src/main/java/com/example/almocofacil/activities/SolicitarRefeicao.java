package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Requisicao;

import java.text.SimpleDateFormat;

public class SolicitarRefeicao extends AppCompatActivity {

    private Requisicao requisicao;
    private EditText edDescricao;
    private EditText edDataInicio;
    private EditText edDataFinal;
    private RadioButton rbAlmoco;
    private RadioButton rbJantar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_refeicao);

        edDescricao = findViewById(R.id.etDescricao);
        edDataInicio = findViewById(R.id.edSolDataInicio);
        edDataFinal = findViewById(R.id.edSolDataFinal);
        rbAlmoco = findViewById(R.id.rbAlmoco);
        rbJantar = findViewById(R.id.rbJantar);

        this.requisicao = (Requisicao) getIntent().getSerializableExtra("requisicao");
        carregarDados();
    }

    private void carregarDados(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        edDescricao.setText(requisicao.getDescricao());
        edDataInicio.setText(sdf.format(requisicao.getDataInicio()));
        edDataFinal.setText(sdf.format(requisicao.getDataFinal()));
        rbAlmoco.setChecked(requisicao.getRefeicaoId() == 1);
        rbJantar.setChecked(requisicao.getRefeicaoId() == 2);
    }
}
