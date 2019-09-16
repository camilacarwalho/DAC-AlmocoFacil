package br.edu.ifpb.service;

import br.edu.ifpb.dao.PeriodoDao;
import br.edu.ifpb.domain.Periodo;
import javax.ejb.EJB;

public class PeriodoServiceImpl implements PeriodoService{
    
    @EJB
    private PeriodoDao dao;

    @Override
    public Periodo buscarPorAno(int ano) {
        return dao.buscarPorAno(ano);
    }
    
    @Override
    public Periodo buscarPorPeriodo(int periodo) {
        return dao.buscarPorPeriodo(periodo);
    }

    @Override
    public void salvar(Periodo periodo) {
        dao.salvar(periodo);
    }

    @Override
    public void atualizar(Periodo periodo) {
        dao.atualizar(periodo);
    }

    @Override
    public void remover(Periodo periodo) {
        dao.remover(periodo);
    }
    
}
