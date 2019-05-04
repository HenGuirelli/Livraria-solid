package br.com.fatec.DAO;

import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.pedido.Pedido;

public class PedidoDAO extends DAO<Pedido>{
    
    private static PedidoDAO instance;
    
    private PedidoDAO () {}
    
    public static PedidoDAO getInstance(){
        if (instance == null){
            instance = new PedidoDAO();
        }
        return instance;
    }
    
    public void add(Pedido pedido){
        super.add(pedido);
    }

    public void remover(Pedido pedido){
        super.remove(pedido);
    }

    public void alterarEstado(Pedido pedido, EstadoPedido estado){
        super.filter("codigo", pedido.getCodigo());
    }
}
