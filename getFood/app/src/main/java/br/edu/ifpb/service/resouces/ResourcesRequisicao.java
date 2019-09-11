package br.edu.ifpb.service.resouces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.resource.RequisicaoRest;
import br.edu.ifpb.service.SolicitacaoService;
import br.edu.ifpb.service.resouces.convert.ConvertObjectRest;

@Stateless
@Path("requisicao")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class ResourcesRequisicao {
	
	@Inject
	private SolicitacaoService solicitacaoService;
	
	@GET
	@Path("{matricula}")
	public Response listaRequisicoes(@PathParam("matricula") String matricula) {
		List<Solicitacao> solicitacoes = solicitacaoService.buscarPelaMatricula(matricula, null, 0, 100);		
		List<RequisicaoRest> requisicoes = new ArrayList<RequisicaoRest>();
		
		for (Solicitacao solicitacao : solicitacoes) 
			for (Requisicao requisicao: solicitacao.getRequisicoes()) {
				requisicoes.add(ConvertObjectRest.requisicaoParaRest(requisicao));
			}
		GenericEntity<List<RequisicaoRest>> entity = new GenericEntity<List<RequisicaoRest>>(requisicoes){};
		
		return Response.ok()
				.entity(entity)
				.build();
	}
}
