package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
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
    @Path("adicionar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultProcesso addItem(CarrinhoRequest request){        
        Cliente cliente = ClienteDAO.getInstance().getCliente(request.getCliente());
        List<Livro> livros = LivroDAO.getInstance().getLivroPorNome(request.getLivro());
        
        if (livros != null && livros.size() > 0){
            Livro livro = livros.get(0);
            controller.add(cliente, livro);
            return ResultProcesso.getSucesso();
        }else{
            ResultProcesso result = new ResultProcesso();
            result.setSuccess(false);
            result.setMensagem("Livro de nome " + request.getLivro()+ " não encontrado");
            return result;
        }
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