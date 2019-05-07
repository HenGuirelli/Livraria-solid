package br.com.fatec.server.endpoints;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.enums.FormaPagamento;
import br.com.fatec.model.produto.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import br.com.fatec.model.usuario.DadosPagamento;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("venda")
public class VendaEndpoint {

    private br.com.fatec.controller.VendaController controller = new br.com.fatec.controller.VendaController();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("vender/carrinho")
    public ResultEndpoint vender(VendaCarrinhoRequest request) {
        Cliente cliente = new ClienteEndpoint().getCliente(request.getCliente());

        try {
            Pedido pedido = controller.vender(
                    cliente.getCarrinho(),
                    FormaPagamento.convert(request.getFormaPagamento()), 
                    cliente);
            

            // esvazia o carrinho
            cliente.getCarrinho().esvaziar();
            return ResultEndpoint.getSucesso("Código do pedido: " + pedido.getCodigo() + " valor descontado: " + pedido.getDesconto());
        } catch (Exception ex) {
            return ResultEndpoint.getFalha(ex.getMessage());
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("vender/produto")
    public ResultEndpoint vender(VendaLivroRequest request) {
        ResultEndpoint result = new ResultEndpoint();

        Cliente c = ClienteDAO.getInstance().getCliente(request.getCliente());
        List<Livro> l = LivroDAO.getInstance().getLivroPorNome(request.getLivro());

        c.setDadosPagamento(request.getDadosPagamento());
        
        if (l == null || l.isEmpty()) {
            result.setSuccess(false);
            result.setMensagem("Livro não encontrado");
            return result;
        }        

        Pedido pedido = controller.vender(
                l.get(0), 
                c, 
                FormaPagamento.convert(request.getFormaPagamento()), 
                request.getQuantidade());
        
        result.setSuccess(true);
        result.setMensagem("Código do pedido: " + pedido.getCodigo() + " valor descontado: " + pedido.getDesconto());
        return result;
    }
}

class VendaLivroRequest {

    private String cliente;
    private String livro;
    private int quantidade;
    private DadosPagamento dadosPagamento;
    private String formaPagamento;
    private float valor;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
    
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
    private DadosPagamento dadosPagamento;
    private String formaPagamento;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
