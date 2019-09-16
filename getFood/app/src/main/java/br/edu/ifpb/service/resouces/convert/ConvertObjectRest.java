package br.edu.ifpb.service.resouces.convert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.domain.enums.StatusRequisicao;
import br.edu.ifpb.domain.resource.AlunoRest;
import br.edu.ifpb.domain.resource.AutorizacaoRest;
import br.edu.ifpb.domain.resource.RequisicaoRest;
import br.edu.ifpb.domain.resource.UsuarioRest;

public class ConvertObjectRest {
	
	private static Date localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	public static UsuarioRest usuarioParaRest(Usuario usuario) {
		
		if(usuario == null || usuario.getPessoa() == null) 
			return new UsuarioRest();
		
		return new UsuarioRest(
				usuario.getMatricula(), 
				"", 
				usuario.getCargo(), 
				usuario.getPessoa().getCpf(), 
				usuario.getPessoa().getNome(),
				usuario.getPessoa().getTelefone());			
	}
	
	public static AutorizacaoRest autorizacaoParaRest(Autorizacao autorizacao) {
		if (autorizacao == null 
				|| autorizacao.getAluno() == null
				|| autorizacao.getRefeicao() == null) {
			return new AutorizacaoRest();
		}
		
		
		LocalDate hoje = LocalDate.now();
		boolean concluida = LocalDate.now().isAfter(autorizacao.getData()); 
		concluida = concluida || autorizacao.getStatusAutorizacao() == StatusAutorizacao.NEGADA;
		concluida = concluida || autorizacao.getStatusAutorizacao() == StatusAutorizacao.RENUNCIADA;
		concluida = concluida || autorizacao.getStatusAutorizacao() == StatusAutorizacao.AUSENTE;
		concluida = concluida || autorizacao.getStatusAutorizacao() == StatusAutorizacao.REALIZADA;
		
		
		Date data = convertaLocalParaDate(autorizacao.getData(),autorizacao.getHora());
		
		return new AutorizacaoRest(
				autorizacao.getId().intValue(),//autorizacaoId, 
				autorizacao.getAluno().getMatricula(), //matriculaAluno, 
				autorizacao.getAluno().getPessoa().getNome(), //nomeAluno, 
				data, 
				autorizacao.getRefeicao().getNome(), //refeicaoNome, 
			 	autorizacao.getRefeicao().getId().intValue(), //refeicaoId, 
				autorizacao.getStatusAutorizacao(), //statusAutorizacao, 
				autorizacao.getRequisicao().getId().intValue(), //requisicaoId);
				concluida); //concluída);
	}
	
	
	private static Date convertaLocalParaDate(LocalDate data, LocalTime hora) {
		
		Date d = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
				
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		if(hora != null) {
			cal.set(Calendar.HOUR_OF_DAY, hora.getHour());
			cal.set(Calendar.MINUTE, hora.getMinute());
			cal.set(Calendar.SECOND, hora.getSecond());
		}
		return  cal.getTime();
	}

	public static RequisicaoRest requisicaoParaRest(Requisicao requisicao) {
		if(requisicao == null || requisicao.getSolicitacao() == null)
			return new RequisicaoRest();
		return new RequisicaoRest(
				requisicao.getSolicitacao().getId().intValue(), //solicitacaoId, 
				requisicao.getId().intValue(), //requisicaoId,
				podeAlterarRequisicao(requisicao), //podeAltera
				localDateToDate(requisicao.getSolicitacao().getDataSolicitacao()), //dataSolicitacao, 
				requisicao.getSolicitacao().getUsuario().getPessoa().getNome(), //nomeRequerente, 
				requisicao.getSolicitacao().getUsuario().getMatricula(), //matriculaRequerente, 
				requisicao.getSolicitacao().getDescricao(), //descricao, 
				requisicao.getStatusRequisicao(), //status, 
				requisicao.getSolicitacao().getJustificativa(), //justificativa, 
				requisicao.getRefeicao().getNome(),// refeicaoNome, 
				requisicao.getRefeicao().getId().intValue(), //refeicaoId, 
				localDateToDate(requisicao.getDataInicial()), //dataInicio, 
				localDateToDate(requisicao.getDataFinal()),// dataFinal);
				requisicao.getSolicitacao().getLatitude(),// latitude);
				requisicao.getSolicitacao().getLongitude());// longitude);
	}
	
	private static boolean podeAlterarRequisicao(Requisicao requisicao) {
		return requisicao.getStatusRequisicao() == StatusRequisicao.PENDENTE 
				&& requisicao.getDataInicial().isAfter(LocalDate.now());
	}
		
	
	public static AlunoRest alunoParaRest(Aluno aluno) {
		if ((aluno == null) || (aluno.getPessoa() == null) || (aluno.getCurso() == null))
			return new AlunoRest();
		
		return new AlunoRest(
				aluno.getMatricula(), //matricula, 
				aluno.getPessoa().getNome(), //nome, 
				aluno.getPessoa().getCpf(), //cpf, 
				aluno.getCurso().getNome(),// //curso, 
				aluno.getPessoa().getTelefone()); //telefone);
				
	}
	
}
