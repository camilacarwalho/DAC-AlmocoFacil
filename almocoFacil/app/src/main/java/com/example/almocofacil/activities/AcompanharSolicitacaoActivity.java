package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
}
