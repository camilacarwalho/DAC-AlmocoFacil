package br.edu.ifpb.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.dao.RefeicaoDao;
import br.edu.ifpb.domain.Refeicao;
import java.time.LocalDate;

@SuppressWarnings("serial")
@RequestScoped
@Named
public class RefeicaoController implements Serializable{

	@Inject
	private RefeicaoDao refeicaoDao;
	
	public List<Refeicao> getListaDeRefeicoes(){
		return refeicaoDao.listar();
	}
        
        public List<Refeicao> getRefeicoesNoDia(LocalDate data){
                return refeicaoDao.refeicoesNoDia(data);
        }

}
