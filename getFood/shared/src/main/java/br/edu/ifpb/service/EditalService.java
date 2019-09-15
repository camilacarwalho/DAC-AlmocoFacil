package br.edu.ifpb.service;

import br.edu.ifpb.domain.Edital;
import java.util.List;

public interface EditalService {
    
    Edital pesquisar(String codigo);
    
    Edital buscarPorPeriodo(int periodo);
    
    Edital buscarPorAno(int ano);
    
    List<Edital> listar();
    
    void salvar(Edital edital);
    
    void atualizar(Edital edital);
    
    void remover(Edital edital);
    
}
