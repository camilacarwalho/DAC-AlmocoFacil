package com.example.almocofacil.domain;

import java.io.Serializable;

public class RequisicaoMatricula implements Serializable {

    private int requisicaoId;
    private String matricula;

    public RequisicaoMatricula() {}

    public RequisicaoMatricula(int requisicaoId, String matricula) {
        this.requisicaoId = requisicaoId;
        this.matricula = matricula;
    }

    public int getRequisicaoId() {return requisicaoId;}
    public void setRequisicaoId(int requisicaoId) {this.requisicaoId = requisicaoId;}
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
}
