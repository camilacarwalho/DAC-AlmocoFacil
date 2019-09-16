package br.edu.ifpb.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import br.edu.ifpb.dao.UsuarioDao;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.enums.UsuarioEnum;
import br.edu.ifpb.exceptions.DadosInvalidosException;

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
			return new Usuario();
		return usuarioLogado;
	}
	
	
	
	@Override
	public Usuario buscar(String matricula) {
		return usuarioDao.buscar(matricula);
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

	@Override
	public List<Usuario> buscarProfessores(int min, int quant,String matricula) {
		return usuarioDao.buscarProfessores(min,quant,matricula);
	}

	@Override
	public int quantProfessores(String matricula) {
		return usuarioDao.quantProfessores(matricula);
	}

	@Override
	public void editar(String nome, String telefone, String senha) throws DadosInvalidosException{
		if (!isLogado())
			return;
		if (nome == null || nome.length() < 4) throw new DadosInvalidosException("Nome inválido.");
		if (telefone == null || telefone.length() < 4) throw new DadosInvalidosException("Telefone inválido.");
		if (senha == null || senha.length() < 3) throw new DadosInvalidosException("Senha inválida.");
		Usuario usuario = getUsuarioLogado();
		usuario.getPessoa().setNome(nome);
		usuario.getPessoa().setTelefone(telefone);
		usuario.setSenha(senha);
		usuarioDao.atualizar(usuario);		
	}
	@Override
	public void desativar() {
		usuarioDao.remover(getUsuarioLogado());
		sair();
	}
	


}
