package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("venda")
public class VendaController {
    private br.com.fatec.controller.VendaController controller = new br.com.fatec.controller.VendaController();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("vender")
    public ResultProcesso vender(VendaRequest venda){
        ClienteDAO dao = ClienteDAO.getInstance();
        
        ResultProcesso processo = new ResultProcesso();
        
        processo.setSuccess(true);
        Pedido pedido = controller.vender(venda.getLivro(), venda.getCliente(), venda.getQuantidade());
        processo.setMensagem("código do pedido: " + pedido.getCodigo());
        
        return processo;
    }
}


class VendaRequest {
    private Cliente cliente;
    private int quantidade;
    private Livro livro;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
