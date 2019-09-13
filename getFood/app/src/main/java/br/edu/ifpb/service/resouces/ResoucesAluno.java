package br.edu.ifpb.service.resouces;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.resource.AlunoRest;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.resouces.convert.ConvertObjectRest;

@Stateless
@Path("aluno")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ResoucesAluno {
	
	@Inject
	private AlunoService alunoService;
	@GET
	@Path("{matricula}")
	public Response aluno(@PathParam("matricula") String matricula) {
		Aluno aluno = alunoService.buscarPelaMatricula(matricula);
		if(aluno == null) {
			return Response.ok()
					.status(Status.BAD_REQUEST)
					.build();
		}
		
		AlunoRest alunoRest = ConvertObjectRest.alunoParaRest(aluno);
		return Response.ok()						
				.entity(alunoRest)
				.build();	
	}

}
