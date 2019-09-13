package br.edu.ifpb.service.resouces.convert;

import java.io.Serializable;
import java.time.ZoneId;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.resource.RequisicaoRest;
import br.edu.ifpb.service.RefeicaoService;
import br.edu.ifpb.service.RequisicaoService;
import br.edu.ifpb.service.UsuarioService;

@Stateless
public class ConvertRestToRequisicao implements Serializable {
	
	@Inject
	RequisicaoService requisicaoServicer;
	@Inject
	UsuarioService usuarioService;
	@Inject
	RefeicaoService refeicaoService;
	
	public Requisicao run(RequisicaoRest requisicaoRest) {
		if(requisicaoRest == null)
			return new Requisicao();
		Requisicao requisicao = requisicaoServicer.buscar(Long.valueOf(requisicaoRest.getRequisicaoId()));
		if(requisicao == null)
			requisicao = new Requisicao();
		
		if (requisicao.getSolicitacao() == null)
			requisicao.setSolicitacao(new Solicitacao());
		Solicitacao solicitacao = requisicao.getSolicitacao(); 
		solicitacao.setId(Long.valueOf(requisicaoRest.getSolicitacaoId()));
		requisicao.setId(Long.valueOf(requisicaoRest.getRequisicaoId()));
		solicitacao.setDataSolicitacao(requisicaoRest
				.getDataSolicitacao()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
		Usuario usuario = solicitacao.getUsuario();
		if(usuario == null)
			usuario = usuarioService.buscar(requisicaoRest.getMatriculaRequerente());
		solicitacao.setUsuario(usuario);
		solicitacao.setDescricao(requisicaoRest.getDescricao());
		requisicao.setStatusRequisicao(requisicaoRest.getStatus());
		solicitacao.setJustificativa(requisicaoRest.getJustificativa());
		requisicao.setRefeicao(refeicaoService.buscar(Long.valueOf(requisicaoRest.getRefeicaoId())));
		requisicao.setDataInicial(requisicaoRest
				.getDataInicio()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
		requisicao.setDataFinal(requisicaoRest
				.getDataFinal()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate());

		return requisicao;
		
	}
}
