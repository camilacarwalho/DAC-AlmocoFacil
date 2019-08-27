package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.service.AlunoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class GestaoAlunoController extends PaginacaoController<Aluno> implements Serializable {

    @Inject
    AlunoService alunoService;

    @PostConstruct
    public void init(){
        buscar();
    }

    @Override
    protected List<Aluno> listarItensDaBusca(int inicio, int maximo) {
        return alunoService.buscarAlunos(inicio,maximo);
    }

    @Override
    public int getQuantidadeItens() {
        return alunoService.quantAlunos();
    }
}
