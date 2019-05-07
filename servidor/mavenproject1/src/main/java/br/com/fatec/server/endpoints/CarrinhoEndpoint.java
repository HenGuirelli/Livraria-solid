package br.com.fatec.server.endpoints;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.produto.Livro;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("carrinho")
public class CarrinhoEndpoint {

    private br.com.fatec.controller.CarrinhoController controller = new br.com.fatec.controller.CarrinhoController();

    @POST
    @Path("adicionar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultEndpoint addItem(CarrinhoRequest body) {
        Cliente cliente = ClienteDAO.getInstance().getCliente(body.getCliente());
        List<Livro> livros = LivroDAO.getInstance().getLivroPorNome(body.getLivro());

        if (livros != null && livros.size() > 0) {
            Livro livro = livros.get(0);
            controller.add(cliente, livro);
            return ResultEndpoint.getSucesso();
        } else {
            ResultEndpoint result = new ResultEndpoint();
            result.setSuccess(false);
            result.setMensagem("Livro de nome " + body.getLivro() + " não encontrado");
            return result;
        }
    }

    @GET
    @Path("procurar/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Carrinho getCarrinho(@PathParam("cliente") String clienteLogin) {
        Cliente cliente = ClienteDAO.getInstance().getCliente(clienteLogin);
        if (cliente == null) {
            return new Carrinho();
        }
        return cliente.getCarrinho();
    }

    @PUT
    @Path("/alterar/quantidade")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultEndpoint alterarQuantidade(AlterarQuantidadeRequest body) {
        Cliente cliente = ClienteDAO.getInstance().getCliente(body.getCliente());
        Livro produto = LivroDAO.getInstance().getLivroPorNome(body.getProduto()).get(0);
        controller.alterarQuantidade(cliente, produto, body.getQuantidade());
        return ResultEndpoint.getSucesso();
    }

    @PUT
    @Path("remover")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultEndpoint removerItem(RemoverItemRequest body) {
        try {
            Cliente cliente = ClienteDAO.getInstance().getCliente(body.getCliente());
            Livro produto = LivroDAO.getInstance().getLivroPorNome(body.getProduto()).get(0);
            controller.remover(cliente, produto);
            return ResultEndpoint.getSucesso();
        } catch (Exception ex) {
            ResultEndpoint processo = new ResultEndpoint();
            processo.setSuccess(false);
            processo.setMensagem(ex.getMessage());
            return processo;
        }
    }

}

class RemoverItemRequest {

    private String cliente;
    private String produto;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}

class AlterarQuantidadeRequest {

    private String cliente;
    private String produto;
    private int quantidade;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

class CarrinhoRequest {

    private String cliente;
    private String livro;

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
