package br.edu.ifpb.service;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.UsuarioEnum;

public interface UsuarioService {

	boolean isLogado();
	Usuario getUsuarioLogado();
	Usuario logar(String matricula, String senha);
	void logoff();
	UsuarioEnum getUsuarioEnum();

}
