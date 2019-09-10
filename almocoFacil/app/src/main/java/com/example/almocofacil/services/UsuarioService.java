package com.example.almocofacil.services;

import com.example.almocofacil.domain.Usuario;
import com.example.almocofacil.domain.enums.UsuarioEnum;

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
//        for (UsuarioEnum usuarioEnum : UsuarioEnum.values()) {
//            if (usuario.getCargo().equals(usuarioEnum.getIdentificador())) {
//                usuarioLogado.setCargo(usuarioEnum);
//                break;
//            }
//        }
        usuarioLogado.setCpf(usuario.getCpf());
        usuarioLogado.setTelefone(usuario.getTelefone());
        logado = true;
        return usuarioLogado;
    }





}
