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
import com.example.almocofacil.domain.BuscaAutorizacao;
import com.example.almocofacil.domain.enums.StatusAutorizacao;
import com.example.almocofacil.services.AcessoRest;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

    private boolean carregarData(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {


            data = sdf.parse(edData.getText().toString());

            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            cal.add(Calendar.HOUR_OF_DAY,3);
            data = cal.getTime();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Data inválida",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    private void carregarDados() {

        if(! carregarData())
            return;

        progress.show();
        BuscaAutorizacao ba = new BuscaAutorizacao(data, refeicao);

        Type listType = new TypeToken<ArrayList<Autorizacao>>(){}.getType();


        new AcessoRest<List<Autorizacao>>(
                this,
                "autorizacao/listar",
                listType){

            @Override
            public void retorno(List<Autorizacao> objeto) {
                if(objeto != null){
                    atualizarLista(objeto);
                } else {
                    atualizarLista(new ArrayList<Autorizacao>());
                }
            }
        }.put(ba);
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
        refeicao = text;
        carregarDados();
//        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}