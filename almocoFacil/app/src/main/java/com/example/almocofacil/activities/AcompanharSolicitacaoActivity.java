package com.example.almocofacil.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Requisicao;
import com.example.almocofacil.domain.Usuario;
import com.example.almocofacil.domain.enums.StatusRequisicao;
import com.example.almocofacil.services.AcessoRest;
import com.example.almocofacil.services.UsuarioService;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AcompanharSolicitacaoActivity extends AppCompatActivity {

    private Usuario usuario;
    private TextView tvNome;
    private TextView tvMatricula;
    private List<Requisicao> requisicoes;
    private ListView lvRequisicoes;
    private ProgressDialog progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        usuario = UsuarioService.getUsuarioService(getApplicationContext()).getUsuarioLogado();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhar_solicitacao);

        tvNome = findViewById(R.id.tvNome);
        tvMatricula = findViewById(R.id.tvMatricula);

        tvNome.setText(usuario.getNome());
        tvMatricula.setText(usuario.getMatricula());

        lvRequisicoes = findViewById(R.id.tv_solicitacao);
        lvRequisicoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                irPara(requisicoes.get(i));
            }
        });

        progress = new ProgressDialog(this);
        progress.setTitle("Carregando dados...");

        atualizar();
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
            irPara(novaRequisicao());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Requisicao novaRequisicao() {
        Usuario usuario = UsuarioService.getUsuarioService(getApplicationContext()).getUsuarioLogado();
        Requisicao requisicao = new Requisicao();
        requisicao.setRequisicaoId(0);
        requisicao.setSolicitacaoId(0);
        requisicao.setDataSolicitacao(new Date());
        requisicao.setMatriculaRequerente(usuario.getMatricula());
        requisicao.setNomeRequerente(usuario.getNome());
        requisicao.setDataInicio(new Date());
        requisicao.setDataFinal(new Date());
        requisicao.setDescricao("Informe a descrição");
        requisicao.setStatus(StatusRequisicao.PENDENTE);
        requisicao.setRefeicaoNome("Almoço");
        requisicao.setRefeicaoId(1);
        return requisicao;
    }

    private void atualizar(){
        progress.show();
        Type listType = new TypeToken<ArrayList<Requisicao>>(){}.getType();
        new AcessoRest<List<Requisicao>>(
                this,
                "requisicao/"+ usuario.getMatricula() ,
                listType){

            @Override
            public void retorno(final List<Requisicao> objeto) {
                atualizarListView(Collections.unmodifiableList(objeto));
            }

        }.get();
    }

    private void atualizarListView(List<Requisicao> requisicoes){
        this.requisicoes = requisicoes;
        RequisicaoAdapter adapter = new RequisicaoAdapter(requisicoes,this);
        lvRequisicoes.setAdapter(adapter);
        progress.dismiss();
    }

    private void irPara(Requisicao requisicao){
        Intent intent = new Intent(getApplicationContext(), SolicitarRefeicaoActivity.class);
        intent.putExtra("requisicao",requisicao);
        startActivity(intent);
    }
}
