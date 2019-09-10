package br.edu.ifpb.service.util;


import br.edu.ifpb.dao.AlunoDao;
import br.edu.ifpb.dao.CursoDao;
import br.edu.ifpb.dao.PeriodoDao;
import br.edu.ifpb.domain.Aluno;
import br.edu.ifpb.domain.Curso;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.enums.UsuarioEnum;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Stateless
public class CSV {

    @EJB
    private AlunoDao alunoDao;

    @EJB
    private CursoDao cursoDao;

    @EJB
    private PeriodoDao periodoDao;

    private final static String separator = ",";

    public void AlunoCsvToObject(Part file) throws IOException {
        if(!(file.getContentType().equals("text/csv"))){
            throw new IOException("Objeto CSV Invalido");
        }
        Scanner scanner = new Scanner(file.getInputStream(),"UTF-8");
        scanner.useDelimiter(separator);
        while(scanner.hasNext()){
            String linha = scanner.nextLine();
            if(linha!=null && !linha.trim().isEmpty()){
                linha = linha.replaceAll("\"","");
                System.out.println(linha);
                String[] dados = linha.split("\\,");
                Aluno aluno = construirAluno(dados);
                alunoDao.salvar(aluno);
            }
        }

    }

    private Aluno construirAluno(String[] dados){
        Aluno aluno = new Aluno();
        Pessoa pessoa = new Pessoa(dados[0],dados[1],dados[2],new ArrayList<>());
        aluno.setPessoa(pessoa);
        aluno.setMatricula(dados[3]);
        aluno.setCargo(UsuarioEnum.ALUNO);
        aluno.setSenha(aluno.getPessoa().getCpf());
        aluno.setCurso(cursoDao.buscar(dados[4]));
        aluno.setPeriodoIngresso(periodoDao.buscar(dados[5]));
        return aluno;
    }
}
