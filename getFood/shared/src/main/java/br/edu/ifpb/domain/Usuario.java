package br.edu.ifpb.domain;

import br.edu.ifpb.domain.enums.UsuarioEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Usuario implements Serializable {

    @Id
    private String matricula;
    private String senha;
    private UsuarioEnum cargo;

    public Usuario() {
    }

    public Usuario(String matricula, String senha, UsuarioEnum cargo) {
        this.matricula = matricula;
        this.senha = senha;
        this.cargo = cargo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(matricula, usuario.matricula) &&
                Objects.equals(senha, usuario.senha) &&
                cargo == usuario.cargo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, senha, cargo);
    }
}

