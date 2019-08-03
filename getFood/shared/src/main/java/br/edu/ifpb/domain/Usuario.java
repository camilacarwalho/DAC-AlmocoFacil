package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.UsuarioEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable {

    @Id
    private String matricula;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private UsuarioEnum cargo;

    @ManyToOne
    @JoinColumn(name = "pessoa_cpf")
    private Pessoa pessoa;

    public Usuario() {
    }

    public Usuario(String matricula, String senha, UsuarioEnum cargo,Pessoa pessoa) {
        this.matricula = matricula;
        this.senha = senha;
        this.cargo = cargo;
        this.pessoa=pessoa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioEnum getCargo() {
        return cargo;
    }

    public void setCargo(UsuarioEnum cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(matricula, usuario.matricula) &&
                Objects.equals(senha, usuario.senha) &&
                cargo == usuario.cargo &&
                Objects.equals(pessoa, usuario.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, senha, cargo, pessoa);
    }
}

