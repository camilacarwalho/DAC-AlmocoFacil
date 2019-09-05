package br.edu.ifpb.controller;

import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.service.AutorizaoService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@ViewScoped
@Named
public class GestaoRefeicaoController extends PaginacaoController<AutorizacaoRR> implements Serializable {


    @Inject
    private AutorizaoService autorizaoService;

    private StatusAutorizacao statusAutorizacao;
    private LocalDate dataInicial;
    private LocalDate dataFinal;


    @PostConstruct
    public void init(){
        statusAutorizacao=null;
        buscar();
    }

    @Override
    protected List<AutorizacaoRR> listarItensDaBusca(int inicio, int maximo) {
        return autorizaoService.listarAutorizacaoRR(inicio,maximo,dataInicial,dataFinal,this.statusAutorizacao);
    }

    @Override
    public int getQuantidadeItens() {
        return autorizaoService.quantAutorizacaoRR(dataInicial,dataFinal,statusAutorizacao);
    }


    public StatusAutorizacao[] getListarStatus() {return StatusAutorizacao.values();}

    public StatusAutorizacao getStatusAutorizacao() {
        return statusAutorizacao;
    }

    public void setStatusAutorizacao(StatusAutorizacao statusAutorizacao) {
        this.statusAutorizacao = statusAutorizacao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }


}
