package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.service.AlunoService;
import br.edu.ifpb.service.util.CSV;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class GestaoAlunoController extends PaginacaoController<Aluno> implements Serializable {

    @Inject
    AlunoService alunoService;
    String matricula;

    @Inject
    CSV csv;

    private Part arquivoCsv;

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

    private byte[] toByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int reads = is.read();
        while (reads != -1) {
            baos.write(reads);
            reads = is.read();
        }
            return baos.toByteArray();
    }

    public String salvarViaCsv(){
        try {
            csv.AlunoCsvToObject(this.arquivoCsv);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public Part getArquivoCsv() {
        return arquivoCsv;
    }

    public void setArquivoCsv(Part arquivoCsv) {
        this.arquivoCsv = arquivoCsv;
    }
}
