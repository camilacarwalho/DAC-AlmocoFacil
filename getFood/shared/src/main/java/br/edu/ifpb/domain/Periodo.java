package br.edu.ifpb.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@SuppressWarnings("serial")
@Entity
public class Periodo implements Serializable{

    @Id
    @Column(length = 10)
    private String codigo;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private int periodo;
    @Column(nullable = false)
    private LocalDate dataInicio;
    @Column(nullable = false)
    private LocalDate dataFinal;

    public Periodo() {
    }

	public Periodo(String codigo, int ano, int periodo, LocalDate dataInicio, LocalDate dataFinal) {
		super();
		this.codigo = codigo;
		this.ano = ano;
		this.periodo = periodo;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Periodo other = (Periodo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
    
}
