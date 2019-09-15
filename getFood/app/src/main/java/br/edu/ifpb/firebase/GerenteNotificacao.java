/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.firebase;

import com.google.firebase.messaging.FirebaseMessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author alann
 */

@Path("tokenNotificacao")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GerenteNotificacao {

    @Inject
    Notificacao notificacao;

    @POST
    public Response addToken(String token) throws IOException, FirebaseMessagingException {
        
        //este token representa a app android que sera notificada
        // ele precisa ser armazenado para enviar uma messagem quando encerrar uma refeição
        String tokenParaSalvar = token.replace("\"", "");

        notificacao.getTokens().add(tokenParaSalvar);
        
        System.out.println("Token adicionado");
        
        return Response.ok()
                .entity(token)
                .build();
    }  
    
}
