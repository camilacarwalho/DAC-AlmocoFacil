package com.example.almocofacil.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Requisicao;
import com.example.almocofacil.domain.Usuario;
import com.example.almocofacil.domain.enums.StatusRequisicao;
import com.example.almocofacil.services.AcessarRest;
import com.example.almocofacil.services.GetRest;
import com.example.almocofacil.services.UsuarioService;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import okhttp3.Response;

public class AcompanharSolicitacaoActivity extends AppCompatActivity {

    private List<Requisicao> requisicoes;
    private ListView lvRequisicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhar_solicitacao);

        lvRequisicoes = findViewById(R.id.tv_solicitacao);


        requisicoes = new ArrayList<>();
        requisicoes.add(new Requisicao(
                1, //int solicitacaoId,
                1, //int requisicaoId,
                new Date(),//Date dataSolicitacao,
                "Eu", //String nomeRequerente,
                "123", //String matriculaRequerente,
                "Isso é uma requisição", //String descricao,
                StatusRequisicao.PENDENTE, //StatusRequisicao status,
                "Porque eu quero", //String justificativa,
                "Almoço", //String refeicaoNome,
                1, //int refeicaoId,
                new Date(), //Date dataInicio,
                new Date())); //Date dataFinal);

        RequisicaoAdapter adapter = new RequisicaoAdapter(requisicoes,this);
        lvRequisicoes.setAdapter(adapter);
        Type listType = new TypeToken<ArrayList<Requisicao>>(){}.getType();
        new GetRest<List<Requisicao>>(this,"requisicao/5000007",  listType){

            @Override
            public void retorno(final List<Requisicao> objeto) {
                atualizarListView(Collections.unmodifiableList(objeto));
            }

        }.get();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id== R.id.logout){
            System.out.println("funcionou logout");
            Intent logout = new Intent(getApplicationContext(), LoginActivity.class);
//            startActivity(logout);
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(
                    getApplicationContext(),R.anim.fade_in,R.anim.mover_esquerda);
            ActivityCompat.startActivity(AcompanharSolicitacaoActivity.this,logout,activityOptionsCompat.toBundle());
            finish();
        }
        if (id== R.id.solicitacao){
            System.out.println("funcionou solicitação");
            Intent intent = new Intent(this, SolicitarRefeicao.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void atualizarListView(List<Requisicao> requisicoes){
        RequisicaoAdapter adapter = new RequisicaoAdapter(requisicoes,this);
        lvRequisicoes.setAdapter(adapter);
    }
}
