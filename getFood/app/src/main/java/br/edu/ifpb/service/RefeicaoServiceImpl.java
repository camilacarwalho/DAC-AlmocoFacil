package br.edu.ifpb.service;

import javax.ejb.EJB;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import java.time.LocalDate;
import java.util.List;

public class RefeicaoServiceImpl implements RefeicaoService {

	@EJB
	RefeicaoDao refeicaoDao;

	@Override
	public Refeicao buscar(Long id) {
		return refeicaoDao.buscar(id);
	}

	@Override
	public void salvar(Refeicao refeicao) {
		refeicaoDao.salvar(refeicao);
	}

	@Override
	public void atualizar(Refeicao refeicao) {
		refeicaoDao.atualizar(refeicao);
	}

	@Override
	public void remover(Refeicao refeicao) {
		refeicaoDao.remover(refeicao);
	}

	@Override
	public List<Refeicao> listar() {
		return refeicaoDao.listar();
	}

	@Override
	public Refeicao buscarPeloNome(String nome) {
		return refeicaoDao.buscarPeloNome(nome);
	}

	@Override
	public List<Requisicao> refeicoesNoDia(LocalDate data) {
		return refeicaoDao.refeicoesNoDia(data);
	}

	@Override
	public void atualizarRefeicao(Refeicao refeicao) {
		refeicaoDao.atualizar(refeicao);
	}

}
