package com.example.almocofacil.services;

import com.example.almocofacil.domain.Usuario;

public class UsuarioService {

    private static UsuarioService usuarioService;
    private Usuario usuarioLogado;
    private boolean logado;

    private UsuarioService(){
        sair();
    }

    private void sair() {
        usuarioLogado = new Usuario();
        logado = false;
    }

    public static UsuarioService getUsarioService(){
        if (usuarioService == null){
            usuarioService = new UsuarioService();
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
