package br.edu.ifpb.domain.enums;

public enum NivelCurso {
    INTEGRADO("Integrado"),
    SUBSEQUENTE("Subserquente"),
    GRADUACAO("Graduação"),
    POSGRADUACAO("Pós-graduação");
	
	private String nome;
	
	private NivelCurso(String nome) {this.nome = nome;}
	public String getNome() {return nome;}
	
}
