package br.edu.ifpb.domain.enums;

public enum TurnoCurso {

    INTEGRAL("Integral"),
    NOTURNO("Noturno");
	private String nome;
	private TurnoCurso(String nome) {this.nome = nome;}
	public String getNome() {return nome;}
}
