package br.com.fatec.server.controllers;

import javax.ws.rs.Path;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("conta")
public class ContaController {
    private final br.com.fatec.controller.ContaController controller = new br.com.fatec.controller.ContaController();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public ResultProcesso logar(br.com.fatec.model.usuario.Usuario usuario){
        ResultProcesso result = new ResultProcesso();
        result.setSuccess(controller.logar(usuario.getLogin(), usuario.getSenha()));
        return result;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastro")
    public ResultProcesso criarConta(br.com.fatec.model.usuario.Cliente usuario){
        System.out.println(usuario.getLogin() + " " + usuario.getSenha());
        
        controller.criarConta(usuario.getLogin(), usuario.getSenha(), usuario.getNome());
        
        ResultProcesso result = new ResultProcesso();
        result.setSuccess(true);
        return result;
    }
}
