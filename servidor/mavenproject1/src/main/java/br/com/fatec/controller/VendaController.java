package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.enums.FormaPagamento;
import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.pagamento.AVista;
import br.com.fatec.model.pagamento.FidelidadeDecorator;
import br.com.fatec.model.pagamento.Pagamento;
import br.com.fatec.model.pagamento.Parcelado;
import br.com.fatec.model.pagamento.PromocaoDecorator;
import br.com.fatec.model.produto.Livro;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.produto.Filme;
import br.com.fatec.model.produto.Vendavel;
import br.com.fatec.model.produto.Produto;
import br.com.fatec.model.usuario.Cliente;

public class VendaController {

    private DescontoController descontoController = new DescontoController();

   /* public Pedido vender(Livro livro, Cliente cliente, FormaPagamento formaPagamento, int quantidade) {
        PedidoDAO dao = PedidoDAO.getInstance();
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(livro);

        livro.vender(quantidade);

        Pedido pedido = new Pedido();
        pedido.addProduto(item);
        pedido.setCliente(cliente.getLogin());
        cliente.addPedido(pedido);
        dao.add(pedido);

        descontoController.aplicarDesconto(pedido);

        cliente.addPontos(5);
        // atualiza no banco de dados
        LivroDAO livroDAO = LivroDAO.getInstance();
        livroDAO.atualizarQuantidade(livro, livro.getQuantidade());

        return pedido;
    }

    public Pedido vender(Filme filme, Cliente cliente, FormaPagamento formaPagamento, int quantidade) {
        PedidoDAO dao = PedidoDAO.getInstance();
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(filme);

        filme.vender(quantidade);

        Pedido pedido = new Pedido();
        pedido.addProduto(item);
        pedido.setCliente(cliente.getLogin());
        cliente.addPedido(pedido);
        dao.add(pedido);

        descontoController.aplicarDesconto(pedido);

        cliente.addPontos(5);
        // atualiza no banco de dados
        FilmeDAO filmeDAO = FilmeDAO.getInstance();
        filmeDAO.atualizarQuantidade(filme, filme.getQuantidade());

        return pedido;
    }*/

    public Pedido vender(Vendavel vendavel, Cliente cliente, FormaPagamento formaPagamento, int quantidade) {
        PedidoDAO dao = PedidoDAO.getInstance();
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(vendavel);

        vendavel.vender(quantidade);

        Pedido pedido = new Pedido();
        pedido.addProduto(item);
        pedido.setCliente(cliente.getLogin());
        cliente.addPedido(pedido);
        dao.add(pedido);

        //descontoController.aplicarDesconto(pedido);
        float desconto = 0;
        if (formaPagamento == FormaPagamento.A_VISTA){
            Pagamento pagamento = new PromocaoDecorator(
                    new FidelidadeDecorator(new AVista(), cliente), (Produto) vendavel);
            desconto = pagamento.calcularDesconto();
        }else {
            Pagamento pagamento = new PromocaoDecorator(
                    new FidelidadeDecorator(new Parcelado(), cliente), (Produto) vendavel);
            desconto = pagamento.calcularDesconto();            
        }
        pedido.setDesconto(desconto);
        cliente.addPontos(5);
        persistir(vendavel, quantidade);
        
        
        return pedido;
    }
    
    private void persistir(Vendavel negociavel, int quantidade){
        if (negociavel instanceof Filme){
            FilmeDAO filmeDAO = FilmeDAO.getInstance();
            filmeDAO.atualizarQuantidade((Filme) negociavel,  quantidade);
        }else if (negociavel instanceof Livro){
            LivroDAO livroDAO = LivroDAO.getInstance();
            livroDAO.atualizarQuantidade((Livro) negociavel, quantidade);
        }
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
            Vendavel vendavel = item.getProduto();
            vendavel.vender(item.getQuantidade());
            
            pedido.addProduto(item);
            pedido.setCliente(cliente.getLogin());
            pedido.setValorTotal(pedido.getValorTotal() + item.getValor());
            
            float desconto = 0;
            if (formaPagamento == FormaPagamento.A_VISTA){
                Pagamento pagamento = new PromocaoDecorator(
                        new FidelidadeDecorator(new AVista(), cliente), (Produto) vendavel);
                desconto = pagamento.calcularDesconto();
            }else {
                Pagamento pagamento = new PromocaoDecorator(
                        new FidelidadeDecorator(new Parcelado(), cliente), (Produto) vendavel);
                desconto = pagamento.calcularDesconto();            
            }
            pedido.setDesconto(desconto);
        }
        cliente.addPedido(pedido);
        dao.add(pedido);

        pedido.setFormaPagamento(formaPagamento);
        pedido = descontoController.aplicarDesconto(pedido);

        return pedido;
    }
}
