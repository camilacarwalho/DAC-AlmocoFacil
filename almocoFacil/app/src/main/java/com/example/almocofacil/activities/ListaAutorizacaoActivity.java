package com.example.almocofacil.activities;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Autorizacao;
import com.example.almocofacil.domain.enums.StatusAutorizacao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaAutorizacaoActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Date data;
    private String refeicao;

    private List<Autorizacao> autorizacoes;
    private EditText edData;
    private Button btListar;
    private Button btEncerrar;
    private Spinner spRefeicao;
    private ListView lsAutorizacoes;
    private ProgressDialog progress;



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_autorizacao);

        edData = findViewById(R.id.edDataAutorizacao);
        spRefeicao = findViewById(R.id.spRefeicao);
        btListar = findViewById(R.id.btListar);
        btEncerrar = findViewById(R.id.btEncerrar);
        lsAutorizacoes = findViewById(R.id.lvAutorizacoes);

        autorizacoes = new ArrayList<>();

        //spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.lista_refeicao, android.R.layout.simple_spinner_item);
        spRefeicao = (Spinner) findViewById(R.id.spRefeicao);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spRefeicao.setAdapter(spinnerAdapter);
        spRefeicao.setOnItemSelectedListener(this);

        progress = new ProgressDialog(this);
        progress.setTitle("Carregando dados...");

        data = new Date();
        refeicao = "Almoço";

        mostrarFiltro();

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                carregarDados();
            }
        });

    }

    private void mostrarFiltro() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        edData.setText(sdf.format(data));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    private void carregarDados() {
        progress.show();
        for(int i = 0; i < 10; i++)
            autorizacoes.add(new Autorizacao(
                   0,
                   "201912010001",
                   "José das Couves Braga Pereira Filho",
                   new Date(),
                   "Almoço",
                   1,
                    StatusAutorizacao.PENDENTE,
                    1
            ));
        atualizarLista(autorizacoes);
    }

    private void atualizarLista(List<Autorizacao> autorizacoes ){
        this.autorizacoes = autorizacoes;
        ListAutorizacaoAdapter adapter = new ListAutorizacaoAdapter(autorizacoes,this);
        lsAutorizacoes.setAdapter(adapter);
        progress.dismiss();
    }


    public void onStart(){
        super.onStart();
//        ListView lview = (ListView) findViewById(R.id.lvAutorizacoes);
//        lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_multiple_choice, aluno);
//        lview.setAdapter(arrayAdapter);
//        //set OnItemClickListener
//        lview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // selected item
//                String selectedItem = ((TextView) view).getText().toString();
//                if(selectedItems.contains(selectedItem))
//                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
//                else
//                    selectedItems.add(selectedItem); //add selected item to the list of selected items
//            }
//
//        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}