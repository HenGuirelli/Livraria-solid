package br.com.fatec.server.controllers;

import br.com.fatec.DAO.FornecedorDAO;
import br.com.fatec.model.fornecedor.Fornecedor;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("compra")
public class CompraController {
    private br.com.fatec.controller.CompraController controller = new br.com.fatec.controller.CompraController();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultProcesso comprarProduto(ComprarProdutoBody body) {
        try {
            controller.comprar(body.getNomeProduto(), body.getQuantidade());
            return ResultProcesso.getSucesso();
        }catch(Exception ex){
            return ResultProcesso.getFalha(ex.getMessage());
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("fornecedores")
    public List<Fornecedor> getFornecedores(){
        List<Fornecedor> resp = FornecedorDAO.getInstance().getTodosFornecedores();
        return resp;
    }
}

class ComprarProdutoBody {
    private String nomeProduto;
    private int quantidade;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
