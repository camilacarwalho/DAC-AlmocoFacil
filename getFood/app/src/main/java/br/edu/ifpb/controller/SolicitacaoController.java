package br.edu.ifpb.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import br.edu.ifpb.firebase.Notificacao;
import br.edu.ifpb.service.AlunoService;
import com.google.firebase.messaging.FirebaseMessagingException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ViewScoped
@Named
public abstract class SolicitacaoController implements Serializable{
	
	private static final String PARAMETRO_SOLICITACAO_ID = "solic";
	
	private static final long serialVersionUID = 8893178495248405539L;
	@Inject
	private UsuarioController usuarioController;
        @Inject
	private RefeicaoController refeicaoController;
	@Inject
	private AlunoService alunoService;
	private Solicitacao solicitacao;
	private Long cntReq;
	private Long requerimentoId;
	private String matricula;

	protected abstract boolean podeSalvarSolicitacao(Solicitacao solicitacao);
	protected abstract boolean podeSalvarRequisicao(Requisicao requisicao);
	protected abstract Solicitacao novaSolicitacao();
	protected abstract void salvarSolicitacao();
	protected abstract void atualizarSolicitacao();
	protected abstract Solicitacao buscarSolicitacao(Long id, String matricula);
	
	@PostConstruct
	private void init() {
		String parm = lerParametro(PARAMETRO_SOLICITACAO_ID);
		solicitacao = null;
		if (parm != null)
			try {		
				Long id = Long.valueOf(parm);
				this.solicitacao = buscarSolicitacao(id, usuarioController.getMatricula());
			}catch (Exception e) {}
		
		if (solicitacao == null)
			criarNovaSolicitacao();
			
		cntReq = 0L;
	}
	
	private void criarNovaSolicitacao() {
		solicitacao = novaSolicitacao();
		this.solicitacao.setDataSolicitacao(LocalDate.now());
		this.solicitacao.setUsuario(usuarioController.getUsuario());
		this.solicitacao.setStatusRequisicao(StatusRequisicao.PENDENTE);
	}
	
	private String lerParametro(String parametro) {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return request.getParameter(parametro);
	}
	
	private Requisicao criarNovaRequisicao() {
		return new Requisicao(
				--cntReq,
				StatusRequisicao.PENDENTE, 
				null, 
				new ArrayList<>(),
				LocalDate.now().plusDays(1),
				LocalDate.now().plusDays(1), 
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
	
	private boolean solicitacaoValida() {
		if (!podeSalvarSolicitacao(solicitacao))//Específico
			return false;

		if (solicitacao.getDescricao() == null || solicitacao.getDescricao().isEmpty()) {
			MessagesAlert.addErrorMessage("Informe um descrição.");
			return false;
		}
		if(solicitacao.getRequisicoes().size()==0) {
			MessagesAlert.addErrorMessage("Não existe requisição.");
			return false;
		}
		for (Requisicao requisicao : solicitacao.getRequisicoes()) 
			if (!requesicaoValida(requisicao)) return false;
		return true;
	}
	
	private boolean requesicaoValida(Requisicao requisicao) {
		if (requisicao == null) {
			MessagesAlert.addErrorMessage("Requisição inválida.");
			return false;
		}
//		Inverter datas
		if (requisicao.getDataInicial().isAfter(requisicao.getDataFinal())) {
			LocalDate tmp = requisicao.getDataInicial();
			requisicao.setDataInicial(requisicao.getDataFinal());
			requisicao.setDataFinal(tmp);
		}
		if (!podeSalvarRequisicao(requisicao)) //Específico
			return false;
		
		if (requisicao.getRefeicao()==null) {
			MessagesAlert.addErrorMessage("Informe a refeição.");
			return false;
		}
		if(requisicao.getAlunos().size()==0) {
			MessagesAlert.addErrorMessage("Não existe aluno na requisição.");
			return false;
		}
		return true;
	}
	
	public String salvar() {
		if (!solicitacaoValida())
			return null;
		if (solicitacao.getId() == null) {
			for (Requisicao requisicao : solicitacao.getRequisicoes()) 
				requisicao.setId(null);
			salvarSolicitacao();
			MessagesAlert.addInfoMessage("Solicitação realizada com sucesso.");
		} else {
			atualizarSolicitacao();
			MessagesAlert.addInfoMessage("Solicitação atualizada com sucesso.");
		}
		criarNovaSolicitacao();
		return "";
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
		MessagesAlert.addInfoMessage("Aluno(a) '"
				+ aluno.getPessoa().getNome() 
				+ "' foi acionado(a) com sucesso.");
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
		MessagesAlert.addInfoMessage("O(A) aluno(a) '"
				+ aluno.getPessoa().getNome()
				+ "'foi removido(a).");
		return "";
	}
	
	public String removerRequisicao() {
		Requisicao requisicao = getRequisicao(requerimentoId);
		requerimentoId = null;
		if(requisicao == null) {
			MessagesAlert.addErrorMessage("Não foi possível remover a reqisição.");
			return null;
		}
		this.solicitacao.getRequisicoes().remove(requisicao);
		return "";
	}
	
	public Solicitacao getSolicitacao() {return solicitacao;}
	public void setSolicitacao(Solicitacao solicitacao) {this.solicitacao = solicitacao;}
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
