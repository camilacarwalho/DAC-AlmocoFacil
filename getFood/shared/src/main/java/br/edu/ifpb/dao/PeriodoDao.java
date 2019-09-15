package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Periodo;

public interface PeriodoDao extends DefaultDao<Periodo> {
    
    Periodo buscarPorAno(int ano);
    
    Periodo buscarPorPeriodo(int periodo);
        
}
