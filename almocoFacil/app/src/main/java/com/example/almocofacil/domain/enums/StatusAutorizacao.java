package com.example.almocofacil.domain.enums;

public enum StatusAutorizacao {
	
	PENDENTE("Pendente"),
	REALIZADA("Realizada"),
	AUSENTE("Ausente"),
	RENUNCIADA("Renunciada"),
	NEGADA("Negada");
	
	private String nome;
	
	private StatusAutorizacao(String nome) {this.nome = nome;}
	public String getNome() {return nome;}

}
