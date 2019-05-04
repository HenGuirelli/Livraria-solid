package br.com.fatec.DAO;

import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.pedido.Pedido;
import java.util.List;

public class PedidoDAO extends DAO<Pedido> {

    private static PedidoDAO instance;

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        if (instance == null) {
            instance = new PedidoDAO();
        }
        return instance;
    }

    public void add(Pedido pedido) {
        super.add(pedido);
    }

    public void remover(Pedido pedido) {
        super.remove(pedido);
    }

    public void alterarEstado(Pedido pedido, EstadoPedido estado) {
        super.filter("codigo", pedido.getCodigo());
    }

    public List<Pedido> pegarTodos() {
        return super.getAll();
    }

    private List<Pedido> pegarPedidoPorStatus(EstadoPedido estado) {
        return super.filter("estado", estado.toString());
    }

    public List<Pedido> pegarPedidosEmAtendimento() {
        return pegarPedidoPorStatus(EstadoPedido.emAtendimento);
    }

    public List<Pedido> pegarPedidosEnviados() {
        return pegarPedidoPorStatus(EstadoPedido.enviado);
    }

    public List<Pedido> pegarPedidosEntregue() {
        return pegarPedidoPorStatus(EstadoPedido.entregue);
    }
}
