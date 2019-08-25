package br.edu.ifpb.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.SolicitacaoService;

@ViewScoped
@Named
public class RequererController implements Serializable{
	
	private static final long serialVersionUID = 5669298888018337078L;
	@Inject
	private UsuarioController usuarioController;
	@Inject
	private RefeicaoController refeicaoController;
	@Inject
	private SolicitacaoService solicitacaoService;
	@Inject
	private AlunoService alunoService;
	private Solicitacao solicitacao;
	private Long cntReq;
	
	private Long requerimentoId;
	private String matricula;
	
	@PostConstruct
	private void init() {
		criarNovaSolicitacao();
		cntReq = 0L;
	}
	
	private void criarNovaSolicitacao() {
		this.solicitacao = new Solicitacao();
		this.solicitacao.setDataSolicitacao(LocalDate.now());
		this.solicitacao.setUsuario(usuarioController.getUsuario());
		this.solicitacao.setStatusRequisicao(StatusRequisicao.PENDENTE);		
		//this.solicitacao.adicionarRequisicao(criarNovaRequisicao());
	}
	
	private Requisicao criarNovaRequisicao() {
		return new Requisicao(
				--cntReq,
				StatusRequisicao.PENDENTE, 
				refeicaoController.getListaDeRefeicoes().get(0), 
				new ArrayList<>(),
				LocalDate.now(),
				LocalDate.now(), 
				this.solicitacao, 
				new ArrayList<>());
	}
	
	private Requisicao getRequisicao(Long id) {
		for (Requisicao requisicao : this.solicitacao.getRequisicoes()) {
			if (requisicao.getId().equals(id))
				return requisicao;
		}
		return null;
	}
	
	public String adicionarRequisicao() {
		this.solicitacao.getRequisicoes().add(criarNovaRequisicao());
		return "";
	}
	
	public String adicionarAlunoPelaMatricula() {
		Requisicao requisicao = getRequisicao(requerimentoId);
		Aluno aluno = alunoService.buscarPelaMatricula(matricula);
		requerimentoId = null;
		matricula = "";
		if(requisicao == null || aluno == null) {
			MessagesAlert.addErrorMessage("Não foi possível adiconar o aluno.");
			return null;
		}
		
		for (Aluno item : requisicao.getAlunos()) {
			if (item.equals(aluno)) {
				MessagesAlert.addErrorMessage("Não foi possível adiconar o(a) aluno(a) '"
						+ aluno.getPessoa().getNome()
						+"', ele(a) consta na lista.");
				return null;
			}
				
		}
		
		requisicao.getAlunos().add(aluno);
		MessagesAlert.addInfoMessage("Aluno '"
				+ aluno.getPessoa().getNome() 
				+ "'\n Foi acionado com sucesso.");
		return "";
	}
	
	public String removerAluno() {
		Requisicao requisicao = getRequisicao(requerimentoId);
		Aluno aluno = alunoService.buscarPelaMatricula(matricula);
		requerimentoId = null;
		matricula = "";
		if(requisicao == null || aluno == null) {
			MessagesAlert.addErrorMessage("Não foi possível remover o aluno.");
			return null;
		}
		requisicao.getAlunos().remove(aluno);
		MessagesAlert.addInfoMessage("O aluno '"
				+ aluno.getPessoa().getNome()
				+ "'foi removido.");
		return "";
	}
	
	public String removerRequisicao(Requisicao requisicao) {
		this.solicitacao.getRequisicoes().remove(requisicao);
		return "";
	}
	
	public String getDescricao() {return this.solicitacao.getDescricao();}
	public void setDescricao(String descricao) {this.solicitacao.setDescricao(descricao);}
	public List<Requisicao> getRequisicoes() {return  this.solicitacao.getRequisicoes();}
	public void setRequisicoes(List<Requisicao> requisicoes) {this.solicitacao.setRequisicoes(requisicoes);}
	public List<Refeicao> getListRefeicoes(){return refeicaoController.getListaDeRefeicoes();}
	public Long getRequerimentoId() {return requerimentoId;}
	public void setRequerimentoId(Long requerimentoId) {this.requerimentoId = requerimentoId;}
	public String getMatricula() {return matricula;}
	public void setMatricula(String matricula) {this.matricula = matricula;}

}
