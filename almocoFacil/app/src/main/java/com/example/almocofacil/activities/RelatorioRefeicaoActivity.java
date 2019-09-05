package com.example.almocofacil.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Refeicao;
import com.example.almocofacil.domain.RelatorioRequisicaoDado;
import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class RelatorioRefeicaoActivity extends AppCompatActivity {

    List<RelatorioRequisicaoDado> requisicoes;
    Refeicao[] refeicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_refeicao);


        init();
        ListView lvRelatorio = findViewById(R.id.listViewRelatorio);

        RelatorioRefeicaoAdapter adapter = new RelatorioRefeicaoAdapter(requisicoes,this);
        lvRelatorio.setAdapter(adapter);
    }

    private void init(){
        refeicoes = new Refeicao[] {
                new Refeicao("Almoço", new Date(),new Date()),
                new Refeicao("Jantar", new Date(), new Date())
        };
        requisicoes = new ArrayList<>();
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.REALIZADA,100));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.AUSENTE,13));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.REALIZADA,121));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.AUSENTE,13));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.REALIZADA,120));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.AUSENTE,11));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.REALIZADA,112));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.AUSENTE,12));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.REALIZADA,130));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.AUSENTE,11));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.REALIZADA,112));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.AUSENTE,14));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.REALIZADA,120));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.AUSENTE,7));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.REALIZADA,130));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.AUSENTE,3));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.REALIZADA,130));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[0], StatusAutorizacao.AUSENTE,12));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.REALIZADA,130));
        requisicoes.add(new RelatorioRequisicaoDado(new Date(),refeicoes[1], StatusAutorizacao.AUSENTE,14));
        }
}
