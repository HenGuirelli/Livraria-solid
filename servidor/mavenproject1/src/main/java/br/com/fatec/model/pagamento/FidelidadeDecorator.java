package br.com.fatec.model.pagamento;

import br.com.fatec.model.usuario.Cliente;

public class FidelidadeDecorator extends Decorator {

    private Cliente cliente;

    public FidelidadeDecorator(Pagamento pagamento, Cliente cliente){
        super(pagamento);
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }    
    
    @Override
    public float calcularDesconto() {
        if (cliente == null){
            return 0;
        }
        float desconto = cliente.getPontos() * .1f;
        return desconto + pagamento.calcularDesconto();
    }
    
}
