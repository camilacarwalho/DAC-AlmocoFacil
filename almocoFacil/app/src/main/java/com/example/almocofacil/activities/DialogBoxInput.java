package com.example.almocofacil.activities;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.almocofacil.R;

public abstract class DialogBoxInput extends AlertDialog {

    private String titulo;
    private String textoBotao;
    private TextView tvTitulo;
    private EditText etCampo;
    private Button btOk;
    private Button btCancelar;


    public DialogBoxInput(Context context, String titulo, String textoBotao) {
        super(context);
        this.titulo = titulo;
        this.textoBotao = textoBotao;
    }

    public abstract void retorno(String valor);
    public abstract void cancelar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imput_box);
        tvTitulo = findViewById(R.id.tvInputBoxCampo);
        etCampo = findViewById(R.id.etInputCampo);
        btOk = findViewById(R.id.btInputBoxOk);
        btCancelar = findViewById(R.id.btInputBoxCancelar);
        etCampo.setText("");
        tvTitulo.setText(titulo);
        btOk.setText(textoBotao);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retorno(etCampo.getText().toString());
            }
        });

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {cancelar();}
        });

    }
}
