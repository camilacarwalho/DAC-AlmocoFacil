package com.example.almocofacil.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Requisicao;

import java.text.SimpleDateFormat;

public class SolicitarRefeicaoActivity extends AppCompatActivity {

    private Requisicao requisicao;
    private EditText edDescricao;
    private EditText edDataInicio;
    private EditText edDataFinal;
    private RadioButton rbAlmoco;
    private RadioButton rbJantar;
    private Button btSolAdicionarEstudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_refeicao);

        edDescricao = findViewById(R.id.etDescricao);
        edDataInicio = findViewById(R.id.edSolDataInicio);
        edDataFinal = findViewById(R.id.edSolDataFinal);
        rbAlmoco = findViewById(R.id.rbAlmoco);
        rbJantar = findViewById(R.id.rbJantar);
        btSolAdicionarEstudante = findViewById(R.id.btSolAdicionarEstudante);

        btSolAdicionarEstudante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionarEstudante();
            }
        });

        this.requisicao = (Requisicao) getIntent().getSerializableExtra("requisicao");
        carregarDados();
    }

    private void adicionarEstudante() {

        new DialogBoxInput("Informe a matrícula","Buscar"){

            @Override
            public void retorno(String valor) {
                Toast.makeText(getApplicationContext(),valor,Toast.LENGTH_LONG);
            }
        }.getShowsDialog();



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
