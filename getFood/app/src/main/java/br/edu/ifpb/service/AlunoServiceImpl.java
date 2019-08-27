package br.edu.ifpb.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.edu.ifpb.dao.AlunoDao;
import br.edu.ifpb.domain.Aluno;

import java.util.List;

@Stateless
public class AlunoServiceImpl implements AlunoService{
	
	@EJB
	private AlunoDao alunoDao;

	@Override
	public Aluno buscarPelaMatricula(String matricula) {		
		return alunoDao.buscar(matricula);
	}

	@Override
	public int quantAlunos() {
		return alunoDao.quantBuscarAlunos();
	}

	@Override
	public List<Aluno> buscarAlunos(int min, int quant) {
		return alunoDao.buscarAlunos(min,quant);
	}

}
