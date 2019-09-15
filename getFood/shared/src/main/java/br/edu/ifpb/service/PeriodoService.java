package br.edu.ifpb.service;

import br.edu.ifpb.domain.Periodo;

public interface PeriodoService {
    
    Periodo buscarPorPeriodo(int periodo);
    
    Periodo buscarPorAno(int ano);
    
    void salvar(Periodo periodo);
    
    void atualizar(Periodo periodo);
    
    void remover(Periodo periodo);
    
}
