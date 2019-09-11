package br.edu.ifpb.service.resouces.convert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Usuario;
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
	
	
	public static RequisicaoRest requisicaoParaRest(Requisicao requisicao) {
		if(requisicao == null || requisicao.getSolicitacao() == null)
			return new RequisicaoRest();
		return new RequisicaoRest(
				requisicao.getSolicitacao().getId().intValue(), //solicitacaoId, 
				requisicao.getId().intValue(), //requisicaoId,
				localDateToDate(requisicao.getSolicitacao().getDataSolicitacao()), //dataSolicitacao, 
				requisicao.getSolicitacao().getUsuario().getPessoa().getNome(), //nomeRequerente, 
				requisicao.getSolicitacao().getUsuario().getMatricula(), //matriculaRequerente, 
				requisicao.getSolicitacao().getDescricao(), //descricao, 
				requisicao.getStatusRequisicao(), //status, 
				requisicao.getSolicitacao().getJustificativa(), //justificativa, 
				requisicao.getRefeicao().getNome(),// refeicaoNome, 
				requisicao.getRefeicao().getId().intValue(), //refeicaoId, 
				localDateToDate(requisicao.getDataInicial()), //dataInicio, 
				localDateToDate(requisicao.getDataFinal()));// dataFinal);
	}
}
