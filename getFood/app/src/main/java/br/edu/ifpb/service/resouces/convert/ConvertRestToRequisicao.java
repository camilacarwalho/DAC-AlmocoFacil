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
import br.edu.ifpb.service.SolicitacaoService;
import br.edu.ifpb.service.UsuarioService;

@Stateless
public class ConvertRestToRequisicao implements Serializable {
	
	@Inject
	RequisicaoService requisicaoServicer;
	@Inject
	SolicitacaoService solicitacaoService;
	@Inject
	UsuarioService usuarioService;
	@Inject
	RefeicaoService refeicaoService;
	
	public Requisicao run(RequisicaoRest requisicaoRest) {
		if(requisicaoRest == null)
			return new Requisicao();
		Requisicao requisicao = null;
		Solicitacao solicitacao = solicitacaoService.buscar(Long.valueOf(requisicaoRest.getSolicitacaoId()));
		if( solicitacao != null) 
			for(Requisicao req: solicitacao.getRequisicoes()) 
				if(req.getId().equals(Long.valueOf(requisicaoRest.getRequisicaoId())))
					requisicao = req;
		
		if (solicitacao == null) {
			solicitacao = new Solicitacao();
			solicitacao.setId(null);
			solicitacao.setStatusRequisicao(requisicaoRest.getStatus());
		}
		
		if(requisicao == null) {
			requisicao = new Requisicao();	
			requisicao.setId(null);
			solicitacao.adicionarRequisicao(requisicao);
		}
		
		solicitacao.setDataSolicitacao(requisicaoRest
				.getDataSolicitacao()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate().plusDays(1));
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
				.toLocalDate().plusDays(1));
		requisicao.setDataFinal(requisicaoRest
				.getDataFinal()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate().plusDays(1));

		return requisicao;
		
	}
}
