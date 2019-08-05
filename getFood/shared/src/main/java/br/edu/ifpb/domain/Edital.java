package br.edu.ifpb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Edital implements Serializable {
    
    @Id
    private  String codigo;
    private Periodo periodo;

    public Edital() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edital edital = (Edital) o;
        return Objects.equals(codigo, edital.codigo) &&
                Objects.equals(periodo, edital.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, periodo);
    }
}
