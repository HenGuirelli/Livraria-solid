package br.com.fatec.controller;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.enums.FormaPagamento;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.produto.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;

public class VendaController {
    private DescontoController descontoController = new DescontoController();
    
    public Pedido vender(Livro livro, Cliente cliente, FormaPagamento formaPagamento, int quantidade) {
        PedidoDAO dao = PedidoDAO.getInstance();
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(livro);
        
        livro.vender(cliente, quantidade);
        
        Pedido pedido = new Pedido();
        pedido.addProduto(item);
        pedido.setCliente(cliente.getLogin());        
        cliente.addPedido(pedido);
        cliente.addPontos(5);
        dao.add(pedido);
        
        descontoController.aplicarDesconto(pedido);
                
        return pedido;
    }
    
    public Pedido vender(Carrinho carrinho, FormaPagamento formaPagamento, Cliente cliente) {
        
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (cliente.getCarrinho().totalItensCarrinho() == 0) {
            throw new RuntimeException("Carrinho vazio");
        }
        
        PedidoDAO dao = PedidoDAO.getInstance();
        Pedido pedido = new Pedido();
        for (ItemCarrinho item : carrinho.getItens()) {
            item.getProduto().vender(cliente, item.getQuantidade());
            pedido.addProduto(item);
            pedido.setCliente(cliente.getLogin());
            pedido.setValorTotal(pedido.getValorTotal() + item.getValor());
        }
        cliente.addPedido(pedido);
        dao.add(pedido);
        
        
        pedido.setFormaPagamento(formaPagamento);
        pedido = descontoController.aplicarDesconto(pedido);
        cliente.setPontos(5);
        
        return pedido;
    }
}
