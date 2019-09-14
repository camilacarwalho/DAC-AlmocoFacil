package com.example.almocofacil.activities;


import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almocofacil.R;
import com.example.almocofacil.domain.Aluno;

public class ListarAlunos extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    ArrayList<String> selectedItems;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlistaluno);

        //spinner

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.lista_refeicao, android.R.layout.simple_spinner_item);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        selectedItems=new ArrayList<String>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");
        dados.add("almoço - 06/09/2019 - 07/09/2019");

        return dados;
    }
    public void onStart(){
        super.onStart();
        ListView lview = (ListView) findViewById(R.id.checkable_list);
        lview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayList<String> aluno = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, aluno);
        lview.setAdapter(arrayAdapter);
        //set OnItemClickListener
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items
            }

        });
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