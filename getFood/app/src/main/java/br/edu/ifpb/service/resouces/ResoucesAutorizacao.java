package br.edu.ifpb.service.resouces;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.ifpb.domain.Autorizacao;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.domain.enums.StatusAutorizacao;
import br.edu.ifpb.domain.resource.AutorizacaoRest;
import br.edu.ifpb.domain.resource.BuscaAutorizacao;
import br.edu.ifpb.service.AutorizacaoService;
import br.edu.ifpb.service.RefeicaoService;
import br.edu.ifpb.service.resouces.convert.ConvertObjectRest;

@Stateless
@Path("autorizacao")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ResoucesAutorizacao {
	
	@Inject
	RefeicaoService refeicaoService;
	
	@Inject
	AutorizacaoService autorizacaoService;
	
	
	@PUT
	@Path("listar")
	public Response listar(BuscaAutorizacao buscaAutorizacao) {
		
		Refeicao refeicao = refeicaoService.buscarPeloNome(buscaAutorizacao.getReifeicao());
		LocalDate data = buscaAutorizacao.getData().toInstant()
			.atZone(ZoneId.systemDefault())
			.toLocalDate();
		autorizacaoService.gerarAutorizacoes(data, refeicao);
		
		List<AutorizacaoRest> autorizacoes = new ArrayList<AutorizacaoRest>();
		for(Autorizacao autorizacao: autorizacaoService.buscarData(data, refeicao))
			autorizacoes.add(ConvertObjectRest.autorizacaoParaRest(autorizacao));			
		
		GenericEntity<List<AutorizacaoRest>> entity = new GenericEntity<List<AutorizacaoRest>>(autorizacoes) {};
		return Response.ok()
				.entity(entity)
				.build();
	}
	
	@PUT
	@Path("finalizar")
	public Response finalizar(AutorizacaoRest[] autorizacoes) {
		for (AutorizacaoRest autorizacaoRest: autorizacoes) {
			Autorizacao autorizacao = autorizacaoService.buscar(autorizacaoRest.getAutorizacaoId());
			if(autorizacaoRest.getStatusAutorizacao() == StatusAutorizacao.PENDENTE)
				autorizacaoRest.setStatusAutorizacao(StatusAutorizacao.AUSENTE);			
			if(autorizacao != null) {
				autorizacao.setStatusAutorizacao(autorizacaoRest.getStatusAutorizacao());				
				autorizacaoService.Atualizar(autorizacao);
			}
		}
		return Response.ok()
				.entity("ok")
				.build();
	}

}
