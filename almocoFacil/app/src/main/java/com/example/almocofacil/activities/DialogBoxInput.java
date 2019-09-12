package com.example.almocofacil.activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.almocofacil.R;

public abstract class DialogBoxInput extends DialogFragment {

    private String titulo;
    private String textoBotao;
    private EditText campo;


    public DialogBoxInput(String titulo, String textoBotao) {
        this.titulo = titulo;
        this.textoBotao = textoBotao;
    }

    public abstract void retorno(String valor);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        builder
                .setMessage(this.titulo)
                .setView(inflater.inflate(R.layout.imput_box, null))
                .setPositiveButton(textoBotao, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        campo = getActivity().findViewById(R.id.etInputCampo);
                        retorno(campo.getText().toString());
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DialogBoxInput.this.getDialog().cancel();
                    }
                });


        return builder.create();
    }
}
