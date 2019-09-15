package br.edu.ifpb.service;

import br.edu.ifpb.dao.AutorizacaoDao;
import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AutorizacaoServiceImpl implements AutorizacaoService{

    @EJB
    private AutorizacaoDao autorizacaoDao;
    @Inject
    private RequisicaoService requisicaoService;
    
    @Schedule(dayOfWeek = "Sun, Mon, Tue, Wed, Thu", hour="23", minute = "1")
    @Override
    public void gerarAutorizacoes() {
        System.out.println("gerando autorizações");
        List<Requisicao> requisicoes  = requisicaoService.buscarRequisicoes(StatusRequisicao.AUTORIZADA, LocalDate.now());
        requisicoes.forEach(r -> {
            r.getAlunos().forEach(a
                    -> salvar(new Autorizacao(a, LocalDate.now().plusDays(1), LocalTime.now(), r.getRefeicao(), StatusAutorizacao.PENDENTE, r))
            );
        }
        );
    }
    
    
    
    @Override
	public void gerarAutorizacoes(LocalDate data, Refeicao refeicao) {
    	List<Requisicao> requisicoes = requisicaoService.buscarParaAutorizar(data, refeicao);
    	List<Autorizacao> autorizacoes = this.buscarData(data, refeicao);
    	Map<String, Autorizacao> matriculas = new HashMap<String,Autorizacao>();
    	for(Autorizacao autorizacao: autorizacoes) {
    		matriculas.put(autorizacao.getAluno().getMatricula(),autorizacao);
    	}
    	
    	for(Requisicao requisicao: requisicoes) {
    		for(Aluno aluno: requisicao.getAlunos()) {
    			if (!matriculas.containsKey(aluno.getMatricula())){
    				this.salvar(
    						new Autorizacao(
    								aluno, 
    								data, 
    								null, 
    								refeicao, 
    								StatusAutorizacao.PENDENTE, 
    								requisicao)
    						);
    			}
    		}
    	}
	} 
    
    

	@Override
	public void finalizarAutorizacoes(LocalDate data, Refeicao refeicao) {
		List<Autorizacao> autorizacaos = this.buscarData(data, refeicao);
		for (Autorizacao autorizacao: autorizacaos) {
			if(autorizacao.getStatusAutorizacao() == StatusAutorizacao.PENDENTE) {
				autorizacao.setHora(LocalTime.now());
				autorizacao.setStatusAutorizacao(StatusAutorizacao.AUSENTE);
				this.Atualizar(autorizacao);
			}
		}
		
	}



	@Schedule(dayOfWeek = "Sun, Mon, Tue, Wed, Thu", hour="23")
    @Override
    public void finalizarTodasAutorizacoesPendentesHoje(){
        List<Autorizacao> autorizacoes = buscar(LocalDate.now());
        autorizacoes.stream().forEach(a -> {
            if (a.getStatusAutorizacao().equals(StatusAutorizacao.PENDENTE)) {
               alterarStatusAutorizacao(a.getId(), StatusAutorizacao.AUSENTE);
            }
        }
        );
    }

    @Override
    public void salvar(Autorizacao autorizacao) {
        autorizacaoDao.salvar(autorizacao);

    }

    @Override
    public List<Autorizacao> listar() {
        return autorizacaoDao.listar();
    }

    @Override
    public Autorizacao buscar(int id) {
        return autorizacaoDao.buscar(id);

    }

    @Override
    public List<Autorizacao> buscar(LocalDate data) {
        return autorizacaoDao.buscar(data);
    }
    
    

    @Override
	public List<Autorizacao> buscarData(LocalDate data, Refeicao refeicao) {		
		return autorizacaoDao.buscarDataRefeicao(data, refeicao);
	}



	@Override
    public void Atualizar(Autorizacao autorizacao) {
        autorizacaoDao.atualizar(autorizacao);

    }

    @Override
    public void alterarStatusAutorizacao(Long idAltorizacao, StatusAutorizacao statusAutorizacao) {
       autorizacaoDao.alterarStatus(idAltorizacao, statusAutorizacao);
    }

    
    @Override
    public int quantAutorizacaoRR(LocalDate dataInicial, LocalDate dataFinal) {
        return autorizacaoDao.quantAutorizacaoRR(dataInicial,dataFinal);
    }

    @Override
    public List<AutorizacaoRR> listarAutorizacaoRR(int min, int quant, LocalDate dataInicial, LocalDate dataFinal) {
        return autorizacaoDao.listarAutorizacaoRR(min,quant,dataInicial,dataFinal);
    }

    @Override
    public List<AutorizacaoRR> listarAutorizacaoRRApi(LocalDate dataInicial, LocalDate dataFinal) {
        return autorizacaoDao.listarAutorizacaoRRApi(dataInicial,dataFinal);
    }
}
