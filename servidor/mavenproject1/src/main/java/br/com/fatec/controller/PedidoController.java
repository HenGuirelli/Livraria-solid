package br.com.fatec.controller;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.Consumivel;
import br.com.fatec.model.Embalagem;
import br.com.fatec.model.pedido.Pedido;
import java.util.List;

public class PedidoController {
    public List<Pedido> listar(){
        PedidoDAO dao = PedidoDAO.getInstance();
        return dao.pegarTodos();
    }
    
    public List<Pedido> pegarPedidosEmAtendimento() {
        PedidoDAO dao = PedidoDAO.getInstance();
        return dao.pegarPedidosEmAtendimento();
    }

    public List<Pedido> pegarPedidosEnviados() {
        PedidoDAO dao = PedidoDAO.getInstance();
        return dao.pegarPedidosEnviados();
    }

    public List<Pedido> pegarPedidosEntregue() {
        PedidoDAO dao = PedidoDAO.getInstance();
        return dao.pegarPedidosEntregue();
    }
    
    private void alterarEstadoPedido(String codigo, EstadoPedido estado){
        PedidoDAO dao = PedidoDAO.getInstance();
        dao.alterarEstado(dao.buscarPedidoPorCodigo(codigo), estado);
    }
    
    public void alterarEstadoPedidoEnviado(String codigo){
        Pedido pedido = PedidoDAO.getInstance().buscarPedidoPorCodigo(codigo);
        
        int quantidadeProdutos = pedido.getProdutos().size();
        int quantidadeEmbalagem = Embalagem.getInstance().getQuantidade();
        
        if (quantidadeProdutos > quantidadeEmbalagem){
            throw new RuntimeException("Quantidade de embalagem insuficiente");
        }
        
        Consumivel consumivel = Embalagem.getInstance();
        consumivel.consumir(quantidadeProdutos);
        
        alterarEstadoPedido(codigo, EstadoPedido.enviado);
    }
    
    public void alterarEstadoPedidoEntregue(String codigo){
        alterarEstadoPedido(codigo, EstadoPedido.entregue);
    }
    
    public void alterarEstadoPedidoEmAtendimento(String codigo){
        alterarEstadoPedido(codigo, EstadoPedido.emAtendimento);
    }
}
