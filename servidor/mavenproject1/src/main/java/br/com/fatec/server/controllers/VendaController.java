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
    @Path("vender/carrinho")
    public ResultProcesso vender(VendaCarrinhoRequest request) {
        Cliente cliente = ClienteDAO.getInstance().getCliente(request.getCliente());

        ResultProcesso processo = new ResultProcesso();

        try {
            Pedido pedido = controller.vender(cliente.getCarrinho(), cliente);
            processo.setSuccess(true);
            processo.setMensagem("código do pedido: " + pedido.getCodigo());

            // esvazia o carrinho
            cliente.getCarrinho().esvaziar();
            return processo;
        }catch (Exception ex){
            processo.setSuccess(false);
            processo.setMensagem(ex.getMessage());
            return processo;
        }
    }
}

class VendaCarrinhoRequest {

    private String cliente;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
