package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cliente")
public class ClienteController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes(){
        ClienteDAO dao = ClienteDAO.getInstance();
        return dao.getClientes();
    }
    
    @GET
    @Path("{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("cliente") String login){
        ClienteDAO dao = ClienteDAO.getInstance();
        return dao.getCliente(login);
    }
}
