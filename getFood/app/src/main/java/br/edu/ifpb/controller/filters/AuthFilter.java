package br.edu.ifpb.controller.filters;

import br.edu.ifpb.controller.UsuarioController;
import br.edu.ifpb.domain.Usuario;
import br.edu.ifpb.service.UsuarioService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/caest/*","/gestor/*","/professor/*","/refeitorio/*"})
public class AuthFilter implements Filter {

    @Inject
    private UsuarioController usuarioController;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Usuario logado = usuarioController.getUsuario();
        if(logado.getMatricula()==null){
            res.sendRedirect("http://localhost:8080/app/index.xhtml");
        }else{
            res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            res.setHeader("Pragma", "no-cache");
            res.setDateHeader("Expires", 0);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
