package br.edu.ifpb.dao;

import br.edu.ifpb.domain.Edital;

public interface EditalDao extends DefaultDao<Edital> {
    
    Edital buscarAno(int ano);
    
    Edital buscarPorPeriodo(int periodo);
    
}
