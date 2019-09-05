package com.example.almocofacil.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.almocofacil.R;

public class RelatorioRefeicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_refeicao);


        String [] lista = new String[] {"A","B","C","D","E","F","G","H","I"};

        ListView lvRelatorio = findViewById(R.id.listViewRelatorio);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista);

        lvRelatorio.setAdapter(adapter);
    }
}
