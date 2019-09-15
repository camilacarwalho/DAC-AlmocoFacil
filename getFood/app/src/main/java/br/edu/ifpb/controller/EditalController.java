package br.edu.ifpb.controller;

import br.edu.ifpb.dao.SolicitacaoDao;
import br.edu.ifpb.domain.Edital;
import br.edu.ifpb.domain.Periodo;
import br.edu.ifpb.service.EditalService;
import br.edu.ifpb.service.PeriodoService;
import br.edu.ifpb.service.SolicitacaoService;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("serial")
@RequestScoped
@Named
public class EditalController implements Serializable {
    
    @Inject
    private EditalService service;
    private SolicitacaoService solservice;
    private Edital edital;
    private String codigo;
    private Periodo periodo;
    
    public void salvarEdital(){
        service.salvar(edital);
    }
    
    public void atualizarEdital(){
        service.atualizar(edital);
    }
    
    public void removerEdital(){
        service.remover(edital);
    }
    
    public List<Edital> listar(){
        return service.listar();
    }
    
    public Edital buscarPorAno(){
        return service.buscarPorAno(periodo.getAno());
    }
    
    public Edital buscarPorPeriodo(){
        return service.buscarPorPeriodo(periodo.getPeriodo());
    }
    
    public int totalAutorizacoes(){
        return solservice.quantAprovadas();
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
}
