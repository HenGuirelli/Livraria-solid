package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
        Cliente cliente = new ClienteController().getCliente(request.getCliente());

        ResultProcesso processo = new ResultProcesso();

        try {
            Pedido pedido = controller.vender(cliente.getCarrinho(), cliente);
            processo.setSuccess(true);
            processo.setMensagem("código do pedido: " + pedido.getCodigo());

            // esvazia o carrinho
            cliente.getCarrinho().esvaziar();
            return processo;
        } catch (Exception ex) {
            processo.setSuccess(false);
            processo.setMensagem(ex.getMessage());
            return processo;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("vender/livro")
    public ResultProcesso vender(VendaLivroRequest request) {
        ResultProcesso result = new ResultProcesso();

        Cliente c = ClienteDAO.getInstance().getCliente(request.getCliente());
        List<Livro> l = LivroDAO.getInstance().getLivroPorNome(request.getLivro());

        if (l == null || l.isEmpty()) {
            result.setSuccess(false);
            result.setMensagem("Livro não encontrado");
            return result;
        }

        Pedido pedido = controller.vender(l.get(0), c, request.getQuantidade());
        result.setSuccess(true);
        result.setMensagem("código do pedido: " + pedido.getCodigo());
        return result;
    }
}

class VendaLivroRequest {

    private String cliente;
    private String livro;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
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
