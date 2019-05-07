package br.com.fatec.model.pagamento;

import br.com.fatec.model.produto.Produto;

public class PromocaoDecorator extends Decorator {

    private Produto produto;
    
    public PromocaoDecorator(Pagamento pagamento, Produto produto){
        super(pagamento);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    @Override
    public float calcularDesconto() {
        if (produto == null){
            return 0;
        }
        
        return produto.getPercentDesconto() + pagamento.calcularDesconto();
    }
    
}
