package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.service.AlunoService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class GestaoAlunoController extends PaginacaoController<Aluno> implements Serializable {

    @Inject
    AlunoService alunoService;
    String matricula;

    @PostConstruct
    public void init(){
        buscar();
    }

    @Override
    protected List<Aluno> listarItensDaBusca(int inicio, int maximo) {
        return alunoService.buscarAlunos(inicio,maximo,matricula);
    }

    @Override
    public int getQuantidadeItens() {
        return alunoService.quantAlunos(matricula);
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }

    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
