package com.example.almocofacil.activities;


import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;

import android.widget.ListView;
import com.example.almocofacil.R;

import com.example.almocofacil.domain.Aluno;

public class ListarAlunos extends Activity {

    private ArrayList<Aluno> listAluno;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlistaluno);

        ListView lview = (ListView) findViewById(R.id.listview);
        populateList();
        listAlunoAdapter adapter = new listAlunoAdapter(listAluno, this);
        lview.setAdapter(adapter);
    }

    // TODO: para teste
    private void populateList() {

        listAluno = new ArrayList<Aluno>();
        Aluno a = new Aluno("123", "Enrico Vicente Elias da Mata");
        Aluno b = new Aluno("124", "Sebastiana Silvana Nascimento");
        Aluno c = new Aluno("125", "Maya Ester Pereira");
        Aluno d = new Aluno("126", "Isabel Clarice Porto");
        Aluno e = new Aluno("127", "Diogo Miguel Ferreira");
        Aluno f = new Aluno("128", "Marli Benedita Liz da Mota");
        Aluno g = new Aluno("129", "Hadassa Flávia Barros");
        Aluno h = new Aluno("130", "Rodrigo Anderson Lorenzo da Luz");
        Aluno i = new Aluno("131", "Alana Camila Josefa Lopes");
        Aluno j = new Aluno("132", "Malu Sara Moraes");
        Aluno k = new Aluno("133", "Isabelle Valentina Lorena Nogueira");
        listAluno.add(a);
        listAluno.add(b);
        listAluno.add(c);
        listAluno.add(d);
        listAluno.add(e);
        listAluno.add(f);
        listAluno.add(g);
        listAluno.add(h);
        listAluno.add(i);
        listAluno.add(j);
        listAluno.add(k);


    }
}