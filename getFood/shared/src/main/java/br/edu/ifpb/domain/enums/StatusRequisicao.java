package br.edu.ifpb.domain.enums;

public enum StatusRequisicao {
	PENDENTE("Pendente"),
	AUTORIZADA("Autorizada"),
	NEGADA("Negada"),
	COMPULSORIA("Compulsória"),
	PARCIAL("Parcialmente atendida");
	
	private String nome;
	
	private StatusRequisicao(String nome) {this.nome = nome;}
	public String getNome() { return nome;}
	

}
