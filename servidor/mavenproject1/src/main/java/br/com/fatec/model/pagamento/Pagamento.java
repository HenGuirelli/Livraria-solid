package br.com.fatec.model.pagamento;

public abstract class Pagamento {
    private float valorTotal;
    private float valorComDesconto;

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getValorComDesconto() {
        return valorComDesconto;
    }

    public void setValorComDesconto(float valorComDesconto) {
        this.valorComDesconto = valorComDesconto;
    }
    
    public abstract float calcularDesconto();
}
