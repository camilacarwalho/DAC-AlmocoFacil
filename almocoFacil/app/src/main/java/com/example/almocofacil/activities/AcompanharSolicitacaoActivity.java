package com.example.almocofacil.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.almocofacil.R;

import java.util.ArrayList;

public class AcompanharSolicitacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acompanhar_solicitacao);

        ListView lista = findViewById(R.id.tv_solicitacao);

        ArrayList<String> equipes = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(this,
                android.R.layout.simple_list_item_1,
                equipes);
        lista.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");

        return dados;
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
}
