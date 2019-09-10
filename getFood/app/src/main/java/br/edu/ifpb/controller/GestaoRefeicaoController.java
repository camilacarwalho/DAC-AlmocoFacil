package br.edu.ifpb.controller;

import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.service.AutorizacaoService;

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
    private AutorizacaoService autorizaoService;

    private LocalDate dataInicial;
    private LocalDate dataFinal;


    @PostConstruct
    public void init(){
        buscar();
    }

    @Override
    protected List<AutorizacaoRR> listarItensDaBusca(int inicio, int maximo) {
        return autorizaoService.listarAutorizacaoRR(inicio,maximo,dataInicial,dataFinal);
    }

    @Override
    public int getQuantidadeItens() {
        return autorizaoService.quantAutorizacaoRR(dataInicial,dataFinal);
    }


    public StatusAutorizacao[] getListarStatus() {return StatusAutorizacao.values();}


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
