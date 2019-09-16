/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.service.AlunoService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author alann
 */
@Stateless
@Path("alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResourcesAluno {
    
    @Inject
    AlunoService alunoService;
    
    @GET
    @Path("{matricula}")
    public Response findByMatricula(@PathParam("matricula") String matricula) {
        AlunoSerializer serializer = new AlunoSerializer();
        Aluno aluno = alunoService.buscarPelaMatricula(matricula);
        
        serializer.setMatricula(aluno.getMatricula());
        serializer.setNome(aluno.getPessoa().getNome());
        
        return Response.ok()
                .entity(serializer)
                .build();
    }
    
    @POST
    public Response create(AlunoSerializer serializer) {
        System.out.println(serializer.getMatricula());
        
        serializer.setNome("Funcionou!!");
        
        return Response.ok()
                .entity(serializer)
                .build();
    }
}
