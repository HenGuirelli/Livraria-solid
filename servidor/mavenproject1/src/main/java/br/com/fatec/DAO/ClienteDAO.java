package br.com.fatec.DAO;

import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO<Cliente> {

    private static ClienteDAO instance;

    private ClienteDAO() {
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public void add(Cliente cliente) {
        super.add(cliente);
    }

    public void remover(Cliente cliente) {
        super.remove(cliente);
    }

    public List<Cliente> getClientes() {
        ContaDAO dao = ContaDAO.getInstance();
        return dao.getClientes();
    }

    public Cliente getCliente(String login) {
        List<Cliente> clientes = getClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getLogin().equals(login)) {
                return cliente;
            }
        }
        return null;
    }
}
