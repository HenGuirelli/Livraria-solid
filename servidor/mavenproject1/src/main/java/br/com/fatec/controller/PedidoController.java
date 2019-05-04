package br.com.fatec.controller;

import br.com.fatec.DAO.PedidoDAO;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
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
}
