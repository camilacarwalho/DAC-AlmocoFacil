package br.edu.ifpb.service.resouces;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.domain.resource.UsuarioRest;

public class ConvertObjectRest {
	
	public static UsuarioRest usuarioParaRest(Usuario usuario) {
		
		if(usuario == null || usuario.getPessoa() == null) 
			return new UsuarioRest();
		
		return new UsuarioRest(
				usuario.getMatricula(), 
				"", 
				usuario.getCargo(), 
				usuario.getPessoa().getCpf(), 
				usuario.getPessoa().getNome(),
				usuario.getPessoa().getTelefone());			
	}
}
