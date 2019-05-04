package br.com.fatec.controller;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;

public class VendaController {
    
    public Pedido vender(Livro livro, Cliente cliente, int quantidade) {
        PedidoDAO dao = PedidoDAO.getInstance();
        livro.vender(cliente, quantidade);
        
        Pedido pedido = new Pedido();
        pedido.addLivro(livro);
        pedido.setCliente(cliente.getLogin());        
        cliente.addPedido(pedido);
        dao.add(pedido);
        
        return pedido;
    }
    
    public Pedido vender(Carrinho carrinho, Cliente cliente) {
        
        if (cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }

        if (cliente.getCarrinho().totalItensCarrinho() == 0) {
            throw new RuntimeException("Carrinho vazio");
        }
        
        PedidoDAO dao = PedidoDAO.getInstance();
        Pedido pedido = new Pedido();
        for (ItemCarrinho item : carrinho.getItens()) {
            item.getLivro().vender(cliente, item.getQuantidade());
            pedido.addLivro(item.getLivro());
            pedido.setCliente(cliente.getLogin());
        }            
        cliente.addPedido(pedido);
        dao.add(pedido);
        return pedido;
    }
}
