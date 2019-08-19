package br.edu.ifpb.service;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.UsuarioEnum;
import br.edu.ifpb.exceptions.DadosInvalidosException;

public interface UsuarioService {

	boolean isLogado();
	Usuario getUsuarioLogado();
	Usuario logar(String matricula, String senha);
	void logout();
	void editar(String nome, String telefone, String senha) throws DadosInvalidosException;
	UsuarioEnum getUsuarioEnum();

}
