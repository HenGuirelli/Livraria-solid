package br.com.fatec.model;

import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.Date;

public class Pedido {
    private Date data;
    private EstadoPedido estado;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
