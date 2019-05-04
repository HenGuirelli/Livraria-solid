package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("carrinho")
public class CarrinhoController {
    private br.com.fatec.controller.CarrinhoController controller = new br.com.fatec.controller.CarrinhoController();
    
    @POST
    @Path("adicionar/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultProcesso addItem(@PathParam("cliente") String login, Livro livro){        
        Cliente cliente = ClienteDAO.getInstance().getCliente(login);

        controller.add(cliente, livro);
        return ResultProcesso.getSucesso();
    }
    
    @GET
    @Path("procurar/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrinho getCarrinho(@PathParam("cliente") String clienteLogin){
        Cliente cliente = ClienteDAO.getInstance().getCliente(clienteLogin);
        if (cliente == null)
            return new Carrinho();
        return cliente.getCarrinho();
    }
}
