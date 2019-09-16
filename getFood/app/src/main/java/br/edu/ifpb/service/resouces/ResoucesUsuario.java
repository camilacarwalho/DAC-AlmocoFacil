package br.edu.ifpb.service.resouces;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.service.UsuarioService;
import br.edu.ifpb.service.resouces.convert.ConvertObjectRest;

@Stateless
@Path("usuario")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class ResoucesUsuario {
	
	@Inject
	private UsuarioService usuarioService;
	
	@POST
	@Path("login")
	public Response logar(JsonObject object) {
		String matricula = object.getString("matricula");
		String senha = object.getString("senha");
		Usuario usuario = usuarioService.logar(matricula, senha);
		if (usuario == null) 
			return Response
					.ok()
					.entity(ConvertObjectRest.usuarioParaRest(usuario))
					.status(Status.UNAUTHORIZED)
					.build();		
		return Response			
				.ok()
				.entity(ConvertObjectRest.usuarioParaRest(usuario))
				.build();
	}

}
