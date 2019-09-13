package br.edu.ifpb.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.service.RefeicaoService;

@SuppressWarnings("serial")
@RequestScoped
@Named
public class RefeicaoController implements Serializable {

	@Inject
	private RefeicaoService service;	
	private Refeicao refeicao;
	private String nome;
	private LocalDate horaInicio;
	private LocalDate horaTermino;

	public void salvarRefeicao() {
		service.salvar(refeicao);
	}

	public void atualizarRefeicao() {
		service.atualizar(getRefeicao());
	}

	public void removerRefeicao() {
		service.remover(refeicao);
	}

	public List<Refeicao> getListaDeRefeicoes() {
		return service.listar();
	}

	public List<Requisicao> getRefeicoesNoDia() {
		return service.refeicoesNoDia(LocalDate.now());
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDate horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(LocalDate horaTermino) {
		this.horaTermino = horaTermino;
	}

}
