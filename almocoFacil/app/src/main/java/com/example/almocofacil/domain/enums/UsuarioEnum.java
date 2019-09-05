package com.example.almocofacil.domain.enums;

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


    public enum NivelCurso {
        INTEGRADO("Integrado"),
        SUBSEQUENTE("Subserquente"),
        GRADUACAO("Graduação"),
        POSGRADUACAO("Pós-graduação");

        private String nome;

        private NivelCurso(String nome) {this.nome = nome;}
        public String getNome() {return nome;}

    }
}
