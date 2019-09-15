package com.example.almocofacil.controler;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.almocofacil.domain.Usuario;

public class SessionSharedPreferences {

    private Context context;

    public SessionSharedPreferences(Context context){
        this.context = context;
    }

    public void login(Usuario usuario){

        if(usuario!= null) {
            SharedPreferences.Editor editor = context.getSharedPreferences("authenticatedUser", Context.MODE_PRIVATE).edit();
            editor.putBoolean("logado", true);
            editor.putString("cpf", usuario.getCpf());
            editor.putString("matricula",usuario.getMatricula());
            editor.putString("nome",usuario.getNome());
            editor.putString("telefone",usuario.getTelefone());
            editor.putString("cargo",usuario.getCargo().toString());
            editor.apply();
        }
    }

    public void logout(){
        SharedPreferences mySPrefs = context.getSharedPreferences("authenticatedUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySPrefs.edit();
        editor.remove("logado");
        editor.remove("cpf");
        editor.remove("matricula");
        editor.remove("nome");
        editor.remove("telefone");
        editor.remove("cargo");
        editor.apply();
    }
}
