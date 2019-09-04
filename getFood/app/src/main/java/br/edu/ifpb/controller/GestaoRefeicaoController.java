package br.edu.ifpb.controller;

import br.edu.ifpb.domain.enums.StatusAutorizacao;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class GestaoRefeicaoController implements Serializable {

    StatusAutorizacao statusAutorizacao;

    @PostConstruct
    public void init(){
        statusAutorizacao=null;
    }

    public StatusAutorizacao[] getListarStatus() {return StatusAutorizacao.values();}

    public StatusAutorizacao getStatusAutorizacao() {
        return statusAutorizacao;
    }

    public void setStatusAutorizacao(StatusAutorizacao statusAutorizacao) {
        this.statusAutorizacao = statusAutorizacao;
    }
}
