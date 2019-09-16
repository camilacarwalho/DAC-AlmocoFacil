package br.edu.ifpb.api;

import br.edu.ifpb.domain.AutorizacaoRR;
import br.edu.ifpb.domain.AutorizacaoRRJersey;
import br.edu.ifpb.domain.IntervaloDatas;
import br.edu.ifpb.domain.RelatorioRefeicoes;
import br.edu.ifpb.service.AutorizacaoService;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Path("gestores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResourcesGestor {

    @Inject
    AutorizacaoService service;

//    @POST
//    public Response listarTodos(){
//        List<AutorizacaoRR> todos = this.service.listarAutorizacaoRRApi(null,null);
//
//        GenericEntity<List<AutorizacaoRR>> entity = new  GenericEntity<List<AutorizacaoRR>>(todos){};
//        return Response.ok().entity(entity).build();
//    }
    
    @POST
    public Response listarPorData(IntervaloDatas intervaloDatas) {

        System.out.print("Os datas de formulario chegaram");
        System.out.print(intervaloDatas.toString());

        String dataInicial = intervaloDatas.getDataInicial();
        String dataFinal = intervaloDatas.getDataFinal();

        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dateInicio = LocalDate.parse(dataInicial, formato);
        LocalDate dateFim = LocalDate.parse(dataFinal, formato);
        
        List<AutorizacaoRR> todos = this.service.listarAutorizacaoRRApi(dateInicio, dateFim);
        
        RelatorioRefeicoes relatorioRefeicoes = new RelatorioRefeicoes();
        relatorioRefeicoes.setListRefeicoes(convertLocalDate(todos));
        GenericEntity<List<AutorizacaoRR>> entity = new GenericEntity<List<AutorizacaoRR>>(todos) {
        };
        return Response.ok().entity(relatorioRefeicoes).build();
    }

    private List<AutorizacaoRRJersey> convertLocalDate(List<AutorizacaoRR> lista) {

        List<AutorizacaoRRJersey> novaLista = new ArrayList();
        
        for (int k = 0; k < lista.size(); k++) {
            
            AutorizacaoRRJersey aj = new AutorizacaoRRJersey();
            aj.setData(lista.get(k).getData().toString());
            aj.setNome(lista.get(k).getNome());
            aj.setQuantidade(lista.get(k).getQuantidade());
            aj.setStatusAutorizacao(lista.get(k).getStatusAutorizacao());
            
            novaLista.add(aj);

        }
        
        return novaLista;
    }

}
