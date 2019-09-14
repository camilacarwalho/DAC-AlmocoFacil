package com.example.almocofacil.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.almocofacil.domain.Usuario;
import com.example.almocofacil.threads.ApiRequest;
import com.google.gson.Gson;

public class UsuarioService {

    private static UsuarioService usuarioService;
    private Usuario usuarioLogado;
    private boolean logado;
    private Context context;

    private UsuarioService(Context context){
        this.context = context;
        sair();
    }

     private void sair() {
        usuarioLogado = new Usuario();
        logado = false;
    }

    public static UsuarioService getUsuarioService(Context context){
        if (usuarioService == null){
            usuarioService = new UsuarioService(context);
        }
        return usuarioService;
    }

    public Usuario logar(final Usuario usuario){
        usuarioLogado = new Usuario();
        usuarioLogado.setMatricula(usuario.getMatricula());
        usuarioLogado.setNome(usuario.getNome());
        usuarioLogado.setCargo(usuario.getCargo());
        usuarioLogado.setCpf(usuario.getCpf());
        usuarioLogado.setTelefone(usuario.getTelefone());
        logado = true;

        return usuarioLogado;
    }

    public Usuario getUsuarioLogado() {return usuarioLogado;}
    public boolean isLogado() {return logado;}
}
