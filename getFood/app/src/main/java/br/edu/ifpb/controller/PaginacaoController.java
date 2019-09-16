package br.edu.ifpb.controller;

import java.util.ArrayList;
import java.util.List;

public abstract class PaginacaoController<T> {
	
	private static final int ITENS_POR_PAGINA_DEFAULT = 6;
	
	private int paginaAtual;
	private int itensPorPagina;
	private int quantPaginas;
	private int quantItens;
	private List<T> itens; 
	
	protected abstract List<T> listarItensDaBusca(int inicio, int maximo);
	public abstract int getQuantidadeItens();
	
	private void atualizarValores() {
		quantItens = getQuantidadeItens();
		Double tmpQtd = Double.valueOf(quantItens) / Double.valueOf(itensPorPagina);
		tmpQtd = Math.ceil(tmpQtd);
		quantPaginas =  tmpQtd.intValue();
		quantPaginas = quantPaginas < 1?1:quantPaginas; 
		setPaginaAtual(paginaAtual);
	}
	
	private List<T> buscarItens(){		
		atualizarValores();
		int inicio = (paginaAtual -1) * itensPorPagina;	
		int termino = itensPorPagina;
		return listarItensDaBusca(inicio, termino);
	}
	
	//Construtor
	public PaginacaoController() {
		this.itensPorPagina = ITENS_POR_PAGINA_DEFAULT;
		paginaAtual = 1;
		itens = new ArrayList<T>();
	}
	
	public String buscar() {
		itens = buscarItens();
		return "";
	}
	
	public String irParaPagina(int pag) {
		paginaAtual = pag;
		return buscar();
	}
	
	public List<Integer> getNumPaginas(){
		List<Integer> paginas = new ArrayList<>();
		for (int i = 1; i <= quantPaginas; i++) {
			paginas.add(i);			
		}
		return paginas;
	}
	
		
	public List<T> getItens() {return itens;}
	public int getPaginaAtual() {return paginaAtual;}
	public void setPaginaAtual(int paginaAtual) {		
		this.paginaAtual = (paginaAtual>0)?paginaAtual:1;
		this.paginaAtual = (paginaAtual <= quantPaginas)?paginaAtual:quantPaginas;
	}
	public int getItensPorPagina() {return itensPorPagina;}	
	public void setItensPorPagina(int itensPorPagina) {	this.itensPorPagina = itensPorPagina;}
	public int getQuantPaginas() {return quantPaginas;}
	public int getQuantItens() {return quantItens;}

}
