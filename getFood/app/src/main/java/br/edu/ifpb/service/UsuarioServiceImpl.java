package br.edu.ifpb.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.UsuarioEnum;

@Stateful
public class UsuarioServiceImpl implements Serializable, UsuarioService {
	
	private static final long serialVersionUID = -398404845773023301L;
	
	@EJB
	private UsuarioDao usuarioDao;
	private boolean estaLogado;
	private Usuario usuarioLogado;
	
	@PostConstruct
	private void init() {
		estaLogado = false;
	}
	private void sair() {
		usuarioLogado = null;
		estaLogado = false;
	}

	@Override
	public boolean isLogado() {		
		return estaLogado;
	}
	
	@Override
	public Usuario getUsuarioLogado() {
		if (!isLogado())
			return null;
		return usuarioLogado;
	}
	@Override
	public Usuario logar(String matricula, String senha) {
		sair();
		Usuario usuario = usuarioDao.buscar(matricula);
		if (usuario == null)
			return null;
		if(!usuario.getSenha().equals(senha))
			return null;
		usuarioLogado = usuario;
		estaLogado = usuario != null;
		return usuarioLogado;
	}

	@Override
	@Remove
	public void logout() {
		sair();	
	}
	@Override
	public UsuarioEnum getUsuarioEnum() {
		if(!isLogado() || getUsuarioLogado() == null)
			return UsuarioEnum.DEFAULT;
		return getUsuarioLogado().getCargo();
	}


}
