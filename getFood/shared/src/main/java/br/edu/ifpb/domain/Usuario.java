package br.edu.ifpb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ifpb.domain.enums.UsuarioEnum;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements Serializable {

    @Id
    @Column(length=20)
    private String matricula;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
   
}

