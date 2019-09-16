package br.edu.ifpb.service;

import br.edu.ifpb.dao.EditalDao;
import br.edu.ifpb.domain.Edital;
import java.util.List;
import javax.ejb.EJB;

public class EditalServiceImpl implements EditalService {
    
    @EJB
    private EditalDao dao;
    
    @Override
    public Edital pesquisar(String codigo) {
        return dao.buscar(codigo);
    }

    @Override
    public Edital buscarPorAno(int ano) {
        return dao.buscarAno(ano);
    }

    @Override
    public Edital buscarPorPeriodo(int periodo) {
        return dao.buscarPorPeriodo(periodo);
    }
    
    @Override
    public List<Edital> listar() {
        return dao.listar();
    }

    @Override
    public void salvar(Edital edital) {
        dao.salvar(edital);
    }

    @Override
    public void atualizar(Edital edital) {
        dao.atualizar(edital);
    }

    @Override
    public void remover(Edital edital) {
        dao.remover(edital);
    }
    
}
