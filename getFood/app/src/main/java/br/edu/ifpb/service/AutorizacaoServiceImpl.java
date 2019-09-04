package br.edu.ifpb.service;

import br.edu.ifpb.dao.AutorizacaoDao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.enums.StatusAutorizacao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class AutorizacaoServiceImpl implements AutorizaoService {

    @EJB
    private AutorizacaoDao autorizacaoDao;

    @Override
    public int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal, StatusAutorizacao statusAutorizacao) {
        return autorizacaoDao.quantAutorizacaoRR(statusAutorizacao,dataInicial,dataFinal);
    }

    @Override
    public List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, LocalDate dataInicial, LocalDate dataFinal, StatusAutorizacao statusAutorizacao) {
        return autorizacaoDao.listarAutorizacaoRR(min,quant,statusAutorizacao,dataInicial,dataFinal);
    }
}
