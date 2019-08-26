package br.edu.ifpb.controller.filters;

import br.edu.ifpb.controller.UsuarioController;
import br.edu.ifpb.domain.Usuario;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoggedFilter",urlPatterns = {"/index.xhtml","/login.xhtml"})
public class LoggedFilter implements Filter {

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
        if(logado.getMatricula()!=null){
            res.sendRedirect(req.getContextPath()+"/"+logado.getCargo().getIdentificador());
        }else{
            chain.doFilter(req,res);
        }
    }

    @Override
    public void destroy() {

    }
}
