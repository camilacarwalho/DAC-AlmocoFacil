package br.edu.ifpb.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Periodo {

    @Id
    private String codigo;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private int periodo;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    public Periodo() {
    }

    public Periodo(String codigo, int ano, int periodo, Date dataInicio, Date dataFinal) {
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo1 = (Periodo) o;
        return ano == periodo1.ano &&
                periodo == periodo1.periodo &&
                Objects.equals(codigo, periodo1.codigo) &&
                Objects.equals(dataInicio, periodo1.dataInicio) &&
                Objects.equals(dataFinal, periodo1.dataFinal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, ano, periodo, dataInicio, dataFinal);
    }
}
