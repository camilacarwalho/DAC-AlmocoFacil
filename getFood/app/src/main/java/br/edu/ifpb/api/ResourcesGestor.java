package br.edu.ifpb.api;

import br.edu.ifpb.dao.AutorizacaoDao;
import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.service.AutorizaoService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Stateless
@Path("gestores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResourcesGestor {

    @Inject
    AutorizacaoDao autorizacaoDao;


    @POST
    public Response listarTodos(){
        List<AutorizacaoRR> todos = this.autorizacaoDao.listarAutorizacaoRRApi(null,null);

        GenericEntity<List<AutorizacaoRR>> entity = new  GenericEntity<List<AutorizacaoRR>>(todos){};
        return Response.ok().entity(entity).build();
    }

    @POST
    @Path("listarPorData/{dataInicial},{dataFinal}")
    public Response listarPorData(@PathParam("dataInicial")String dataInicial,@PathParam("dataFinal")String dataFinal){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateInicio = LocalDate.parse(dataInicial,formato);
        LocalDate dateFim = LocalDate.parse(dataFinal,formato);
        List<AutorizacaoRR> todos = this.autorizacaoDao.listarAutorizacaoRRApi(dateInicio,dateFim);
        GenericEntity<List<AutorizacaoRR>> entity = new  GenericEntity<List<AutorizacaoRR>>(todos){};
        return Response.ok().entity(entity).build();
    }


}
