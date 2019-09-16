package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.service.UsuarioService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class GestaoProfessorController extends PaginacaoController<Usuario> implements Serializable {

    @Inject
    UsuarioService usuarioService;

    private String matricula;

    @PostConstruct
    public void init(){
        buscar();
    }

    @Override
    protected List<Usuario> listarItensDaBusca(int inicio, int maximo) {
        return usuarioService.buscarProfessores(inicio,maximo,matricula);
    }

    @Override
    public int getQuantidadeItens() {
        return usuarioService.quantProfessores(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
