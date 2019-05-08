package br.com.fatec.controller;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.enums.FormaPagamento;
import br.com.fatec.model.pedido.Pedido;

public class DescontoController {
    public float calcularDesconto(FormaPagamento tipoPagamento, int pontosDoCliente){
        if (tipoPagamento == FormaPagamento.A_VISTA){
            return .1f + calcularPorcetagemDescontoPorPontos(pontosDoCliente);
        }else if (tipoPagamento == FormaPagamento.PARCELADO){
            return calcularPorcetagemDescontoPorPontos(pontosDoCliente);
        }
        return 0;
    }
    
    public Pedido aplicarDesconto(Pedido pedido){
        FormaPagamento formaPagamento = pedido.getFormaPagamento();
        int pontos = ClienteDAO.getInstance().getCliente(pedido.getCliente()).getPontos();
        float desconto = pedido.getValorTotal() * calcularDesconto(formaPagamento, pontos);
        
        pedido.setDesconto(desconto);
        
        return pedido;
    }
    
    private float calcularPorcetagemDescontoPorPontos(int pontos){
        // a cada 10 pontos 1% de desconto
        return pontos * .1f;
    }
}
