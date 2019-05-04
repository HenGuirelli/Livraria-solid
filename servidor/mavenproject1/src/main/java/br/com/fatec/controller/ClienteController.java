package br.com.fatec.controller;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;

public class ClienteController {

    public List<Pedido> pegarPedidos(Cliente cliente) {
        ClienteDAO dao = ClienteDAO.getInstance();
        return dao.getPedidos(cliente);
    }

    public Cliente getCliente(String login) {
        ClienteDAO dao = ClienteDAO.getInstance();
        return dao.getCliente(login);
    }

    public List<Cliente> getClientes() {
        ClienteDAO dao = ClienteDAO.getInstance();
        return dao.getClientes();
    }
}
