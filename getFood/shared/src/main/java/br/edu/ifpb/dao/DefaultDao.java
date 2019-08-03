package br.edu.ifpb.dao;

import java.util.List;

public interface DefaultDao <T> {
	
	void salvar(T object);
	void remover(T object);
	void atualizar(T object);
	T buscar(Object key);
	List<T> listar();
	

}
