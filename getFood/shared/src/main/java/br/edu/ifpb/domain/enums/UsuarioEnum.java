package br.edu.ifpb.domain.enums;

public enum UsuarioEnum {
	DEFAULT("Sem usuário conectado","default"),
    PROFESSOR("Professor","professor"),
    CAEST("Gestor da CAEST","caest"),
    GESTOR("Gestor Administrativo","gestor"),
    ALUNO("Aluno","aluno"),
    REFEITORIO("Refeitório","refeitorio");
    private String nome;
	private String identificador;
	private UsuarioEnum(String nome, String identificador) {
		this.nome = nome;
		this.identificador = identificador;
	}
	public String getNome() {return nome;}
	public String getIdentificador() {return identificador;}
	
    
    
}
