package br.edu.ifpb.service.resouces;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.postgresql.core.ServerVersion;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Requisicao;
import br.edu.ifpb.domain.Solicitacao;
import br.edu.ifpb.domain.resource.AlunoRest;
import br.edu.ifpb.domain.resource.RequisicaoRest;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.RequisicaoService;
import br.edu.ifpb.service.SolicitacaoService;
import br.edu.ifpb.service.resouces.convert.ConvertObjectRest;

@Stateless
@Path("requisicao")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ResourcesRequisicao {
	
	@Inject
	private SolicitacaoService solicitacaoService;
	@Inject 
	private RequisicaoService requisicaoService;
	@Inject
	private AlunoService alunoService;
	
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
	
	@GET
	@Path("listaAlunos/{requisicaoId}")
	public Response listaAlunos(@PathParam("requisicaoId") String requisicaoId) {
		List<AlunoRest> alunos = new ArrayList<>();
		try {
			Long id = Long.valueOf(requisicaoId);
			Requisicao requisicao = requisicaoService.buscar(id);			
			
			for (Aluno aluno: requisicao.getAlunos()) {
				alunos.add(ConvertObjectRest.alunoParaRest(aluno));				
			}
			
		}catch (Exception e) {
			Logger.getLogger(ResourcesRequisicao.class.getName()).log(Level.SEVERE, e.toString(), e);			
		}
		GenericEntity<List<AlunoRest>> entity = new GenericEntity<List<AlunoRest>>(alunos) {};
		
		return Response.ok()
				.entity(entity)
				.build();
	}
	
	@PUT
	@Path("adicionarAluno")
	public Response adicionarAluno(
			@QueryParam("requisicaoId") String requisicaoId, 
			@QueryParam("matricula") String matricula) {		
		try {
			Long id = Long.valueOf(requisicaoId);
			Requisicao requisicao = requisicaoService.buscar(id); 
			Aluno aluno = alunoService.buscarPelaMatricula(matricula);			
			if (requisicaoService.adicionarAluno(requisicao, aluno))
				return Response.ok()
						.build();
		} catch (Exception e) {
			Logger.getLogger(ResourcesRequisicao.class.getName()).log(Level.SEVERE, e.toString(), e);
		}
		return Response.ok()
				.status(Status.BAD_REQUEST)
				.build();
	}

}
