package br.edu.ifpb.controller;

import java.util.ArrayList;
import java.util.List;

public abstract class PaginacaoController<T> {
	
	private static final int ITENS_POR_PAGINA_DEFAULT = 6;
	
	private int paginaAtual;
	private int itensPorPagina;
	private int quantPaginas;
	private int quantItens;	
	
	protected abstract List<T> listarItensDaBusca(int inicio, int maximo);
	public abstract int getQuantidadeItens();	
	
	public PaginacaoController() {
		this.itensPorPagina = ITENS_POR_PAGINA_DEFAULT;
	}
	
	private void atualizarValores() {
		quantItens = getQuantidadeItens();
		Double tmpQtd = Double.valueOf(quantItens) / Double.valueOf(quantPaginas);
		tmpQtd = Math.ceil(tmpQtd);
		quantPaginas =  tmpQtd.intValue();
		setPaginaAtual(paginaAtual);
	}
	
	public List<T> buscarItens(){		
		int inicio = (paginaAtual -1) / itensPorPagina;	
		int termino = inicio + itensPorPagina - 1;
		return listarItensDaBusca(inicio, termino);
	}
	
	public List<Integer> getPaginas(){
		List<Integer> itens = new ArrayList<Integer>();
		for (int i = 1; i <= getQuantPaginas(); i++) {
			itens.add(i);			
		}
		return itens;
	}
	
	public int getPaginaAtual() {return paginaAtual;}
	public void setPaginaAtual(int paginaAtual) {		
		this.paginaAtual = (paginaAtual>0)?paginaAtual:1;
		this.paginaAtual = (paginaAtual <= quantPaginas)?paginaAtual:quantPaginas;
	}
	public int getItensPorPagina() {return itensPorPagina;}	
	public void setItensPorPagina(int itensPorPagina) {	this.itensPorPagina = itensPorPagina;}
	public int getQuantPaginas() {
		atualizarValores();		
		return quantPaginas;
	}
	
	public int getQuantItens() {return quantItens;}

}
