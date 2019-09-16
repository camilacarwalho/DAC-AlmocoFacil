package com.example.almocofacil.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Refeicao;
import com.example.almocofacil.domain.serializer.AutorizacaoRRJersey;
import com.example.almocofacil.domain.serializer.IntervaloDatas;
import com.example.almocofacil.domain.serializer.RelatorioRefeicoes;
import com.example.almocofacil.services.AcessoRest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RelatorioRefeicaoActivity extends AppCompatActivity {

    Refeicao[] refeicoes;
    private Button btFiltrar;
    private EditText dataInicial;
    private EditText dataFinal;
    ProgressDialog progress;
    private ListView lvRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_refeicao);
        init();

        lvRelatorio = findViewById(R.id.listViewRelatorio);

        dataInicial = findViewById(R.id.editText2);
        dataFinal = findViewById(R.id.editText3);

        btFiltrar = findViewById(R.id.button);
        btFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btFiltrarOnClick(view);
            }
        });

    }

    public void btFiltrarOnClick(View v) {

        final String dInicio = dataInicial.getText().toString();
        final String dFinal = dataFinal.getText().toString();

        progress = new ProgressDialog(this);
        progress.setTitle("Filtrando...");
        progress.show();

        IntervaloDatas intervaloDatas = new IntervaloDatas(dInicio, dFinal);

        new AcessoRest<RelatorioRefeicoes>(this, "gestores", RelatorioRefeicoes.class) {
            @Override
            public void retorno(RelatorioRefeicoes objeto) {
                progress.dismiss();

                List<AutorizacaoRRJersey> requisicoes = new ArrayList();
                for (AutorizacaoRRJersey dados : objeto.getListRefeicoes()) {

                    requisicoes.add(dados);
                    Log.d("Autorizacao", dados.toString());
                }

                RelatorioRefeicaoAdapter relatorioAdapter = new RelatorioRefeicaoAdapter(getApplicationContext(), requisicoes);
                lvRelatorio.setAdapter(relatorioAdapter);
            }

        }.post(intervaloDatas);
    }

    private void init() {
        refeicoes = new Refeicao[]{
                new Refeicao("Almoço", new Date(), new Date()),
                new Refeicao("Jantar", new Date(), new Date())
        };
    }

}