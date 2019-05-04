package br.com.fatec.model.usuario;

import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.pedido.Pedido;

public class Funcionario extends Usuario {
    public void alterarEstadoPedido(Pedido pedido, EstadoPedido estadoPedido){
        pedido.setEstado(estadoPedido);
    }
}
